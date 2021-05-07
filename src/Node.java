import java.awt.*;

public class Node {
	int row,col;
	int i=0;

	Node prev,next;

	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}


	public void paint(Graphics g) {
		int x = Yard.x+col*Yard.NodeSize;
		int y = Yard.y+row*Yard.NodeSize;
		Color c  = g.getColor();

		switch (i%7){
			case 0:
				g.setColor(Color.GREEN);
				i++;
				break;
			case 1:
				g.setColor(Color.YELLOW);
				i++;
				break;
			case 2:
				g.setColor(Color.blue);
				i++;
				break;
			case 3:
				g.setColor(Color.ORANGE);
				i++;
				break;
			case 4:
				g.setColor(Color.PINK);
				i++;
				break;
			case 5:
				g.setColor(Color.cyan);
				i++;
				break;
			case 6:
				g.setColor(Color.MAGENTA);
				i++;
				break;
			case 7:
				g.setColor(Color.DARK_GRAY);
				i++;
				break;
		}
		g.fillRect(x,y,Yard.NodeSize,Yard.NodeSize);
		g.setColor(c);
	}
}
