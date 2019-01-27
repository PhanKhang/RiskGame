package logic;
import java.util.ArrayList;

public class Player{
    int id;

    ArrayList<Node> realms;//array of countries owned by this player

    int army;

    int unassigned_armies;
    public Player(int id){

        this.id = id;
        this.realms = new ArrayList<>();
        this.army = army;

    }
}
