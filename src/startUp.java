import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class startUp {
    public String author;
    public String mapname;

    public int current  = 0;

    public Phases readFile(Handler handler){
        current = handler.getSize();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("entry.txt"));
            String input = reader.readLine();
            ArrayList<Continent> worldmap = new ArrayList<>();
            ArrayList<Country> graph = new ArrayList<>();
            if (input.equals("[Map]")){
                author = reader.readLine().trim();
                mapname = reader.readLine().trim();
                if (reader.readLine().trim().equals("[Continents]")){
                    int numberOfContinents = Integer.parseInt(reader.readLine().trim());
                    for(int i = 0; i< numberOfContinents; i++){
                        // do something with this info;
                        // here create continents
                        String country_value = reader.readLine();
                        String [] parts = country_value.split(" ");
                        int control_value = Integer.parseInt(parts[1]);


                        worldmap.add(new Continent(parts[0], control_value, i));
                    }
                    if (reader.readLine().equals("[Territories]")) {
                        int numberOfTerritories = Integer.parseInt(reader.readLine().trim());
                        for(int i = 0; i<numberOfTerritories ; i++){
                            input = reader.readLine();
                            String[] parts = input.split(" ");
                            Continent tempcont = findContinent(worldmap, parts[3]);
                            Country tempCountry = new Country(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), ID.Country, parts[0], tempcont, Integer.parseInt(parts[4]));
                            tempcont.countries.add(tempCountry);
                            graph.add(tempCountry);
                            handler.addObject(graph.get(graph.size()-1));

//                            handler.addObject(new Country(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), ID.Country, parts[0],parts[3], Integer.parseInt(parts[4])));

                        }
                        if (reader.readLine().equals("[Relationship]")) {
                            input = reader.readLine();
                            while (input != null){
                                String[] parts = input.split(" ");
                                Country tm1 = null, tm2 = null;
                                for (Country o : graph) {

                                    if (parts[0].equals(o.getName())) {
                                        tm1 = o;
                                    }
                                    if (parts[1].equals(o.getName())) {
                                        tm2 = o;
                                    }

                                }
                                if (tm1 != null && tm2 != null){
                                    handler.addAtPos(new Relations((int)tm1.getX()+tm1.getValue()*5/2, (int)tm1.getY()+tm1.getValue()*5/2, (int)tm2.getX()+tm1.getValue()*5/2, (int)tm2.getY()+tm1.getValue()*5/2, ID.Relation), current);
//                                    handler.addObject(new Relations((int)tm1.getX()+tm1.getValue()*5/2, (int)tm1.getY()+tm1.getValue()*5/2, (int)tm2.getX()+tm1.getValue()*5/2, (int)tm2.getY()+tm1.getValue()*5/2, ID.Relation));
                                }
                                input = reader.readLine();
                            }
                            return new Phases(graph, worldmap,handler);

                        }
                    } else {
                        System.err.println("Wrong Format3");
                        System.exit(0);
                    }
                } else {
                    System.err.println("Wrong Format2");
                    System.exit(0);
                }
            } else {
                System.err.println("Wrong Format1");
                System.exit(0);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    Continent findContinent(ArrayList<Continent> worldmap, String contname){
        for(Continent cont : worldmap){
            if(cont.name.equals(contname)){
                return cont;
            }
        }
        return null;
    }

}
