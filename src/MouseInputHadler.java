import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputHadler implements MouseListener {
    private Handler handler;

    public MouseInputHadler(Game game, Handler handler){
        game.addMouseListener(this);
        this.handler = handler;
    }

    private GameObject chosen = null;

    public GameObject getChosen() {
        return chosen;
    }

    public void reset(){
        chosen = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getX() <= mx && tempObject.getX() + tempObject.getValue() * 5 >= mx && tempObject.getY() <= my && tempObject.getY() + tempObject.getValue() * 5 >= my) {
                System.out.println(mx+ " "+my +" object clicked: "+tempObject.getName());
                chosen = tempObject;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
