import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class AssignArmy extends MouseInput{
    public AssignArmy(Handler handler) {
		super(handler);
		this.handler=handler;
		// TODO Auto-generated constructor stub
	}




	private Handler handler;

    @Override
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        for (int i = 0; i < handler.objects.size(); i++) {
        		GameObject tempObject = handler.objects.get(i);

            if (tempObject.getX() <= mx && tempObject.getX() + tempObject.getValue() * 5 >= mx && tempObject.getY() <= my && tempObject.getY() + tempObject.getValue() * 5 >= my) {

                System.out.println(mx+ " "+my +" object pressed: "+tempObject.getName());
                if(tempObject instanceof  Country) {
                    for (GameObject o: handler.objects) {
                        if (o.id == ID.Player2){
                              System.out.println("owner is "+ o.getName());
                        	 ((Country) tempObject).setArmy();;
                              System.out.println("The arrmy of "+o.getId()+" is "+ ((Country) tempObject).getArmy());
                            ((Country) tempObject).setOwner(o);
                        }
                    }

                }
                tempObject.clicked();
            }
        }
    }

}
