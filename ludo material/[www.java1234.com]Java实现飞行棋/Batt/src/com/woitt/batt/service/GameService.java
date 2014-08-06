package com.woitt.batt.service;

import com.woitt.batt.entiry.Dice;
import com.woitt.batt.ui.GameFrame;

/**
 * 游戏服务接口
 * @author zhangql
 *
 */
public interface GameService {

	/**
	 * 初始化游戏
	 */
	public void initGame(GameFrame frame) ;
	
	/**
	 * 开始游戏
	 */
	public void startGame(GameFrame frame) ;
	
	/**
	 * 掷色子
	 * @param dice
	 */
	public void throwDice(Dice dice) ;
	
	/**
	 * 判断玩家掷色子结果
	 * @param flag
	 * @param diceNumber
	 */
	public void judgePlayerThrowResult(int flag , int diceNumber) ;
	
	/**
	 * 判断电脑掷色子结果
	 * @param flag
	 * @param diceNumber
	 */
	public void judgeCompThrowResult(int flag ,int diceNumber) ;
	
	/**
	 * 判断输赢情况
	 * 
	 * @return
	 * -1，没有任何一方赢，
	 * 0，你赢了
	 * 1，黄方赢
	 * 2，绿方赢
	 * 3，蓝方赢
	 */
	public int  judgeIsWin(int flag) ;
	
	/**
	 * 重新开始游戏
	 */
	public void restartGame(GameFrame gameFrame) ;
	
	/**
	 * 处理幸运数字
	 * @param justAChar
	 */
	public void setLuckyNumber(char justAChar) ;
}
