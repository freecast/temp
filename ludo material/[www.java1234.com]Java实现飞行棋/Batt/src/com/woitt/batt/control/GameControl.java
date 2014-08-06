package com.woitt.batt.control;

import com.woitt.batt.service.impl.GameServiceImpl;
import com.woitt.batt.ui.GameFrame;

/**
 * 游戏控制类
 * @author zhangql
 *
 */
public class GameControl {
	
	private GameServiceImpl gameServiceImpl ;


	public GameControl(GameServiceImpl gameService){
		this.gameServiceImpl = gameService ;
	}

	/**
	 * 初始化游戏
	 * @param frame
	 */
	public void initGame(GameFrame frame ){	
		gameServiceImpl.initGame(frame) ;
		
	}
	
	/**
	 * 开始游戏
	 * @param frame
	 */
	public void startGame(GameFrame frame){
		gameServiceImpl.startGame(frame) ;
	}
	
	/**
	 * @return the gameServiceImpl
	 */
	public GameServiceImpl getGameServiceImpl() {
		return gameServiceImpl;
	}
	
	/**
	 * @param gameServiceImpl the gameServiceImpl to set
	 */
	public void setGameServiceImpl(GameServiceImpl gameServiceImpl) {
		this.gameServiceImpl = gameServiceImpl;
	}
	
	/**
	 * 重新开始游戏
	 */
	public void restartGame(GameFrame gameFrame){
		this.gameServiceImpl.restartGame(gameFrame) ;
	}
	
	/**
	 * 处理幸运数字
	 * @param justAChar
	 */
	public void setLuckyNumber(char justAChar){
		this.gameServiceImpl.setLuckyNumber(justAChar) ;
	}

}
