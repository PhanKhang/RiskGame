import java.util.ArrayList;

public class Continent{
    String name;
    ArrayList<Country> countries;
    int control_value;
    boolean check;
    public Continent(String name, int control_value){
        this.name = name;
        this.control_value = control_value;
        countries = new ArrayList<>();
    }
    public String getName() {
        return name;
    }


}
