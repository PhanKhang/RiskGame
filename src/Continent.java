import java.awt.*;
import java.util.ArrayList;

public class Continent{
    private static Color[] ALL_COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.magenta, Color.PINK, Color.ORANGE, Color.BLACK, Color.CYAN, Color.GRAY};
    String name;
    ArrayList<Country> countries;
    int control_value;
    public Color contColor;
    boolean check;
    public Continent(String name, int control_value, int seq){
        this.name = name;
        this.control_value = control_value;
        this.contColor = ALL_COLORS[seq];
        countries = new ArrayList<>();
    }
    public String getName() {
        return name;
    }


}
