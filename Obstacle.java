

/**
 *
 * classe Obstacle
 */


package jalon1;

public class Obstacle {
    
    private Coord coordObstacle;
    private final char pion = 'O';
    
    
    public Obstacle(int positionX,int positionY){
        
        coordObstacle = new Coord(positionX,positionY);
     
    }
    
    public int getPositionX(){
        
        return coordObstacle.getPositionX();
        
    }
    
    public void setPositionX(int x){
        
        coordObstacle.setPositionX(x);
    }
    
    public int getPositionY(){
        
        return coordObstacle.getPositionY();
    }
    
    public void setPositionY(int y){
        
        coordObstacle.setPositionY(y);
    }
    
    public String toString(){
        
        return pion + "";
    }
    
   
}
