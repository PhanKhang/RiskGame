package logic;

import java.util.ArrayList;

public class Continent{
    private String name;
    public ArrayList<Node> countries;
    public int control_value;
    public Continent (String name, ArrayList<Node> countries, int control_value) {
        this.name = name;
        this.countries = countries;
        this.control_value = control_value;
    }
}

