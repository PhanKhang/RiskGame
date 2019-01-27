import java.awt.*;

public abstract class GameObject {

    int x, y;
    ID id;
    int velX, velY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);


    public abstract int getValue();
    public abstract String getName();

    public abstract void clicked();
    public abstract void released();

    public void setX (int x){
        this.x = x;
    }

    public void setY (int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setId(ID id){
        this.id = id;
    }

    public ID getId(){
        return id;
    }

    public void setVelX (int Velx){
        this.velX = Velx;
    }

    public void setVelY (int Vely){
        this.velY = Vely;
    }

    public int getVelX(){
        return velX;
    }

    public int getVelY(){
        return velY;
    }

}
