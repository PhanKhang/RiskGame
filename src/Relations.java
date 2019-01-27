import java.awt.Graphics;
import java.awt.*;
public class Relations extends GameObject{
	private int x2;
	private int y2;
	public Relations(int x, int y,int x2, int y2, ID id) {
		super(x, y, id);
		this.x2=x2;
		this.y2=y2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		
		// TODO Auto-generated method stub
		g.drawLine(x, y, x2, y2);
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void released() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
