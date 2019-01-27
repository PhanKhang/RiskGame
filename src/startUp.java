import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class startUp {
    public String author;
    public String mapname;

    void readFile(Handler handler){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("entry.txt"));
            String input = reader.readLine();
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
                        new Continent(parts[0], control_value);
                    }
                    if (reader.readLine().equals("[Territories]")) {
                        int numberOfTerritories = Integer.parseInt(reader.readLine().trim());
                        for(int i = 0; i<numberOfTerritories ; i++){
                            input = reader.readLine();
                            String[] parts = input.split(" ");
                            handler.addObject(new Country(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), ID.Territory, parts[0],parts[3], Integer.parseInt(parts[4])));

                        }
                        if (reader.readLine().equals("[Relationship]")) {
                            input = reader.readLine();
                            while (input != null){
                                String[] parts = input.split(" ");
                                GameObject tm1 = null, tm2 = null;
                                for(GameObject o: handler.objects){
                                    if(o.id == ID.Territory){
                                        if (parts[0].equals(o.getName())){
                                            tm1 = o;
                                        }
                                        if (parts[1].equals(o.getName())){
                                            tm2 = o;
                                        }
                                    }
                                }
                                if (tm1 != null && tm2 != null){
                                    handler.addObject(new Relations(tm1.getX()+tm1.getValue()*5/2, tm1.getY()+tm1.getValue()*5/2, tm2.getX()+tm1.getValue()*5/2, tm2.getY()+tm1.getValue()*5/2, ID.Relation));
                                }
                                input = reader.readLine();
                            }
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
    }
}
