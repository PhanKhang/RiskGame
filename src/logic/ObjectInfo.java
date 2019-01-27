package logic;

import java.util.ArrayList;

public class ObjectInfo {
    ArrayList<Node> countries = new ArrayList<Node>();
    ArrayList<Continent> continents = new ArrayList<Continent>();
    public void addCoutry(Node country) {
        countries.add(country);
    }
    public void addContinent(Continent continent) {
        continents.add(continent);
    }
}
