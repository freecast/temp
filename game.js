var platforms;
var hero;
var label_score;
var label_highscore;
var firstDeadDisc;
var timerEvents = new Array;
var rockTimerLo = 750;
var rockTimerHigh = 2750;
var ballTimerLo = 1e3;
var ballTimerHigh = 3e3;
var discTimerLo = 750;
var discTimerHigh = 2250;
var goldDiscTimerLo = 4e3;
var goldDiscTimerHigh = 6e3;
var screenwidth = 640;
var play_state = {
    create: function() {
        this.jump_sound = game.add.audio("jump");
        this.chime_sound = game.add.audio("chime");
        this.slap_sound = game.add.audio("slap");
        this.bark_sound = game.add.audio("bark");
        game.physics.startSystem(Phaser.Physics.ARCADE);
        platforms = game.add.group();
        platforms.enableBody = true;
        var e = platforms.create(0, game.world.height - 64, "ground");
        e.scale.setTo(2, 2);
        e.body.immovable = true;
        this.rocks = game.add.group();
        this.rocks.createMultiple(20, "rock");
        var t = this.getRandomInt(rockTimerLo, rockTimerHigh);
        this.rocktimer = game.time.events.loop(t, this.add_rock, this);
        timerEvents[0] = this.rocktimer;
        this.balls = game.add.group();
        this.balls.createMultiple(10, "ball");
        var n = this.getRandomInt(ballTimerLo, ballTimerHigh);
        this.balltimer = game.time.events.loop(n, this.add_ball, this);
        timerEvents[1] = this.balltimer;
        this.discs = game.add.group();
        this.discs.createMultiple(20, "disc");
        var r = this.getRandomInt(discTimerLo, discTimerHigh);
        this.disctimer = game.time.events.loop(r, this.add_disc, this);
        timerEvents[2] = this.disctimer;
        this.golddiscs = game.add.group();
        this.golddiscs.createMultiple(5, "golddisc");
        var i = this.getRandomInt(goldDiscTimerLo, goldDiscTimerHigh);
        this.golddisctimer = game.time.events.loop(i, this.add_golddisc, this);
        timerEvents[3] = this.golddisctimer;
        hero = game.add.sprite(50, 330, "herorun");
        hero.animations.add("run");
        hero.animations.play("run", 1e3, true);
        game.physics.enable(hero, Phaser.Physics.ARCADE);
        hero.body.gravity.y = 800;
        game.input.onDown.add(this.upclick, this);
        hero.anchor.setTo( - .2, .5);
        hero.body.collideWorldBounds = true;
        score = 0;
        var s = {
            font: "30px Georgia bold",
            fill: "#999999"
        };
        label_score = game.add.text(screenwidth - 40, 20, "0", s);
        label_score.anchor.setTo(.4, .4);
        var o = label_score.context.createLinearGradient(0, 0, 0, label_score.canvas.height);
        o.addColorStop(0, "#006699");
        o.addColorStop(1, "#00AAFF");
        label_score.fill = o;
        var u = {
            font: "30px Georgia bold",
            fill: "#550000"
        };
        label_highscore = game.add.text(screenwidth - 40, 50, highscore, u);
        label_highscore.anchor.setTo(.4, .4);
        var a = label_highscore.context.createLinearGradient(0, 0, 0, label_highscore.canvas.height);
        a.addColorStop(0, "#EC3932");
        a.addColorStop(1, "#941212");
        label_highscore.fill = a;
        var f = {
            font: "30px Georgia bold",
            fill: "#999999"
        };
        label_player = game.add.text(20, 20, playerNameLabel, f);
        var l = label_player.context.createLinearGradient(0, 0, 0, label_player.canvas.height);
        l.addColorStop(0, "#F7E382");
        l.addColorStop(1, "#F7A746");
        label_player.fill = l;
        if (senderIsReady == true) {
            window.messageBus.broadcast("STARTGAME," + playerNameLabel)
        }
    },
    update: function() {
        if (hero.angle < 20) hero.angle += 1;
        game.physics.arcade.collide(hero, platforms);
        game.physics.arcade.collide(this.balls, platforms);
        game.physics.arcade.collide(this.rocks, platforms);
        game.physics.arcade.overlap(hero, this.balls, this.hit_ball, null, this);
        game.physics.arcade.overlap(hero, this.rocks, this.hit_rock, null, this);
        game.physics.arcade.overlap(hero, this.discs, this.hit_disc, null, this);
        game.physics.arcade.overlap(hero, this.golddiscs, this.hit_golddisc, null, this);
        this.balls.forEachAlive(function(e) {
            e.body.angle += 45
        },
        this);
        if (hero.body.touching.down) {
            hero.animations.getAnimation("run").paused = false;
            hero.body.velocity.x = 0;
            hero.angle = 0
        }
    },
    add_rock: function() {
        var e = this.rocks.getFirstDead();
        game.physics.enable(e, Phaser.Physics.ARCADE);
        e.reset(screenwidth, 390);
        e.body.velocity.x = -200;
        e.body.velocity.y = 0;
        e.body.bounce.y = .2;
        e.body.gravity.y = 600;
        e.outOfBoundsKill = true;
        e.checkWorldBounds = true;
        e.body.collideWorldBounds = false;
        timerEvents[0].delay = this.getRandomInt(rockTimerLo, rockTimerHigh)
    },
    add_ball: function() {
        var e = this.balls.getFirstDead();
        game.physics.enable(e, Phaser.Physics.ARCADE);
        var t = this.getRandomInt(200, 400);
        e.reset(screenwidth, t);
        e.body.velocity.x = 0 - this.getRandomInt(250, 350);
        e.body.velocity.y = 0 - this.getRandomInt(150, 250);
        e.body.bounce.y = .7;
        e.body.gravity.y = 600;
        e.outOfBoundsKill = true;
        e.checkWorldBounds = true;
        e.body.collideWorldBounds = false;
        timerEvents[1].delay = this.getRandomInt(ballTimerLo, ballTimerHigh)
    },
    add_disc: function() {
        var e = this.getRandomInt(100, 250);
        var t = this.discs.getFirstDead();
        game.physics.enable(t, Phaser.Physics.ARCADE);
        t.reset(screenwidth, e);
        t.body.velocity.x = 0 - this.getRandomInt(350, 450);
        t.body.velocity.y = 0;
        t.body.gravity.y = 50;
        t.outOfBoundsKill = true;
        t.checkWorldBounds = true;
        t.body.collideWorldBounds = false;
        timerEvents[2].delay = this.getRandomInt(discTimerLo, discTimerHigh)
    },
    add_golddisc: function() {
        var e = this.getRandomInt(1, 100);
        var t = this.golddiscs.getFirstDead();
        game.physics.enable(t, Phaser.Physics.ARCADE);
        t.reset(screenwidth, e);
        t.body.velocity.x = 0 - this.getRandomInt(350, 450);
        t.body.velocity.y = 0;
        t.body.gravity.y = 50;
        t.outOfBoundsKill = true;
        t.checkWorldBounds = true;
        t.body.collideWorldBounds = false;
        timerEvents[3].delay = this.getRandomInt(goldDiscTimerLo, goldDiscTimerHigh)
    },
    upclick: function(e, t) {
        var n = (50 + 480 - t.y) * 40;
        console.log(t.y);
        console.log(n);
        this.up(0, -n)
    },
    up: function(e, t) {
        if (hero.alive == false || !hero.body.touching.down) return;
        hero.animations.getAnimation("run").paused = true;
        hero.body.velocity.x = 0;
        var n = 20;
        if (t > 0) hero.body.velocity.y = 0;
        else if (t <= 0 && t > -8e3) hero.body.velocity.y = -8e3 / n;
        else hero.body.velocity.y = Math.max( - 800, t / n);
        this.game.add.tween(hero).to({
            angle: -25
        },
        100).start();
        this.jump_sound.play()
    },
    hit_rock: function() {
        if (hero.alive == false) return;
        this.slap_sound.play();
        this.bark_sound.play();
        hero.alive = false;
        hero.visible = false;
        this.restart_game()
    },
    hit_ball: function(e, t) {
        if (e.alive == false) return;
        this.chime_sound.play();
        t.kill();
        this.addToScore(1)
    },
    hit_disc: function(e, t) {
        if (e.alive == false) return;
        this.chime_sound.play();
        t.kill();
        this.addToScore(2)
    },
    hit_golddisc: function(e, t) {
        if (e.alive == false) return;
        this.bark_sound.play();
        t.kill();
        this.addToScore(3)
    },
    addToScore: function(e) {
        score += e;
        label_score.text = score;
        if (score > highscore) {
            highscore = score
        }
        label_highscore.text = highscore;
        if (senderIsReady == true) {
            window.messageBus.broadcast("SCORE," + score + "," + playerNameLabel + "," + e)
        }
    },
    restart_game: function() {
        for (var e = 0; e < timerEvents.length; e++) {
            game.time.events.remove(timerEvents[e])
        }
        if (senderIsReady == true) {
            window.messageBus.broadcast("ENDGAME," + playerNameLabel)
        }
        game.state.start("menu")
    },
    getRandomInt: function(e, t) {
        return Math.floor(Math.random() * (t - e + 1)) + e
    }
}