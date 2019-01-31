

import java.util.ArrayList;
import java.util.Collections;
import java.util.PrimitiveIterator;


public class Phases {
    private int numOfPlayers;
    private ArrayList<Player> players;
    private ArrayList<Country> graph;
    private ArrayList<Continent> worldmap;

    //get player input from event handler
//    public Continent continent = new Continent();
    private boolean gaming = false;
    public Handler handler;
    private Player current_player;


    public Phases(ArrayList<Country> graph, ArrayList<Continent> worldmap, Handler handler){

        this.graph = graph;
        this.worldmap = worldmap;
        this.handler = handler;

    }

    //update players with countries randomly assigned to them. Divide countries as evenly as possible
    //also for each assigned country put one army of its owner to that country
    private void countryAssignment(){
        Collections.shuffle(this.graph);
        int turnReference = 0;
        int turn = 0;
        for(Country country : this.graph){
            Player player = players.get(turn);
            player.realms.add(country);
            country.setOwner(player);
            turnReference++;
            turn = turnReference % players.size();

        }
        //here put a function to pass 'players' and 'graph' to GUI to show how the countries are assigned



    }
    private void determineOrder(){//determine the round robin order for players by changing the order in the players field
        Collections.shuffle(players);

    }
//after players type in the number of players and each player's name, call init() to construct the game
    public void init(int numOfPlayers){
        if(numOfPlayers == 0){
            System.out.println("number of players can't be zero");
        }
        else {
            this.numOfPlayers = numOfPlayers;

            this.players = new ArrayList<>();
            for (int i = 0; i < numOfPlayers; i++) {
                Player tempPlayer = new Player(0, 0, ID.Player, i);
                this.players.add(tempPlayer);//i is the player id
                handler.addObject(tempPlayer);
            }
            determineOrder();
            countryAssignment();

            //here put a function returning to GUI to print the assignment result and prompt players
            //pass assignment info(which player owns what countries, player order)
            //gamestart();
        }



    }
    private void gamestart(){

        int turnReference = 0;
        int turn = 0;
        Player winner;
        while(true){//keep looping until there is a winner
            current_player = players.get(turn);
            phase1(current_player);
            phase2(current_player);
            if(checkGame()){
                winner = current_player;
                break;
            }

            phase3(current_player);


            turnReference++;
            turn = turnReference % this.numOfPlayers;


        }
        System.out.println(winner.id + " is the winner!");//something to return to GUI to tell who wins
    }
    private ArrayList<String> checkowner_continent (ArrayList<Country> graph, ArrayList<Continent> worldmap, Player player){
        ArrayList<String> continent_name = new ArrayList<>();
       for (Continent x : worldmap){
           ArrayList<String> continent_countries = new ArrayList<>();
           for (Country y : x.countries){
               continent_countries.add(y.getName());
           }
           ArrayList<String> player_countries = new ArrayList<>();
            for (Country w : player.realms){
                player_countries.add(w.getName());
            }
            int record = 0;
            for (String a : continent_countries){
                if (player_countries.contains(a)){
                    record += 1;
                }
            }
            if (record == x.countries.size()){
                continent_name.add(x.name);
            }
       }
        return continent_name;
    }
    private void phase1(Player player) {
        System.out.println("This is reinforcement phase");
        int continent_control_value;
        //continent_name is store for continent name which whole owned by one player
        ArrayList<String> continent_name = checkowner_continent(graph, worldmap, current_player);
        String name = continent_name.get(0);
//        for (Continent x : worldmap){
////            for (String a : continent_name){
////                if (x.name == a){
////                    System.out.println(a);
////                    continent_control_value = x.control_value;
////                }
////            }
//            if (x.name.equals(name)){
//                continent_control_value = x.control_value;
//            }
//        }
//        System.out.println(continent_control_value);
        if(!continent_name.isEmpty()){
            //player.army += continent_control_value;
        }else {
            player.army += player.realms.size() / 3;
        }

        System.out.println(player.army);

    }
    private void phase2(Player player){
        //System.out.println("Phase2");
    }
    private void phase3(Player player){}
    private boolean checkGame(){return false;}




}
