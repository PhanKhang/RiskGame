import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game extends Canvas implements Runnable {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 750;



    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private Window window;
    private Phases phases;
    public MouseInputHadler mouseInput;

    private boolean start = false;
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
//        this.addMouseListener(new MouseInput(handler));
        mouseInput = new MouseInputHadler(this, handler);
        window = new Window(WIDTH, HEIGHT, "Lets build a game!", this);

        startUp s = new startUp();
        this.phases = s.readFile(handler);

        int numOfPlayers = Integer.parseInt(this.window.promptPlayer("How many players?"));
        if(numOfPlayers <= 6){
            this.phases.init(numOfPlayers);
        }
        else {
            numOfPlayers = 6;
            this.phases.init(6);
        }

        start = true;

        this.start();



    }

//    private void init(){
//        handler.addObject(new Player(WIDTH/2 + 100,HEIGHT/2,ID.Player, "Hero", Color.red));
//        startUp s = new startUp();
//        this.phases = s.readFile(handler);
//
//    }

    @Override
    public void run() {

        while (start == false);

        long lastTime = System.nanoTime();
        double amount_of_ticks = 60.0;
        double ns = 1000000000 / amount_of_ticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;

//        System.out.println("im before the while loop");

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            boolean shouldRender = false;
            while (delta >= 1){
                ticks++;
                tick();
                delta --;
                shouldRender = true;
            }
            if (shouldRender){
                frames++;
                render();
            }

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
//                System.out.println("FPS "+frames + " ticks "+ticks);
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

    private int turn = 0;
    private boolean turnMade = true;

    private void tick(){ // this will loop forever until the winner is found
        if (turnMade == true){ // add more specifics
            System.out.println("Current Turn: "+turn);
            turnMade = false;
        }


        Country chosen = picked();

        if(chosen != null){ // can be more things here like if country is picked on specific phase etc.
            System.out.println("Caught "+chosen.getName());
            System.out.println(chosen.getOwner().getPlayerArmy());
            chosen.getOwner().deployArmy();
            chosen.setStationedArmy(chosen.getStationedArmy()+1);
            turnMade = true;
            turn++;
        }
        resetMouse();

        handler.tick();


    }

    public void resetMouse(){
        mouseInput.reset();

    }

    public Country picked(){
        return (Country) mouseInput.getChosen();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Game game = new Game();

    }

}
