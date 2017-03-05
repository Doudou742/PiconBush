
/**
 * 
 * Classe Coord - traitement des coordonnées 
 * 
 */

package jalon1;

public class Coord {
    
    private int positionX;
    private int positionY;
    
    public Coord(int positionX,int positionY){
        
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getPositionX(){
        
        return this.positionX;
    }
    
    public void setPositionX(int x){
            
        this.positionX = x;
    }
    
    public int getPositionY(){
        
        return this.positionY;
    }
        
    public void setPositionY(int y){
        
        this.positionY = y;
    }
    
    
}
