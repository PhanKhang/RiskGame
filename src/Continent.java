import java.awt.*;

public class Continent extends GameObject{
    String name;
    Country[] countries;
    int control_value;
    public Continent(int x, int y, ID id, String name, int control_value){
        super(x, y, id);
        this.name = name;
        this.control_value = control_value;
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
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
