import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 750;



    private Thread thread;
    private boolean running = false;

    private Handler handler;

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));
        new Window(WIDTH, HEIGHT, "Lets build a game!", this);
        LoadMap();
        handler.addObject(new Player(WIDTH/2 - 100,HEIGHT/2,ID.Player)); // 500 375
        //handler.addObject(new Player(WIDTH/2 + 100,HEIGHT/2,ID.Player2));
       // handler.addObject(new Country(WIDTH/2 + 10,HEIGHT/2+10,ID.Alaska,Continent.North_America));
    }

    private void LoadMap() {
		// TODO Auto-generated method stub
    	handler.addObject(new Country(706,334,ID.China,Continent.Asia));
    	handler.addObject(new Country(783,334,ID.Mongolia,Continent.Asia));
    	handler.addObject(new Country(642,334,ID.Afghanistan,Continent.Asia));
    	handler.addObject(new Country(706,260,ID.India,Continent.Asia));
    	handler.addObject(new Country(706,394,ID.Japan,Continent.Asia));
    	//handler.addObject(new Country(706,334,ID.,Continent.Asia));
    	//handler.addObject(new Country(706,334,ID.China,Continent.Asia));
	}

	@Override
    public void run() {
        long lastTime = System.nanoTime();
        double amount_of_ticks = 60.0;
        double ns = 1000000000 / amount_of_ticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta --;
            }
            if (running){
                try {
                    render();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
//                System.out.println("FPS "+frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();

    }

    private void render() throws IOException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.white);
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
        new Game();
    }
}
