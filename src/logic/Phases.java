package logic;

import logic.Node;


public class Phases {
    private int numOfPlayers;
    private Player[] players;
    private Node[] graph;
    private Continent[] worldmap;
    //get player input from event handler
    private boolean gaming = false;



    public Phases(int numOfPlayers, Node[] graph, Continent[] worldmap ){
        this.numOfPlayers = numOfPlayers;
        this.players = new Player[this.numOfPlayers];
        this.graph = graph;
        this.worldmap = worldmap;

        this.init();

    }

    private void countryAssignment(){}//update players with countries randomly assigned to them. Divide countries as evenly as possible
    //also for each assigned country put one army of its owner to that country
    private void determineOrder(){//determine the round robin order for players by changing the order in the players field

    }

    private void init(){
        countryAssignment();
        determineOrder();
        //here put a function returning to GUI to print the assignment result and prompt players
        this.gaming = true;
        gamestart();



    }
    private void gamestart(){
        int turnReference = 0;
        int turn = 0;
        while(this.gaming){//keep looping until there is a winner
            Player current_player = players[turn];
            phase1(current_player);
            phase2(current_player);
            if(checkGame()){
                
            }

            phase3(current_player);


            turnReference++;
            turn = turnReference % this.numOfPlayers;


        }
    }
    public void passPlayerInput(){

    }
    private void phase1(Player player){

    }
    private void phase2(Player player){

    }
    private void phase3(Player player){

    }
    private boolean checkGame(){//check if we have a winner

    }



}
