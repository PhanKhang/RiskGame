package logic;
import java.util.HashMap;
public class WorldMap {
    HashMap<Continent, Node> worldmap;
    public WorldMap(){

    }



}
class Continent{
    String name;
    Node[] countries;
    int control_value;
}
