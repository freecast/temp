package com.woitt.batt.entiry;


import com.woitt.batt.data.GameData;

/**
 * �������ֲ�����
 * @author zhangql
 *
 */
public class BGMPlayer extends SoundsPlayer implements Runnable{

	public BGMPlayer(GameData gameData,int playTimes,String soundsURL){
		super(gameData,playTimes,soundsURL) ;
	}
}
