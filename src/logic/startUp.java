package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public  class startUp {
    public static String author;
    public static String mapname;

    public static void readFile(ObjectInfo object){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
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
                        new Continent(parts[0],new ArrayList<Node>(), control_value);
                        //System.out.println(Arrays.toString(parts));
//                        new Continent(parts[0], control_value);
                    }
                    if (reader.readLine().equals("[Territories]")) {
                        int numberOfTerritories = Integer.parseInt(reader.readLine().trim());
                        for(int i = 0; i<numberOfTerritories ; i++){
                            input = reader.readLine();
                            String[] parts = input.split(" ");
                            System.out.println(Arrays.toString(parts));
                            //handler.addObject(new Country(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), ID.Territory, parts[0],parts[3], Integer.parseInt(parts[4])));

                        }
                        if (reader.readLine().equals("[Relationship]")) {
//                            input = reader.readLine();
//                            while (input != null){
//                                //write
//                                System.out.println(input);
//                            }
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

    public static void main(String[] args) {
//        startUp.readFile();


    }
}
