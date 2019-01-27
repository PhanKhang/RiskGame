import logic.Node;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    private String name;
    private Color playerColor = Color.RED;
    int unassigned_armies;

    public Player(int x, int y, ID id, String name, Color chosenColor){
        super(x, y, id);
        this.name = name;
        playerColor = chosenColor;
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
        if (id == ID.Player) g.setColor(Color.WHITE);
        if (id == ID.Player2) g.setColor(Color.BLUE);
        g.fillRect((int)x,(int)y,10,10);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void clicked() {

    }

    @Override
    public void released() {

    }

    ArrayList<Node> realms;//array of countries owned by this player

}
