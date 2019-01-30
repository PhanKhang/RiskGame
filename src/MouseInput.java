import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    private Handler handler;

    public MouseInput(Handler handler){
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getX() <= mx && tempObject.getX() + tempObject.getValue() * 5 >= mx && tempObject.getY() <= my && tempObject.getY() + tempObject.getValue() * 5 >= my) {

                System.out.println(mx+ " "+my +" object pressed: "+tempObject.getName());
//                if(tempObject instanceof  Country) {
//                    for (GameObject o: handler.objects) {
//                        if (o.id == ID.Player){
//                            System.out.println("owner is "+ o.getName());
//                            ((Country) tempObject).setOwner(o);
//                        }
//                    }
//
//                }
                tempObject.clicked();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getX() <= mx && tempObject.getX() + tempObject.getValue() * 5 >= mx && tempObject.getY() <= my && tempObject.getY() + tempObject.getValue() * 5 >= my) {

                System.out.println(mx+ " "+my +" object released: "+tempObject.getId());
                tempObject.released();
            }
        }
    }
}
