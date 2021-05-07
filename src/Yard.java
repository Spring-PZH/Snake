import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
	public static final int NodeSize = 16;//把每个小格的宽度设置为8的倍数就不会重叠
	public static final int NodeCount = 30;
	public static final int AreaSize = NodeCount * NodeSize;

	static int x = AreaSize / 2;
	static int y = AreaSize / 2;

	Egg e = new Egg(10,10);
	Snake s = new Snake();


	public static void main(String[] args) {
		new Yard();
	}

	Yard() {
		this.setSize(2 * AreaSize, 2 * AreaSize);
		this.setVisible(true);
		this.addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				s.keyPressed(e);
			}
		});

		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}

	//划 横、竖 线
	@Override
	public void paint(Graphics g) {
		//重画背景颜色（白）
		Color c  = g.getColor();
		System.out.println(c);
		g.setColor(Color.WHITE);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.BLACK);

		for (int i = 0; i <= NodeCount; i++) {

			g.drawLine(x, y + (NodeSize * i), x + AreaSize, y + (NodeSize * i));

			g.drawLine(x + (NodeSize * i), y, x + (NodeSize * i), y + AreaSize);
		}
		e.paint(g);
		s.paint(g);
		s.eat(e);

	}


	//消除闪烁的方法》
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(this.getWidth(), this.getHeight());
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	//消除闪烁的方法》


}
