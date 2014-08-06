package com.woitt.batt.entiry;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.woitt.batt.data.GameData;
import com.woitt.batt.dispose.GameDispose;
import com.woitt.batt.res.GameRes;

/**
 * 游戏飞机类
 * @author zhangql
 *
 */
public class Plane extends JLabel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 飞机类型
	 * b蓝色飞机
	 * r红色飞机
	 * g绿色飞机
	 * y黄色飞机
	 */
	private final String planeType ;
	
	/**
	 * 飞机的航向
	 * direction 取值
	 * 1，下
	 * 2，左
	 * 3，右
	 * 4，上
	 */
	private int planeDirection ;
	
	/**
	 * 是不是玩家控制的棋子
	 */
	private boolean isPlayer ;
	
	/**
	 * 飞机是否在家
	 */
	private boolean isAtHome = true ;

	/**
	 * 飞机在航线上的位置
	 */
	private int loc = -2 ;
	
	/**
	 * 飞机在老家的序号
	 */
	private int index = -1 ;

	public static final String TYPE_RED = "r" ;
	
	public static final String TYPE_BLUE = "b" ;
	
	public static final String TYPE_GREEN = "g" ;
	
	public static final String TYPE_YELLOW = "y" ;
	
	public static final int UP = 4;
	
	public static final int DOWN = 1 ;
	
	public static final int LEFT = 2 ;
	
	public static final int RIGHT = 3 ;
	
	private GameData data ;
	
	
	public Plane(String type ,int direction,boolean isPlayer,int index,GameData data){
		this.setData(data) ;
		this.setIndex(index) ;
		this.setSize(GameDispose.PLANE_SIZE, GameDispose.PLANE_SIZE) ;
		this.planeType = type ;
		ChangeDireciont(planeType,direction) ;
		
		this.setPlayer(isPlayer) ;
		
	}
	
	/**
	 * 改变航向
	 * @param type
	 * @param direction
	 */
	public void ChangeDireciont(String type,int direction){
		if(type.equals(Plane.TYPE_RED)){
			ImageIcon icon = GameRes.redPlaneImgArray[direction-1] ;
			this.setIcon(icon);
			return ;
		}
		if(type.equals(Plane.TYPE_GREEN)){
			ImageIcon icon = GameRes.greenPlaneImgArray[direction - 1] ;
			this.setIcon(icon);
			return ;
		}
		
		if(type.equals(Plane.TYPE_BLUE)){
			ImageIcon icon = GameRes.bluePlaneImgArray[direction - 1] ;
			this.setIcon(icon);
			return ;
		}
		if(type.equals(Plane.TYPE_YELLOW)){
			ImageIcon icon = GameRes.yellowPlaneImgArray[direction - 1] ;
			this.setIcon(icon);
			return ;
		}
	}

	/**
	 * 给自己添加鼠标事件监听
	 */
	public void addMouseListener(){
		this.addMouseListener(this) ;
	}
	
	/**
	 * 移除鼠标时间监听
	 */
	public void removeMouseListener(){
		this.removeMouseListener(this) ;
	}
	/**
	 * @return the planeDirection
	 */
	public int getPlaneDirection() {
		return planeDirection;
	}

	/**
	 * @param planeDirection the planeDirection to set
	 */
	public void setPlaneDirection(int planeDirection) {
		this.planeDirection = planeDirection;
	}

	/**
	 * @return the loc
	 */
	public int getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(int loc) {
		this.loc = loc;
	}

	/**
	 * @return the planeType
	 */
	public String getPlaneType() {
		return planeType;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.data.setNumberOfCurrentPlane(this.getIndex()) ;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the isPlayer
	 */
	public boolean isPlayer() {
		return isPlayer;
	}

	/**
	 * @param isPlayer the isPlayer to set
	 */
	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	/**
	 * @return the isAtHome
	 */
	public boolean isAtHome() {
		return isAtHome;
	}

	/**
	 * @param isAtHome the isAtHome to set
	 */
	public void setAtHome(boolean isAtHome) {
		this.isAtHome = isAtHome;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the data
	 */
	public GameData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(GameData data) {
		this.data = data;
	}
	
}
