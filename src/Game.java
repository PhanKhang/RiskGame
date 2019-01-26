import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 750;

    public Game(){
        new Window(WIDTH, HEIGHT, "Lets build a game!", this);

    }

    private Thread thread;
    private boolean running = false;

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
                System.out.println("FPS "+frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){

    }

    private void render() throws IOException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics gs = bs.getDrawGraphics();

        gs.setColor(Color.BLACK);
        gs.fillRect(0,0,WIDTH,HEIGHT);
        gs.dispose();
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
