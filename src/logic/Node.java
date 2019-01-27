package logic;

import java.util.ArrayList;

public class Node {// a Node is a country
    private String name;
    private ArrayList<Node> neighbours;
    private Continent cont;
    private Player owner;
    private int current_armies;

// parse txt into Node objects
    public Node(String name, ArrayList<Node> neighbours, Continent cont){
        this.name = name;
        this.neighbours = neighbours;
        this.cont = cont;

    }
    public void setOwner(Player player){
        this.owner = player;
    }

    public void addNeighbour(Node neighbour){
        this.neighbours.add(neighbour);
    }









}

