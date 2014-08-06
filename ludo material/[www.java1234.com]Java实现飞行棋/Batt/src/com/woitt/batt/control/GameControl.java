package com.woitt.batt.control;

import com.woitt.batt.service.impl.GameServiceImpl;
import com.woitt.batt.ui.GameFrame;

/**
 * ��Ϸ������
 * @author zhangql
 *
 */
public class GameControl {
	
	private GameServiceImpl gameServiceImpl ;


	public GameControl(GameServiceImpl gameService){
		this.gameServiceImpl = gameService ;
	}

	/**
	 * ��ʼ����Ϸ
	 * @param frame
	 */
	public void initGame(GameFrame frame ){	
		gameServiceImpl.initGame(frame) ;
		
	}
	
	/**
	 * ��ʼ��Ϸ
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
	 * ���¿�ʼ��Ϸ
	 */
	public void restartGame(GameFrame gameFrame){
		this.gameServiceImpl.restartGame(gameFrame) ;
	}
	
	/**
	 * ������������
	 * @param justAChar
	 */
	public void setLuckyNumber(char justAChar){
		this.gameServiceImpl.setLuckyNumber(justAChar) ;
	}

}
