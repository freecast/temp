var load_state = {
    preload: function() {
        this.game.stage.backgroundColor = "#007070";
        this.game.load.audio("jump", "jump.ogg");
        this.game.load.audio("slap", "slap.ogg");
        this.game.load.audio("bark", "bark.ogg");
        this.game.load.audio("chime", "chime.ogg");
        this.game.load.spritesheet("herorun", "herorun_40x57.png", 40, 57, 2);
        this.game.load.image("hero", "hero.png");
        this.game.load.image("ball", "ball.png");
        this.game.load.image("rock", "rock.png");
        this.game.load.image("title", "title.png");
        this.game.load.image("ground", "ground2.png");
        this.game.load.image("disc", "disc.png");
        this.game.load.image("golddisc", "golddisc.png");
        cast.receiver.logger.setLevelValue(0);
        window.castReceiverManager = cast.receiver.CastReceiverManager.getInstance();
        console.log("Starting Receiver Manager");
        castReceiverManager.onReady = function(e) {
            console.log("Received Ready event: " + JSON.stringify(e.data));
            window.castReceiverManager.setApplicationState("Application status is ready...")
        };
        castReceiverManager.onSenderConnected = function(e) {
            console.log("Received Sender Connected event: " + e.data);
            senderIsReady = true;
            console.log(window.castReceiverManager.getSender(e.data).userAgent)
        };
        castReceiverManager.onSenderDisconnected = function(e) {
            console.log("Received Sender Disconnected event: " + e.data);
            if (window.castReceiverManager.getSenders().length == 0) {
                senderIsReady = false;
                window.close()
            }
        };
        window.messageBus = window.castReceiverManager.getCastMessageBus("urn:x-cast:com.veenvliet.cast.dogpark");
        window.messageBus.onMessage = function(e) {
            console.log("Message [" + e.senderId + "]: " + e.data);
            window.castReceiverManager.setApplicationState(e.data);
            if (e.data.indexOf("START") == 0 && game_started == false) {
                var t = new Array;
                t = e.data.split(",");
                playerNameLabel = t[1];
                menu_state.start()
            } else if (e.data.indexOf("JUMP") == 0) {
                var t = new Array;
                t = e.data.split(",");
                var n = t[3];
                if (n == playerNameLabel) {
                    var r = parseFloat(t[1]);
                    var i = parseFloat(t[2]);
                    play_state.up(r, i)
                }
            }
        }
    },
    create: function() {
        window.castReceiverManager.start({
            statusText: "Application is starting"
        });
        console.log("Receiver Manager started");
        this.game.state.start("menu")
    }
}