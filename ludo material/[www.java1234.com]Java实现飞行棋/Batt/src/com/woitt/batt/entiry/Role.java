package com.woitt.batt.entiry;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.woitt.batt.data.GameData;
import com.woitt.batt.dispose.GameDispose;
import com.woitt.batt.res.GameRes;
import com.woitt.batt.ui.GamePanel;

/**
 * ��Ϸ��ɫ��
 * 
 * @author zhangql
 * 
 */
public class Role {

	/**
	 * ��ɫ���
	 */
	private boolean isPlayer;

	/**
	 * ��ɫ�������ɫ
	 */
	private String roleColor;

	/**
	 * g�ý�ɫӵ�еķɻ�
	 */
	private Plane[] planes = new Plane[4];

	/**
	 * �ý�ɫӵ�еĺ���
	 */
	private List<Cell> line;

	/**
	 * ��ҵ�ɫ��
	 */
	private Dice dice;

	/**
	 * ��Ϸ���
	 */
	private GamePanel gamePanel;

	private Thread delayThread = new Thread();

	public Role(boolean isPlayer, String roleColor, GamePanel gamePanel) {

		this.setGamePanel(gamePanel);
		this.setPlanes(this.gamePanel.getGameConrol().getGameServiceImpl()
				.getGameData().getPlane(roleColor));
		this.setLine(this.gamePanel.getGameConrol().getGameServiceImpl()
				.getGameData().getLine(roleColor));
		this.setPlayer(isPlayer);
		this.setRoleColor(roleColor);

	}

	/**
	 * �ƶ��ɻ�
	 * 
	 * @param planeIndex
	 * @param diceNumber
	 */
	@SuppressWarnings("static-access")
	public void movePlane(int planeIndex, int diceNumber) {
		

		// ���Ҫ�ƶ��ķɻ�
		Plane plane = this.getPlanes()[planeIndex];

		// ����÷ɻ����ϼ�
		if (plane.getLoc() == -2) {
			// ���
			this.launchPlane(planeIndex);
		} else {

			// ��ø÷ɻ�����·�ϵ�λ��
			int increment = plane.getLoc();
			if (increment != 56) {
				// ���Ҫ�ƶ��ĳ���
				int delta = diceNumber;
				// ����ƶ���ﲻ���յ�
				if (plane.getLoc() + delta < 55) {
					// ֱ���ƶ�
					for (int i = 0; i < delta; i++) {
						// �ɻ�λ�ü�һ
						plane.setLoc(plane.getLoc() + 1);
						// ���Ҫ�ƶ�����һ��ĸ���
						Cell cell = this.line.get(plane.getLoc());
						// �ı�ɻ��ĺ���
						plane.ChangeDireciont(plane.getPlaneType(),
								cell.getDirection());
						// ���÷ɻ��ڵ�ͼ�ϵ�λ��
						plane.setLocation(cell.getLocation());
						// ���ɻ���ʾ����Ϸ���
						this.getGamePanel().add(plane);
						// �ػ�
						this.getGamePanel().repaint();
						try {
							// �ӳ�
							delayThread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					int temp = this.judgeIsJump(plane) ;
					if(temp>0){
						plane.setLoc(plane.getLoc() + temp);
						Cell cell = this.line.get(plane.getLoc());
						plane.ChangeDireciont(plane.getPlaneType(),
								cell.getDirection());
						plane.setLocation(cell.getLocation());
						this.getGamePanel().add(plane);
						
						//������Ծ��Ч
						Thread jumpThread = new Thread(new SoundsPlayer(this.gamePanel.getGameConrol().getGameServiceImpl().getGameData(), 1, GameDispose.JUMP_RING_URL)) ;
						jumpThread.start() ;
						jumpThread.interrupt() ;
						this.getGamePanel().repaint();
						
					}
					
					this.bombPlane(this.judgeIsBomb(plane)) ;
					// ����ƶ��󳬹����յ�
				} else if (plane.getLoc() + delta > 55) {

					// ����ǰ���ľ���
					int forwards = 55 - plane.getLoc();
					// ������˵ľ���
					int rears = delta - forwards;

					// ǰ��
					for (int i = 0; i < forwards; i++) {
						plane.setLoc(plane.getLoc() + 1);
						Cell cell = this.line.get(plane.getLoc());
						plane.ChangeDireciont(plane.getPlaneType(),
								cell.getDirection());
						plane.setLocation(cell.getLocation());
						this.getGamePanel().add(plane);
						this.getGamePanel().repaint();
						try {
							delayThread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					// ����
					for (int i = 0; i < rears; i++) {
						plane.setLoc(plane.getLoc() - 1);
						Cell cell = this.line.get(plane.getLoc());
						plane.ChangeDireciont(plane.getPlaneType(),
								cell.getDirection());
						plane.setLocation(cell.getLocation());
						this.getGamePanel().add(plane);
						this.getGamePanel().repaint();
						try {
							delayThread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else if (plane.getLoc() + delta == 55) {
					for (int i = 0; i < delta; i++) {

						plane.setLoc(plane.getLoc() + 1);
						Cell cell = this.line.get(plane.getLoc());
						plane.ChangeDireciont(plane.getPlaneType(),
								cell.getDirection());
						plane.setLocation(cell.getLocation());
						this.getGamePanel().add(plane);
						this.getGamePanel().repaint();
						try {
							delayThread.sleep(400);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					this.drawCrown(plane);
					//���ŵ�����Ч
					Thread arriveThread = new Thread(new SoundsPlayer(this.gamePanel.getGameConrol().getGameServiceImpl().getGameData(), 1, GameDispose.ARRIVE_RING_URL)) ;
					arriveThread.start() ;
					arriveThread.interrupt() ;
					plane.setLoc(-3);


					int temp = this.gamePanel
							.getGameConrol()
							.getGameServiceImpl()
							.judgeIsWin(
									this.getGamePanel().getGameConrol()
											.getGameServiceImpl().getGameData()
											.getCurrentRole());

					// TODO ��Ϸ��������
					if (temp != -1) {
						if(temp == 0){
							//����ʤ����Ч
							Thread victoryThread = new Thread(new SoundsPlayer(this.gamePanel.getGameConrol().getGameServiceImpl().getGameData(), 1, GameDispose.VICTORY_RING_URL)) ;
							victoryThread.start() ;
							JOptionPane.showMessageDialog(null, "��ϲ��ʤ���ˣ���Ϊ����˵�") ;
							System.exit(1) ;
						}else{
							//����ʧ����Ч
							Thread defeatThread = new Thread(new SoundsPlayer(this.gamePanel.getGameConrol().getGameServiceImpl().getGameData(), 1, GameDispose.DEFEAT_RING_URL)) ;
							defeatThread.start() ;
							JOptionPane.showMessageDialog(null, "��ס�������˾�����������д��Ϸ�ġ�����������~~~") ;
							System.exit(1) ;
							
						}
					}
					return;
				}
			}
		}
		
		this.getGamePanel().getGameConrol().getGameServiceImpl().judgeIsNearWin() ;
	}

	/**
	 * �����ɻ�
	 * @param planeIndex
	 */
	public void launchPlane(int planeIndex) {
		//������Ч
		Thread landOffThread = new Thread(new SoundsPlayer(this.gamePanel.getGameConrol().getGameServiceImpl().getGameData(), 1, GameDispose.LANDOD_RING_URL)) ;
		landOffThread.start() ;
		
		
		this.planes[planeIndex].setLocation(this.getGamePanel().getGameConrol()
				.getGameServiceImpl().getGameData()
				.getLaunchPointByTyep(this.getPlanes()[0].getPlaneType()));
		this.planes[planeIndex].setLoc(-1);
		this.gamePanel.add(this.planes[planeIndex]);
		this.gamePanel.repaint();
		
		landOffThread.interrupt();
	}

	/**
	 * ���ƻʹ�
	 * 
	 * @param plane
	 */
	private void drawCrown(Plane plane) {

		
		

		String type = plane.getPlaneType();

		
		if (Plane.TYPE_RED.equals(type)) {

			plane.setIcon(GameRes.RED_CROWN);
			plane.setLocation(this.getGamePanel().getGameConrol()
					.getGameServiceImpl().getGameData().getRedHome()[plane
					.getIndex()].getLocation());
			this.getGamePanel().add(plane);

		} else if (Plane.TYPE_YELLOW.equals(type)) {
			plane.setIcon(GameRes.YELLOW_CROWN);
			plane.setLocation(this.getGamePanel().getGameConrol()
					.getGameServiceImpl().getGameData().getYellowHome()[plane
					.getIndex()].getLocation());
			this.getGamePanel().add(plane);
		} else if (Plane.TYPE_GREEN.equals(type)) {
			plane.setIcon(GameRes.GREEN_CROWN);
			plane.setLocation(this.getGamePanel().getGameConrol()
					.getGameServiceImpl().getGameData().getGreenHome()[plane
					.getIndex()].getLocation());
			this.getGamePanel().add(plane);

		} else if (Plane.TYPE_BLUE.equals(type)) {
			plane.setIcon(GameRes.BLUE_CROWN);
			plane.setLocation(this.getGamePanel().getGameConrol()
					.getGameServiceImpl().getGameData().getBlueHome()[plane
					.getIndex()].getLocation());
			this.getGamePanel().add(plane);
		}
		this.gamePanel.repaint();
	}

	/**
	 * �ж��Ƿ�w��Ծ
	 * @param plane
	 * @return
	 */
	private int judgeIsJump(Plane plane) {

		String type = plane.getPlaneType();
		List<Cell> line = this.getGamePanel().getGameConrol()
				.getGameServiceImpl().getGameData().getLine(type);

		if(plane.getLoc()>48)
			return 0 ;
		if (line.get(plane.getLoc()).getCellColor()
				.equals(plane.getPlaneType())&&plane.getLoc()==17)
			return  12;
		else if(line.get(plane.getLoc()).getCellColor()
				.equals(plane.getPlaneType()))
			return 4 ;
		return 0 ;
	}

	/**
	 * �ж��Ƿ��зɻ�Ҫ��ը
	 * @param plane
	 * @return
	 */
	private List<Plane> judgeIsBomb(Plane plane){
		
		List<Plane> planeList = new ArrayList<Plane>() ;
		
		GameData data = this.gamePanel.getGameConrol().getGameServiceImpl().getGameData() ;
		Plane[] redPs = data.getPlane(Plane.TYPE_RED) ;
		Plane[] yellowPs = data.getPlane(Plane.TYPE_YELLOW) ;
		Plane[] greenPs = data.getPlane(Plane.TYPE_GREEN) ;
		Plane[] bluePs = data.getPlane(Plane.TYPE_BLUE) ;
		
		Point p = plane.getLocation() ;
		for(int i = 0 ;i<4;i++)
			if(redPs[i].getLocation().equals(p)&&(!redPs[i].getPlaneType().equals(plane.getPlaneType())))
				planeList.add(redPs[i]) ;
		if(planeList.size()!=0)
			return planeList ;
		
		
		for(int i = 0 ;i<4;i++)
			if(yellowPs[i].getLocation().equals(p)&&(!yellowPs[i].getPlaneType().equals(plane.getPlaneType())))
				planeList.add(yellowPs[i]) ;
		if(planeList.size()!=0)
			return planeList ;
		
		for(int i = 0 ;i<4;i++)
			if(greenPs[i].getLocation().equals(p)&&(!greenPs[i].getPlaneType().equals(plane.getPlaneType())))
				planeList.add(greenPs[i]) ;
		if(planeList.size()!=0)
			return planeList ;
		
		for(int i = 0 ;i<4;i++)
			if(bluePs[i].getLocation().equals(p)&&(!bluePs[i].getPlaneType().equals(plane.getPlaneType())))
				planeList.add(bluePs[i]) ;
		if(planeList.size()!=0)
			return planeList ;
		return null ;
	}
	
	/**
	 * ʵ�к�ը
	 * @param plane
	 */
	private void bombPlane(List<Plane> planeList){
		if(planeList==null)
			return ;
		else{
			//���ź�ը��Ч
			Thread landOffThread = new Thread(new SoundsPlayer(this.gamePanel.getGameConrol().getGameServiceImpl().getGameData(), 1, GameDispose.CRASH_RING_URL)) ;
			landOffThread.start() ;
			landOffThread.interrupt() ;
			
			for(Plane plane : planeList){
				
			GameData data = this.getGamePanel().getGameConrol().getGameServiceImpl().getGameData() ;
			String type = plane.getPlaneType() ;
			int index = plane.getIndex() ;
			if(type.equals(Plane.TYPE_RED)){		
				plane.setLocation(data.getRedHome()[index].getLocation()) ;
				plane.ChangeDireciont(plane.getPlaneType(), data.getRedHome()[index].getDirection()) ;
				this.initPlane(plane) ;
				
			}
			else if(type.equals(Plane.TYPE_YELLOW)) {
				plane.setLocation(data.getYellowHome()[index].getLocation()) ;
				plane.ChangeDireciont(plane.getPlaneType(), data.getYellowHome()[index].getDirection()) ;
				this.initPlane(plane) ;
				
			}
			else if(type.equals(Plane.TYPE_GREEN)){
				plane.setLocation(data.getGreenHome()[index].getLocation()) ;
				plane.ChangeDireciont(plane.getPlaneType(), data.getGreenHome()[index].getDirection()) ;
				this.initPlane(plane) ;
			} 
			else{
				plane.setLocation(data.getBlueHome()[index].getLocation()) ;
				plane.ChangeDireciont(plane.getPlaneType(), data.getBlueHome()[index].getDirection()) ;
				this.initPlane(plane) ;
			}
			}
		}
		
	}
	
	private void initPlane(Plane plane){
		plane.removeMouseListener() ;
		plane.setAtHome(true);
		plane.setLoc(-2) ;
		this.getGamePanel().add(plane) ;
		this.getGamePanel().repaint() ;
		
	}
	
	/**
	 * @return the isPlayer
	 */
	public boolean isPlayer() {
		return isPlayer;
	}

	/**
	 * @param isPlayer
	 *            the isPlayer to set
	 */
	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	/**
	 * @return the roleColor
	 */
	public String getRoleColor() {
		return roleColor;
	}

	/**
	 * @param roleColor
	 *            the roleColor to set
	 */
	public void setRoleColor(String roleColor) {
		this.roleColor = roleColor;
	}

	/**
	 * @return the planes
	 */
	public Plane[] getPlanes() {
		return planes;
	}

	/**
	 * @param planes
	 *            the planes to set
	 */
	public void setPlanes(Plane[] planes) {
		this.planes = planes;
	}

	/**
	 * @return the line
	 */
	public List<Cell> getLine() {
		return line;
	}

	/**
	 * @param line
	 *            the line to set
	 */
	public void setLine(List<Cell> line) {
		this.line = line;
	}

	/**
	 * @return the gamePanel
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * @param gamePanel
	 *            the gamePanel to set
	 */
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	/**
	 * @return the dice
	 */
	public Dice getDice() {
		return dice;
	}

	/**
	 * @param dice
	 *            the dice to set
	 */
	public void setDice(Dice dice) {
		this.dice = dice;
	}

	/**
	 * @return the delayThread
	 */
	public Thread getDelayThread() {
		return delayThread;
	}

	/**
	 * @param delayThread
	 *            the delayThread to set
	 */
	public void setDelayThread(Thread delayThread) {
		this.delayThread = delayThread;
	}
}
