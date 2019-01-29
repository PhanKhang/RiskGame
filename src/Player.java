

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {

    private Color playerColor = Color.WHITE;
    int unassigned_armies;
    public ArrayList<Country> realms;//array of countries owned by this player
    int army;
    int seq;//this is primary key for players

    public Player(int x, int y, ID id, int seq){
        super(x, y, id);
        this.realms = new ArrayList<>();
        this.seq = seq;

    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    public Color getPlayerColor() {
        return playerColor;
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
