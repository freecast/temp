package com.woitt.batt.dispose;

import java.awt.Point;

/**
 * 游戏相关参数和配置
 * @author zhangql
 *
 */
public class GameDispose {

	/**
	 * 游戏窗口宽度
	 */
	public static final int WINDOW_W = 480;
	/**
	 * 游戏窗口高度
	 */
	public static final int WINDOW_H = 735;

	/**
	 * 游戏窗口里屏幕顶端的距离
	 */
	public static final int PADDING = 10;
	
	/**
	 * 每种颜色的初始化飞机数量
	 */
	public static final int PLANE_NUMBER = 4 ; 
	
	/**
	 * 游戏背景图片路径
	 */
	public static final String GAME_MAP_URL = "res//image//map//map.png" ;
	
	/**
	 * 游戏飞机图片所在目录
	 */
	public static final String PLANE_IMG_URL = "res//image//plane//" ;
	
	/**
	 * 背景音乐相对路径
	 */
	public static final String BGM_URL = "res//sound//bgm.wav" ;
	
	/**
	 * 掷色子声效相对路径
	 */
	public static final String DICE_RING_URL = "res//sound//dice_ring.wav" ;
	
	/**
	 * 色子图片目录URL
	 */
	public static final String DICE_ICON_URL = "res//image//dice" ;
	
	/**
	 * 提醒掷色子的图片路径
	 */
	public static final String REMIND_THROW_URL = "res//image//remind//" ;
	
	/**
	 * 提醒掷色子掷到六的图片路径
	 */
	public static final String THROW_SIX = "res//image//remind//" ;
	
	/**
	 * 红色皇冠路径
	 */
	public static final String RED_CROWN = "res//image//crown//red_crown.png" ;
	
	/**黄色皇冠路径
	 * 
	 */
	public static final String YELLOW_CROWN = "res//image//crown//yellow_crown.png" ;
	
	/**
	 * 绿色皇冠路径
	 */
	public static final String GREEN_CROWN = "res//image//crown//green_crown.png" ;
	
	/**
	 * 蓝色皇冠路径
	 */
	public static final String BLUE_CROWN = "res//image//crown//blue_crown.png" ;
	
	/**
	 * 到达时的音效
	 */
	public static final String ARRIVE_RING_URL = "res//sound//arrive.wav" ;
	
	/**
	 * 撞击时的音效
	 */
	public static final String CRASH_RING_URL = "res//sound//crash.wav" ;
	
	/**
	 * 起飞时的音效
	 */
	public static final String LANDOD_RING_URL = "res//sound//landoff.wav" ;
	
	/**
	 * 飞机跳跃是的音效
	 */
	public static final String JUMP_RING_URL = "res//sound//jump.wav";
	
	/**
	 * 即将胜利的音效
	 */
	public static final String NEAR_WIN_RING_URL = "res//sound//nearwin.wav" ;
	
	/**
	 * 胜利音效
	 */
	public static final String VICTORY_RING_URL = "res//sound//victory.wav" ;
	
	/**
	 * 失败音效
	 */
	public static final String DEFEAT_RING_URL = "res//sound//defeat.wav" ;
	
	/**
	 * 电源图标路径
	 */
	public static final String SOURCE_INCO_URL = "res//image//other//source.png" ;
	
	
	/**
	 * 红色飞机在老家第一个位置的坐标
	 */
	public static final Point RED_FIRST_LOC = new Point(4,499) ;
	
	/**
	 * 黄色飞机在老家第一个位置的坐标
	 */
	public static final Point YELLOW_FIRST_LOC = new Point(24,127) ;
	
	/**
	 * 绿色飞机在老家第一个位置的坐标
	 */
	public static final Point GREEN_FIRST_LOC = new Point(396,147) ;
	
	/**
	 * 蓝色飞机在老家第一个位置的坐标
	 */
	public static final Point BLUE_FIRST_LOC = new Point(376,519) ;
	
	

	/**
	 *	黄色飞机方的色子位置
	 */
	public static final Point YELLOW_DICE = new Point(13,30) ;

	/**
	 *	绿色飞机方的色子位置
	 */
	public static final Point GREEN_DICE = new Point(380,30) ;
	
	/**
	 *	蓝色飞机方的色子位置
	 */
	public static final Point BLUE_DICE = new Point(380,610) ;
	
	/**
	 *	红色飞机方的色子位置
	 */
	public static final Point RED_DICE = new Point(13,610) ;
	
	/**
	 * 红色飞机出发点坐标
	 */
	public static final Point RED_LAUNCH = new Point(89,568) ;
	
	/**
	 * 黄色飞机出发点坐标
	 */
	public static final Point YELLOW_LAUNCH = new Point(0,214) ;
	
	/**
	 * 绿色飞机出发点坐标
	 */
	public static final Point GREEN_LAUNCH = new Point(356,123) ;
	
	/**
	 * 蓝色飞机出发点坐标
	 */
	public static final Point BLUE_LAUNCH = new Point(447,478) ;
	
	/**
	 * 电源位置
	 */
	public static final Point SOURCE_LOC = new Point (445,700) ;
	/**
	 * 飞机图片宽度
	 */
	public static final int PLANE_SIZE = 38 ; 
	
	/**
	 * 棋盘行数
	 */
	public static final int CELL_ROWS = 15 ;
	
	/**
	 * 航线总格子数
	 */
	public static final int PATH_CAPACITANCE = 57;
	
	/**
	 * 外环总格子数
	 */
	public static final int LIST_PATN_CAPACITANCE = 53 ;
	
	/**
	 * 十字架总格子数
	 */
	public static final int CROSS_PATH_CAPACITANCE = 24 ;
	
	/**
	 * 颜色数组
	 * 分别是蓝，红，黄，绿
	 */
	public static final String[] COLORARRAY = new String[]{"b","r","y","g"} ;
}
