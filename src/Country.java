import java.awt.*;

public class Country extends GameObject {
    private boolean isClicked = false;
    private String name;
    private String continent;
    private int value;

    public Country(int x, int y, ID id, String name, String continent, int value){
        super(x, y, id);
        this.name = name;
        this.value = value;
        this.continent = continent;

//        velX = rnd.nextInt(10);
//        velY = rnd.nextInt(10)+1;
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
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
        g.fillOval(x, y, value*5,value*5);
        g.setColor(Color.BLUE);
        g.drawString(name, x, y);

    }
}
