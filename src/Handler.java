import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick(){
        for (GameObject tempGameObject : objects) {
            tempGameObject.tick();
        }

    }

    public void render(Graphics g){
        for (GameObject tempGameObject: objects) {
            tempGameObject.render(g);
        }
    }

    public int getSize(){
        return objects.size();
    }

    public void addObject(GameObject object){
        objects.add(object);
    }

    public void addAtPos(GameObject object, int i){
        objects.add(i, object);
    }


    public void removeObject(GameObject object){
        objects.remove(object);
    }
}
