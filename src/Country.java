
import java.awt.*;
import java.util.ArrayList;

public class Country extends GameObject {

    private boolean isClicked = false;
    private String name;


    private Continent cont;
    private Player owner;
    private int current_armies;
    private int value;

    private ArrayList<Country> neighbours;

    public Country(int x, int y, ID id, String name, Continent continent, int value){
        super(x, y, id);
        this.name = name;
        this.neighbours = new ArrayList<>();
        this.cont = cont;
        this.value = value;

//        velX = rnd.nextInt(10);
//        velY = rnd.nextInt(10)+1;
    }

    public void setOwner(Player player) {
        this.owner = player;

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
//        isClicked = true;
//        if (owner != null){
////            if (owner instanceof Player) ownerColor = ((Player) owner).getPlayerColor();
//        }
    }

    public void released(){
        isClicked = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)this.x, (int)this.y, this.value * 5 + 2, this.value * 5 + 2);
        g.setColor(owner.getPlayerColor());
        if (this.isClicked) {
            g.setColor(Color.GREEN);
        }

        g.fillOval((int)this.x + 1, (int)this.y + 1, this.value * 5, this.value * 5);
        g.setColor(Color.BLUE);
        g.drawString(this.name, (int)this.x, (int)this.y);
    }

}
