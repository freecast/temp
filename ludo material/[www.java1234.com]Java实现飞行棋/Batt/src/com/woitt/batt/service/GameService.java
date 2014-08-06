package com.woitt.batt.service;

import com.woitt.batt.entiry.Dice;
import com.woitt.batt.ui.GameFrame;

/**
 * ��Ϸ����ӿ�
 * @author zhangql
 *
 */
public interface GameService {

	/**
	 * ��ʼ����Ϸ
	 */
	public void initGame(GameFrame frame) ;
	
	/**
	 * ��ʼ��Ϸ
	 */
	public void startGame(GameFrame frame) ;
	
	/**
	 * ��ɫ��
	 * @param dice
	 */
	public void throwDice(Dice dice) ;
	
	/**
	 * �ж������ɫ�ӽ��
	 * @param flag
	 * @param diceNumber
	 */
	public void judgePlayerThrowResult(int flag , int diceNumber) ;
	
	/**
	 * �жϵ�����ɫ�ӽ��
	 * @param flag
	 * @param diceNumber
	 */
	public void judgeCompThrowResult(int flag ,int diceNumber) ;
	
	/**
	 * �ж���Ӯ���
	 * 
	 * @return
	 * -1��û���κ�һ��Ӯ��
	 * 0����Ӯ��
	 * 1���Ʒ�Ӯ
	 * 2���̷�Ӯ
	 * 3������Ӯ
	 */
	public int  judgeIsWin(int flag) ;
	
	/**
	 * ���¿�ʼ��Ϸ
	 */
	public void restartGame(GameFrame gameFrame) ;
	
	/**
	 * ������������
	 * @param justAChar
	 */
	public void setLuckyNumber(char justAChar) ;
}
