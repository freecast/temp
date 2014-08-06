package com.woitt.batt.data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.woitt.batt.dispose.GameDispose;
import com.woitt.batt.entiry.Cell;
import com.woitt.batt.entiry.Dice;
import com.woitt.batt.entiry.Plane;
import com.woitt.batt.entiry.Role;

/**
 * 游戏实时数据类
 * 
 * @author zhangql
 * 
 */
public class GameData {

	/**
	 * 游戏是否开始
	 */
	private boolean isStart = true;

	/**
	 * 是否播放背景音乐
	 */
	private boolean isPlayBGM = false;

	/**
	 * 红色飞机数组
	 */
	private Plane[] redP = new Plane[4];
	/**
	 * 蓝色飞机数组
	 */
	private Plane[] blueP = new Plane[4];
	/**
	 * 绿色飞机数组
	 */
	private Plane[] greenP = new Plane[4];
	/**
	 * 黄色飞机数组
	 */
	private Plane[] yellowP = new Plane[4];
	
	/**
	 * 神秘数字
	 */
	private int luckyNumber = -1 ;
	
	/**
	 * 幸运数字使用次数
	 */

	private int chance = 3;
	/**
	 * 外环线路
	 */
	private List<Cell> pathList = new ArrayList<Cell>(
			GameDispose.LIST_PATN_CAPACITANCE);

	/**
	 * 十字架线路
	 */
	private List<Cell> crossList = new ArrayList<Cell>(
			GameDispose.CROSS_PATH_CAPACITANCE);
	/**
	 * 红棋线路
	 */
	private List<Cell> redList = new ArrayList<Cell>(
			GameDispose.PATH_CAPACITANCE);

	/**
	 * 绿棋线路
	 */
	private List<Cell> greenList = new ArrayList<Cell>(
			GameDispose.PATH_CAPACITANCE);

	/**
	 * 蓝棋线路
	 */
	private List<Cell> blueList = new ArrayList<Cell>(
			GameDispose.PATH_CAPACITANCE);

	/**
	 * 黄棋线路
	 */
	private List<Cell> yellowList = new ArrayList<Cell>(
			GameDispose.PATH_CAPACITANCE);

	
	/**
	 * 游戏玩家数组
	 * 0，红色
	 * 1，黄色
	 * 2，绿色
	 * 3，蓝色
	 */
	private Role[] players = new Role[4];

	/**
	 * 红色玩家老家
	 */
	private Cell[] redHome = new Cell[4];

	/**
	 * 红色玩家老家
	 */
	private Cell[] yellowHome = new Cell[4];

	/**
	 * 红色玩家老家
	 */
	private Cell[] greenHome = new Cell[4];

	/**
	 * 红色玩家老家
	 */
	private Cell[] blueHome = new Cell[4];

	/**
	 * 当前角色编号 0为红色 1为黄色 2为绿色 3为蓝色
	 */
	private int currentRole = 0;

	/**
	 * 游戏色子数组 0，红色用户 1，黄色用户 2，绿色用户 3，蓝色用户
	 */
	private Dice[] dices = new Dice[4];

	/**
	 * 玩家是否投掷色子
	 */
	private boolean isClick = false;
	
	/**
	 * 当前选择的飞机编号
	 */
	private int NumberOfCurrentPlane = -1;
	
	/**
	 * 背景音乐是否已经改变
	 */
	private boolean isChangeBGM = false ;
	{

		// 初始化所有飞机
		for (int i = 0; i < GameDispose.PLANE_NUMBER; i++) {
			this.getPlane(Plane.TYPE_BLUE)[i] = new Plane(Plane.TYPE_BLUE,
					Plane.UP, false,i,this);
			this.getPlane(Plane.TYPE_RED)[i] = new Plane(Plane.TYPE_RED,
					Plane.RIGHT, true,i,this);
			this.getPlane(Plane.TYPE_GREEN)[i] = new Plane(Plane.TYPE_GREEN,
					Plane.LEFT, false,i,this);
			this.getPlane(Plane.TYPE_YELLOW)[i] = new Plane(Plane.TYPE_YELLOW,
					Plane.DOWN, false,i,this);
		}

		// 初始化当前角色编号
		this.setCurrentRole(0);

		// 初始化外环线路
		for (int i = 0; i < GameDispose.LIST_PATN_CAPACITANCE; i++) {

			if (i < 1) {
				Cell cell = new Cell(getPiontByRC(14, 3), null);
				this.pathList.add(cell);
			} else if (i < 5) {
				Cell cell = new Cell(getPiontByRC(15 - i, 4),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.UP);
				this.pathList.add(cell);

			} else if (i < 8) {

				Cell cell = new Cell(getPiontByRC(10, 8 - i),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.LEFT);
				this.pathList.add(cell);
			} else if (i < 14) {
				Cell cell = new Cell(getPiontByRC(18 - i, 0),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.UP);
				this.pathList.add(cell);
			} else if (i < 18) {

				Cell cell = new Cell(getPiontByRC(4, i - 14),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.RIGHT);
				this.pathList.add(cell);
			} else if (i < 21) {
				Cell cell = new Cell(getPiontByRC(21 - i, 4),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.UP);
				this.pathList.add(cell);
			} else if (i < 27) {
				Cell cell = new Cell(getPiontByRC(0, i - 17),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.RIGHT);
				this.pathList.add(cell);
			} else if (i < 31) {
				Cell cell = new Cell(getPiontByRC(i - 27, 10),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.DOWN);
				this.pathList.add(cell);
			} else if (i < 34) {
				Cell cell = new Cell(getPiontByRC(4, i - 20),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.RIGHT);
				this.pathList.add(cell);
			} else if (i < 40) {
				Cell cell = new Cell(getPiontByRC(i - 30, 14),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.DOWN);
				this.pathList.add(cell);
			} else if (i < 44) {
				Cell cell = new Cell(getPiontByRC(10, 54 - i),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.LEFT);
				this.pathList.add(cell);
			} else if (i < 47) {
				Cell cell = new Cell(getPiontByRC(i - 33, 10),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.DOWN);
				this.pathList.add(cell);
			} else if (i < 53) {
				Cell cell = new Cell(getPiontByRC(14, 57 - i),
						GameDispose.COLORARRAY[(i - 1) % 4]);
				cell.setDirection(Plane.LEFT);
				this.pathList.add(cell);
			}
		}

		// 初始化十字架线路
		for (int i = 0; i < GameDispose.CROSS_PATH_CAPACITANCE; i++) {
			// 初始化顺序为红，黄，绿，蓝
			if (i < 6) {
				Cell cell = new Cell(getPiontByRC(13 - i, 7),
						GameDispose.COLORARRAY[1]);
				cell.setDirection(Plane.UP);
				this.crossList.add(cell);
			} else if (i < 12) {
				Cell cell = new Cell(getPiontByRC(7, i - 5),
						GameDispose.COLORARRAY[2]);
				cell.setDirection(Plane.RIGHT);
				this.crossList.add(cell);
			} else if (i < 18) {
				Cell cell = new Cell(getPiontByRC(i - 11, 7),
						GameDispose.COLORARRAY[3]);
				cell.setDirection(Plane.DOWN);
				this.crossList.add(cell);
			} else if (i < 24) {
				Cell cell = new Cell(getPiontByRC(7, 31 - i),
						GameDispose.COLORARRAY[0]);
				cell.setDirection(Plane.LEFT);
				this.crossList.add(cell);
			}
		}

		// 初始化红棋路线
		this.redList.addAll(this.pathList.subList(1, 51));
		this.redList.addAll(this.crossList.subList(0, 6));

		// 初始化黄棋路线
		this.yellowList.addAll(this.pathList.subList(14, 53));
		this.yellowList.addAll(this.pathList.subList(1, 12));
		this.yellowList.addAll(this.crossList.subList(6, 12));

		// 初始化绿棋路线
		this.greenList.addAll(this.pathList.subList(27, 53));
		this.greenList.addAll(this.pathList.subList(1, 25));
		this.greenList.addAll(this.crossList.subList(12, 18));

		// 初始化蓝棋路线
		this.blueList.addAll(this.pathList.subList(40, 53));
		this.blueList.addAll(this.pathList.subList(1, 38));
		this.blueList.addAll(this.crossList.subList(18, 24));

		// 初始化所有玩家老家
		for (int i = 0; i < 4; i++) {
			this.redHome[i] = new Cell(getLoc(GameDispose.RED_FIRST_LOC, i),
					Plane.TYPE_RED);
			redHome[i].setDirection(Plane.RIGHT ) ;
			
			this.yellowHome[i] = new Cell(getLoc(GameDispose.YELLOW_FIRST_LOC,
					i), Plane.TYPE_YELLOW);
			yellowHome[i].setDirection(Plane.DOWN) ;
			
			this.greenHome[i] = new Cell(
					getLoc(GameDispose.GREEN_FIRST_LOC, i), Plane.TYPE_GREEN);
			greenHome[i].setDirection(Plane.LEFT) ;
			
			
			this.blueHome[i] = new Cell(getLoc(GameDispose.BLUE_FIRST_LOC, i),
					Plane.TYPE_BLUE);
			blueHome[i].setDirection(Plane.UP) ;
		}

	}

	private Point getPiontByRC(int row, int col) {
		return new Point(-2 + 32 * col, 121 + 32 * row);
	}

	/**
	 * 获得制定颜色的飞机数组
	 * 
	 * @param type
	 * @return
	 */
	public Plane[] getPlane(String type) {
		if (Plane.TYPE_BLUE.equals(type))
			return this.blueP;
		else if (Plane.TYPE_GREEN.equals(type))
			return this.greenP;
		else if (Plane.TYPE_RED.equals(type))
			return this.redP;
		else if (Plane.TYPE_YELLOW.equals(type))
			return this.yellowP;
		else
			return null;
	}

	/**
	 * 获得指定颜色的线路
	 * 
	 * @param type
	 * @return
	 */
	public List<Cell> getLine(String type) {

		if (Plane.TYPE_BLUE.equals(type))
			return this.blueList;
		else if (Plane.TYPE_GREEN.equals(type))
			return this.greenList;
		else if (Plane.TYPE_RED.equals(type))
			return this.redList;
		else if (Plane.TYPE_YELLOW.equals(type))
			return this.yellowList;
		else
			return null;
	}

	public Point getLaunchPointByTyep(String type){
		if (Plane.TYPE_BLUE.equals(type))
			return GameDispose.BLUE_LAUNCH ;
		else if (Plane.TYPE_GREEN.equals(type))
			return GameDispose.GREEN_LAUNCH ;
		else if (Plane.TYPE_RED.equals(type))
			return GameDispose.RED_LAUNCH;
		else if (Plane.TYPE_YELLOW.equals(type))
			return GameDispose.YELLOW_LAUNCH;
		else
			return null;
	}
	/**
	 * 通过老家第一个点和老家的机场编号计算飞机停靠位置
	 * 
	 * @return
	 */
	private static Point getLoc(Point point, int index) {
		if (index < 2)
			return new Point(point.x + index * 42, point.y);
		else if (index < 4)
			return new Point(point.x + (index - 2) * 42, point.y + 42);
		else
			return null;
	}

	/**
	 * @return the isStart
	 */
	public boolean isStart() {
		return isStart;
	}

	/**
	 * @param isStart
	 *            the isStart to set
	 */
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	/**
	 * @return the isPlayBGM
	 */
	public boolean isPlayBGM() {
		return isPlayBGM;
	}

	/**
	 * @param isPlayBGM
	 *            the isPlayBGM to set
	 */
	public void setPlayBGM(boolean isPlayBGM) {
		this.isPlayBGM = isPlayBGM;
	}
	/**
	 * @return the redHome
	 */
	public Cell[] getRedHome() {
		return redHome;
	}

	/**
	 * @param redHome
	 *            the redHome to set
	 */
	public void setRedHome(Cell[] redHome) {
		this.redHome = redHome;
	}

	/**
	 * @return the yellowHome
	 */
	public Cell[] getYellowHome() {
		return yellowHome;
	}

	/**
	 * @param yellowHome
	 *            the yellowHome to set
	 */
	public void setYellowHome(Cell[] yellowHome) {
		this.yellowHome = yellowHome;
	}

	/**
	 * @return the greenHome
	 */
	public Cell[] getGreenHome() {
		return greenHome;
	}

	/**
	 * @param greenHome
	 *            the greenHome to set
	 */
	public void setGreenHome(Cell[] greenHome) {
		this.greenHome = greenHome;
	}

	/**
	 * @return the blueHome
	 */
	public Cell[] getBlueHome() {
		return blueHome;
	}

	/**
	 * @param blueHome
	 *            the blueHome to set
	 */
	public void setBlueHome(Cell[] blueHome) {
		this.blueHome = blueHome;
	}

	/**
	 * @return the currentRole
	 */
	public int getCurrentRole() {
		return currentRole;
	}

	/**
	 * @param currentRole
	 *            the currentRole to set
	 */
	public void setCurrentRole(int currentRole) {
		this.currentRole = currentRole;
	}

	/**
	 * @return the dices
	 */
	public Dice[] getDices() {
		return dices;
	}

	/**
	 * @param dices
	 *            the dices to set
	 */
	public void setDices(Dice[] dices) {
		this.dices = dices;
	}

	/**
	 * @return the isClick
	 */
	public boolean isClick() {
		return isClick;
	}

	/**
	 * @param isClick
	 *            the isClick to set
	 */
	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}

	/**
	 * @return the players
	 */
	public Role[] getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(Role[] players) {
		this.players = players;
	}

	/**
	 * @return the numberOfCurrentPlane
	 */
	public int getNumberOfCurrentPlane() {
		return NumberOfCurrentPlane;
	}

	/**
	 * @param numberOfCurrentPlane the numberOfCurrentPlane to set
	 */
	public void setNumberOfCurrentPlane(int numberOfCurrentPlane) {
		NumberOfCurrentPlane = numberOfCurrentPlane;
	}

	/**
	 * @return the isChangeBGM
	 */
	public boolean isChangeBGM() {
		return isChangeBGM;
	}

	/**
	 * @param isChangeBGM the isChangeBGM to set
	 */
	public void setChangeBGM(boolean isChangeBGM) {
		this.isChangeBGM = isChangeBGM;
	}

	/**
	 * @return the luckyNumber
	 */
	public int getLuckyNumber() {
		return luckyNumber;
	}

	/**
	 * @param luckyNumber the luckyNumber to set
	 */
	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}

	/**
	 * @return the chance
	 */
	public int getChance() {
		return chance;
	}

	/**
	 * @param chance the chance to set
	 */
	public void setChance(int chance) {
		this.chance = chance;
	}
}
