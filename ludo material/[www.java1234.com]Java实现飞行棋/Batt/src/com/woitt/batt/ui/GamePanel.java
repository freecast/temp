package com.woitt.batt.ui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.woitt.batt.control.GameControl;
import com.woitt.batt.dispose.GameDispose;
import com.woitt.batt.entiry.BGMPlayer;
import com.woitt.batt.entiry.Cell;
import com.woitt.batt.entiry.Dice;
import com.woitt.batt.entiry.Plane;
import com.woitt.batt.entiry.Role;
import com.woitt.batt.res.GameRes;

public class GamePanel extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameControl gameConrol;

	private GameFrame gameFrame ;
	
	private Thread bgmThread ;
	
	private BGMPlayer bgmPlayer ;
	

	/**
	 * 
	 * @param gameControl
	 * @param playerControl
	 */
	public GamePanel(GameControl gameControl) {

		this.setGameConrol(gameControl);
		// 设置面板大小
		this.setSize(GameDispose.WINDOW_W, GameDispose.WINDOW_H);
		// 设置面板布局为任意布局
		this.setLayout(null);

	}

	@Override
	/**
	 * 重写JPanel的paint方法，绘制游戏界面
	 */
	public void paintComponent(Graphics g) {
		// 绘制游戏背景
		g.drawImage(GameRes.GAME_MAP, 0, 0, null);
	}

	/**
	 * 初始化游戏界面
	 * 
	 * @param g
	 */
	public void initPanel() {

		//打开背景音乐
		openBGM() ;
		//初始化玩家
		this.initPlayers();
		//初始化色子
		this.initDices();
		//初始化所有老家
		this.initHome() ;
		//添加电源
		this.addSource();
		
		
		this.repaint();

	}

	/**
	 * 打开背景音乐
	 */
	public void openBGM(){
		bgmPlayer = new BGMPlayer(this.getGameConrol().getGameServiceImpl().getGameData(), Integer.MAX_VALUE , GameDispose.BGM_URL) ;
		bgmThread = new Thread(bgmPlayer);
		bgmThread.start();
	}
	/**
	 * 初始化老家
	 */
	private void initHome(){
		Plane[] redP = this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[0].getPlanes() ;
		Cell[] redH = this.getGameConrol().getGameServiceImpl().getGameData().getRedHome() ;
		
		Plane[] yellowP = this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[1].getPlanes() ;
		Cell[] yellowH = this.getGameConrol().getGameServiceImpl().getGameData().getYellowHome() ;
		
		Plane[] greenP = this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[2].getPlanes() ;
		Cell[] greenH = this.getGameConrol().getGameServiceImpl().getGameData().getGreenHome() ;
		
		Plane[] blueP = this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[3].getPlanes() ;
		Cell[] blueH = this.getGameConrol().getGameServiceImpl().getGameData().getBlueHome() ;
				
		for(int i = 0 ;i<4 ;i++){
			redP[i].setLocation(redH[i].getLocation()) ;
			this.add(redP[i]) ;
			
			yellowP[i].setLocation(yellowH[i].getLocation()) ;
			this.add(yellowP[i]) ;
			
			greenP[i].setLocation(greenH[i].getLocation()) ;
			this.add(greenP[i]) ;
			
			blueP[i].setLocation(blueH[i].getLocation()) ;
			this.add(blueP[i]) ;
			
		}
		
		
	}
	/**
	 * 初始化色子
	 */
	private void initDices() {
		// 初始化色子
		Dice dice1 = new Dice(true, this.getGameConrol());
		dice1.setLocation(GameDispose.RED_DICE);
		Dice dice2 = new Dice(false, this.getGameConrol());
		dice2.setLocation(GameDispose.YELLOW_DICE);
		Dice dice3 = new Dice(false, this.getGameConrol());
		dice3.setLocation(GameDispose.GREEN_DICE);
		Dice dice4 = new Dice(false, this.getGameConrol());
		dice4.setLocation(GameDispose.BLUE_DICE);
		this.add(dice1);
		this.add(dice2);
		this.add(dice3);
		this.add(dice4);

		
		this.getGameConrol().getGameServiceImpl().getGameData().getDices()[0] = dice1 ;
		this.getGameConrol().getGameServiceImpl().getGameData().getDices()[1] = dice2 ;
		this.getGameConrol().getGameServiceImpl().getGameData().getDices()[2] = dice3 ;
		this.getGameConrol().getGameServiceImpl().getGameData().getDices()[3] = dice4 ;
	}


	/**
	 * 初始化玩家
	 */
	private void initPlayers() {
		this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[0] = new Role(true, Plane.TYPE_RED, this)  ;
		this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[1] = new Role(true, Plane.TYPE_YELLOW, this) ;
		this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[2] = new Role(true, Plane.TYPE_GREEN, this) ;
		this.getGameConrol().getGameServiceImpl().getGameData().getPlayers()[3] = new Role(true, Plane.TYPE_BLUE, this) ;
	}

	/**
	 * 添加电源
	 */
	private void addSource(){
		JLabel source = new JLabel() ;
		
		source.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gameFrame.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gameFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)) ;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp = JOptionPane.showConfirmDialog(null, "确定要关闭游戏吗？") ;
				if(temp == 0)
					System.exit(0) ;
			}
		}) ;
		
		
		source.setSize(30, 30) ;
		source.setToolTipText("点击关闭游戏") ;
		source.setIcon(GameRes.SOURCE_ICON) ;
		source.setLocation(GameDispose.SOURCE_LOC) ;
		this.add(source) ;
		
	}
	/**
	 * @return the gameConrol
	 */
	public GameControl getGameConrol() {
		return gameConrol;
	}

	/**
	 * @param gameConrol
	 *            the gameConrol to set
	 */
	public void setGameConrol(GameControl gameConrol) {
		this.gameConrol = gameConrol;
	}

	/**
	 * @return the gameFrame
	 */
	public GameFrame getGameFrame() {
		return gameFrame;
	}

	/**
	 * @param gameFrame the gameFrame to set
	 */
	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	/**
	 * @return the bgmThread
	 */
	public Thread getBgmThread() {
		return bgmThread;
	}

	/**
	 * @param bgmThread the bgmThread to set
	 */
	public void setBgmThread(Thread bgmThread) {
		this.bgmThread = bgmThread;
	}

	/**
	 * @return the bgmPlayer
	 */
	public BGMPlayer getBgmPlayer() {
		return bgmPlayer;
	}

	/**
	 * @param bgmPlayer the bgmPlayer to set
	 */
	public void setBgmPlayer(BGMPlayer bgmPlayer) {
		this.bgmPlayer = bgmPlayer;
	}


}
