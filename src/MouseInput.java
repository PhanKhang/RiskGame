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

        System.out.println(mx+ " "+my);



        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getX() <= mx && tempObject.getX() + 32 >= mx &&
                    tempObject.getY() <= my && tempObject.getY() + 32 >= my){
                System.out.println(mx+ " "+my +" object: "+tempObject.getId());
            }
        }
    }
}
