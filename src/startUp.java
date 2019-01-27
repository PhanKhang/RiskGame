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
                if (reader.readLine().trim() == "[Continents]"){
                    int numberOfContinents = Integer.parseInt(reader.readLine().trim());

                    for(int i = 0; i< numberOfContinents; i++){



                    }
                    if (reader.readLine() == "[Territories]") {
                        int numberOfTerritories = Integer.parseInt(reader.readLine().trim());
                        for(int i = 0; i<numberOfTerritories ; i++){
                            input = reader.readLine();
                            String[] parts = input.split(" ");
                            handler.addObject(new Country(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), ID.Territory, parts[0]));
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
