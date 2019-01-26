import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random rnd = new Random();

    public Player(int x, int y, ID id){
        super(x, y, id);
//        velX = rnd.nextInt(10);
//        velY = rnd.nextInt(10)+1;
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) g.setColor(Color.WHITE);
        if (id == ID.Player2) g.setColor(Color.BLUE);
        g.fillRect(x,y,10,10);
    }

    @Override
    public void clicked() {

    }

    @Override
    public void released() {

    }

}
