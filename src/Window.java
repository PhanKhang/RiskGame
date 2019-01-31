import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    private static final long serialVersionUID = 11111;
    private JFrame frame;
    //Panel Declaration
    Panel player_state1=new Panel();	
    Panel player_state2=new Panel();	
    Panel player_state3=new Panel();	
    Panel player_state4=new Panel();	
    Panel player_state5=new Panel();	
    Panel player_state6=new Panel();	
    Panel player_current=new Panel();
    Panel phase=new Panel();
    Panel units=new Panel();
    
    public Window(int width, int height, String title, Game game){
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        //Panel Setting
        Pannel_Setting(frame);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
    public String promptPlayer(String dialog) {
        String input = JOptionPane.showInputDialog(this.frame, dialog);
        System.out.println("number of players: " + input);
        return input;

    }
       public void Pannel_Setting(JFrame frame) {
 
        //Color
        Color c1=new Color(254,67,101);
        Color c2=new Color(252,157,154);
        Color c3=new Color(249,205,13);
        Color c4=new Color(200,200,169);
        Color c5=new Color(131,175,155);
        Color c6=new Color(244,208,0);
        Color c7=new Color(229,131,8);
        Color c8=new Color(220,87,18);
    	player_state1.setSize(200, 150);
		player_state1.setBackground(c1); 		
		player_state1.setLocation(1200,0);
		frame.add(player_state1);								
		
		player_state2.setSize(200, 150);
		player_state2.setBackground(c2); 		
		player_state2.setLocation(1200,151);
		frame.add(player_state2);	
		
		player_state3.setSize(200, 150);
		player_state3.setBackground(c3); 		
		player_state3.setLocation(1200,302);
		frame.add(player_state3);	
		
		player_state4.setSize(200, 150);
		player_state4.setBackground(c4); 		
		player_state4.setLocation(1200,453);
		frame.add(player_state4);	
		
		player_state5.setSize(200, 150);
		player_state5.setBackground(c5); 		
		player_state5.setLocation(1200,604);
		frame.add(player_state5);	
		
		player_state6.setSize(200, 150);
		player_state6.setBackground(Color.LIGHT_GRAY); 		
		player_state6.setLocation(1200,755);
		frame.add(player_state6);	
		
		player_current.setSize(350, 200);
		player_current.setBackground(c6); 		
		player_current.setLocation(0,680);
		frame.add(player_current);	
		
		phase.setSize(550, 200);
		phase.setBackground(c7); 		
		phase.setLocation(351,680);
		frame.add(phase);	
		
		units.setSize(297, 200);
		units.setBackground(c8); 		
		units.setLocation(902,680);
		frame.add(units);	
    }
    
}
