package com.woitt.batt.dispose;

import java.awt.Point;

/**
 * ��Ϸ��ز���������
 * @author zhangql
 *
 */
public class GameDispose {

	/**
	 * ��Ϸ���ڿ��
	 */
	public static final int WINDOW_W = 480;
	/**
	 * ��Ϸ���ڸ߶�
	 */
	public static final int WINDOW_H = 735;

	/**
	 * ��Ϸ��������Ļ���˵ľ���
	 */
	public static final int PADDING = 10;
	
	/**
	 * ÿ����ɫ�ĳ�ʼ���ɻ�����
	 */
	public static final int PLANE_NUMBER = 4 ; 
	
	/**
	 * ��Ϸ����ͼƬ·��
	 */
	public static final String GAME_MAP_URL = "res//image//map//map.png" ;
	
	/**
	 * ��Ϸ�ɻ�ͼƬ����Ŀ¼
	 */
	public static final String PLANE_IMG_URL = "res//image//plane//" ;
	
	/**
	 * �����������·��
	 */
	public static final String BGM_URL = "res//sound//bgm.wav" ;
	
	/**
	 * ��ɫ����Ч���·��
	 */
	public static final String DICE_RING_URL = "res//sound//dice_ring.wav" ;
	
	/**
	 * ɫ��ͼƬĿ¼URL
	 */
	public static final String DICE_ICON_URL = "res//image//dice" ;
	
	/**
	 * ������ɫ�ӵ�ͼƬ·��
	 */
	public static final String REMIND_THROW_URL = "res//image//remind//" ;
	
	/**
	 * ������ɫ����������ͼƬ·��
	 */
	public static final String THROW_SIX = "res//image//remind//" ;
	
	/**
	 * ��ɫ�ʹ�·��
	 */
	public static final String RED_CROWN = "res//image//crown//red_crown.png" ;
	
	/**��ɫ�ʹ�·��
	 * 
	 */
	public static final String YELLOW_CROWN = "res//image//crown//yellow_crown.png" ;
	
	/**
	 * ��ɫ�ʹ�·��
	 */
	public static final String GREEN_CROWN = "res//image//crown//green_crown.png" ;
	
	/**
	 * ��ɫ�ʹ�·��
	 */
	public static final String BLUE_CROWN = "res//image//crown//blue_crown.png" ;
	
	/**
	 * ����ʱ����Ч
	 */
	public static final String ARRIVE_RING_URL = "res//sound//arrive.wav" ;
	
	/**
	 * ײ��ʱ����Ч
	 */
	public static final String CRASH_RING_URL = "res//sound//crash.wav" ;
	
	/**
	 * ���ʱ����Ч
	 */
	public static final String LANDOD_RING_URL = "res//sound//landoff.wav" ;
	
	/**
	 * �ɻ���Ծ�ǵ���Ч
	 */
	public static final String JUMP_RING_URL = "res//sound//jump.wav";
	
	/**
	 * ����ʤ������Ч
	 */
	public static final String NEAR_WIN_RING_URL = "res//sound//nearwin.wav" ;
	
	/**
	 * ʤ����Ч
	 */
	public static final String VICTORY_RING_URL = "res//sound//victory.wav" ;
	
	/**
	 * ʧ����Ч
	 */
	public static final String DEFEAT_RING_URL = "res//sound//defeat.wav" ;
	
	/**
	 * ��Դͼ��·��
	 */
	public static final String SOURCE_INCO_URL = "res//image//other//source.png" ;
	
	
	/**
	 * ��ɫ�ɻ����ϼҵ�һ��λ�õ�����
	 */
	public static final Point RED_FIRST_LOC = new Point(4,499) ;
	
	/**
	 * ��ɫ�ɻ����ϼҵ�һ��λ�õ�����
	 */
	public static final Point YELLOW_FIRST_LOC = new Point(24,127) ;
	
	/**
	 * ��ɫ�ɻ����ϼҵ�һ��λ�õ�����
	 */
	public static final Point GREEN_FIRST_LOC = new Point(396,147) ;
	
	/**
	 * ��ɫ�ɻ����ϼҵ�һ��λ�õ�����
	 */
	public static final Point BLUE_FIRST_LOC = new Point(376,519) ;
	
	

	/**
	 *	��ɫ�ɻ�����ɫ��λ��
	 */
	public static final Point YELLOW_DICE = new Point(13,30) ;

	/**
	 *	��ɫ�ɻ�����ɫ��λ��
	 */
	public static final Point GREEN_DICE = new Point(380,30) ;
	
	/**
	 *	��ɫ�ɻ�����ɫ��λ��
	 */
	public static final Point BLUE_DICE = new Point(380,610) ;
	
	/**
	 *	��ɫ�ɻ�����ɫ��λ��
	 */
	public static final Point RED_DICE = new Point(13,610) ;
	
	/**
	 * ��ɫ�ɻ�����������
	 */
	public static final Point RED_LAUNCH = new Point(89,568) ;
	
	/**
	 * ��ɫ�ɻ�����������
	 */
	public static final Point YELLOW_LAUNCH = new Point(0,214) ;
	
	/**
	 * ��ɫ�ɻ�����������
	 */
	public static final Point GREEN_LAUNCH = new Point(356,123) ;
	
	/**
	 * ��ɫ�ɻ�����������
	 */
	public static final Point BLUE_LAUNCH = new Point(447,478) ;
	
	/**
	 * ��Դλ��
	 */
	public static final Point SOURCE_LOC = new Point (445,700) ;
	/**
	 * �ɻ�ͼƬ���
	 */
	public static final int PLANE_SIZE = 38 ; 
	
	/**
	 * ��������
	 */
	public static final int CELL_ROWS = 15 ;
	
	/**
	 * �����ܸ�����
	 */
	public static final int PATH_CAPACITANCE = 57;
	
	/**
	 * �⻷�ܸ�����
	 */
	public static final int LIST_PATN_CAPACITANCE = 53 ;
	
	/**
	 * ʮ�ּ��ܸ�����
	 */
	public static final int CROSS_PATH_CAPACITANCE = 24 ;
	
	/**
	 * ��ɫ����
	 * �ֱ��������죬�ƣ���
	 */
	public static final String[] COLORARRAY = new String[]{"b","r","y","g"} ;
}
