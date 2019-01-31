
import java.awt.*;

public class Country extends GameObject {
    private boolean isClicked = false;
    private String name;
    private String continent;
    private int value;
    private GameObject owner;
    private Color ownerColor = Color.white;
    private int currentArmies = 0;

    public Country(int x, int y, ID id, String name, String continent, int value){
        super(x, y, id);
        this.name = name;
        this.value = value;
        this.continent = continent;

//        velX = rnd.nextInt(10);
//        velY = rnd.nextInt(10)+1;
    }

    public void setOwner(GameObject player) {
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
    
    
    public void setArmy() {
    	currentArmies++;
      // System.out.println(currentArmies);
    }
    
    public int getArmy() {
    	return currentArmies;
    }

    public void clicked(){
        isClicked = true;
        if (owner != null){
            if (owner instanceof Player) ownerColor = ((Player) owner).getPlayerColor();
        }
    }

    public void released(){
        isClicked = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)this.x, (int)this.y, this.value * 5 + 2, this.value * 5 + 2);
        g.setColor(ownerColor);
        if (this.isClicked) {
            g.setColor(Color.GREEN);
        }

        g.fillOval((int)this.x + 1, (int)this.y + 1, this.value * 5, this.value * 5);
        g.setColor(Color.BLUE);
        g.drawString(this.name, (int)this.x, (int)this.y);
    }


}
