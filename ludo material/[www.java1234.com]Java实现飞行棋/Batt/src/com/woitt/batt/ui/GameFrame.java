package com.woitt.batt.ui;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import com.woitt.batt.dispose.GameDispose;


/**
 * 游戏主界面
 * 
 * @author zhangql
 * 
 */
public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 游戏窗口宽度
	 */
	private static final int WINDOW_W = GameDispose.WINDOW_W;
	/**
	 * 游戏窗口高度
	 */
	private static final int WINDOW_H = GameDispose.WINDOW_H;

	/**
	 * 游戏窗口里屏幕顶端的距离
	 */
	private static final int PADDING = GameDispose.PADDING;

	/**
	 * 用于拖动窗口时记录鼠标临时位置
	 */
	private Point temp = null;

	/**
	 * 用于拖动窗口时计算移动后的窗口位置
	 */
	private Point loc;

	/**
	 * 鼠标移动时是否移动游戏窗口
	 */
	private boolean isDragged = false ;

	/**
	 * 游戏界面面板
	 */
	private GamePanel gamePanel = null;



	public GameFrame(GamePanel panel) {
		
		this.gamePanel = panel ;
		
		// 设置关闭属性为：退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置游戏窗口不可调整大小
		this.setResizable(false);
		this.setUndecorated(true);
		
		//加键盘监听
		this.addKeyListener(this) ;

		// 设置游戏窗口剧中
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		int x = screen.width - WINDOW_W >> 1;
		this.setBounds(x, PADDING, WINDOW_W, WINDOW_H);

		// 添加游戏面板
		this.getContentPane().add(gamePanel);
		gamePanel.setGameFrame(this) ;

		// 设置窗口可拖动
		this.setDragable(this);

		// 设置游戏窗口可见
		this.setVisible(true);
		
		//初始化游戏面板
		this.gamePanel.getGameConrol().initGame(this) ;
		
		//开始游戏
		this.gamePanel.getGameConrol().startGame(this) ;
		

	}

	/**
	 * 设置窗口可拖拽
	 * 
	 * @param jframe
	 */
	private void setDragable(final JFrame jframe) {
		gamePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				isDragged = false;
				jframe.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				temp = new Point(e.getX(), e.getY());
				isDragged = true;
				jframe.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});

		gamePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (isDragged) {
					loc = new Point(jframe.getLocation().x + e.getX() - temp.x,
							jframe.getLocation().y + e.getY() - temp.y);
					jframe.setLocation(loc);
				}
			}

		});
	}

	/**
	 * @return the gamePanel
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * @param gamePanel the gamePanel to set
	 */
	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.gamePanel.getGameConrol().setLuckyNumber(e.getKeyChar()) ;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
