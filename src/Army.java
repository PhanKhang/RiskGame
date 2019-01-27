import java.awt.*;

public class Army extends GameObject{
    public Army(float x, float y, ID id) {
        super(x, y, id);
    }
    int moveToX = 920, moveToY = 250;

    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x,(int)y,10,20);

    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void clicked() {

    }

    @Override
    public void released() {

    }
}
