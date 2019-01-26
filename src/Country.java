import java.awt.*;

public class Country extends GameObject {
    private boolean isClicked = false;

    public Country(int x, int y, ID id){
        super(x, y, id);
//        velX = rnd.nextInt(10);
//        velY = rnd.nextInt(10)+1;
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    public void clicked(){
        isClicked = true;
    }

    public void released(){
        isClicked = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        if (isClicked) g.setColor(Color.GREEN);
        g.fillOval(x, y, 10,10);
//        g.fillRect(x,y,10,10);
    }
}
