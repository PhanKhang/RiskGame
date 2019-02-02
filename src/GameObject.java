import java.awt.*;

public abstract class GameObject {

    float x, y;
    ID id;
    float velX, velY;

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);


    public abstract int getValue();
    public abstract String getName();

    public void setX (int x){
        this.x = x;
    }

    public void setY (int y){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
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

    public float getVelX(){
        return velX;
    }

    public float getVelY(){
        return velY;
    }

}
