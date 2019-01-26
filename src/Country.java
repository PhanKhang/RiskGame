import java.awt.*;



public class Country extends GameObject {
    private boolean isClicked = false;

    public Country(int x, int y, ID id,Continent con){
        super(x, y, id);
//        velX = rnd.nextInt(10);
//        velY = rnd.nextInt(10)+1;
    }
    private Continent con = this.con;

    public Continent getCon(){
        return con;
    }
    
    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    public void clicked(){
        isClicked = true;
    }

    public void released(){
        isClicked = false;
    }

    @Override
    public void render(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.drawString(id.getName(), x+10, y+30);
    	/*
    	switch(con) {
        case Asia:
        	//g.setColor(Color.BLUE);
        	break;
        	
		case Africa:
			//g.setColor(Color.BLUE);
			break;
			
		case Europe:
			//g.setColor(Color.BLUE);
			break;
			
		case North_America:
		//	g.setColor(Color.BLUE);
			break;
			
		case Oceania:
			//g.setColor(Color.BLUE);
			break;
			
		case South_America:
		//	g.setColor(Color.BLUE);
			break;
		default:
			break;

        
        }
    	*/
       // if(con=="Asia") g.setColor(Color.RED);
        if (isClicked) g.setColor(Color.GREEN);
        g.drawOval(x, y, 60,60);
//        g.fillRect(x,y,10,10);
    }
}
