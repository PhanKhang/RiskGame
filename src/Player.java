

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    private static Color[] ALL_COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.ORANGE};

    private Color playerColor = Color.WHITE;
    int unassigned_armies;
    public ArrayList<Country> realms;//array of countries owned by this player
    int army = 1;
    int seq;//this is primary key for players

    public Player(int x, int y, ID id, int seq, int initailArmycount){
        super(x, y, id);
        this.realms = new ArrayList<>();
        this.seq = seq;
        this.playerColor = ALL_COLORS[seq];
        this.unassigned_armies = initailArmycount;

    }

    public boolean armyLeft(){
        return unassigned_armies != 0;
    }

    public void deployArmy(){
        if(armyLeft()) {
            unassigned_armies--;
        }
    }

    @Override
    public void tick() {
//        x += velX;
//        y += velY;

    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public int getPlayerArmy(){
        return unassigned_armies;
    }

    @Override
    public void render(Graphics g) {
//        if (id == ID.Player1) g.setColor(Color.WHITE);
//        if (id == ID.Player2) g.setColor(Color.BLUE);
//        g.fillRect((int)x,(int)y,10,10);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getName() {
        return id.toString();
    }


    @Override
    public void clicked() {

    }

    @Override
    public void released() {

    }



}
