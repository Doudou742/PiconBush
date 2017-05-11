package personnages;

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
	    public Coord ajouterCoord(Coord coordonnee){
	    
	    	return new Coord(this.positionX+coordonnee.positionX,this.positionY+coordonnee.positionY);
	    }
	    
	    public boolean equals(Coord coordonnee){
	    	if(this.positionX==coordonnee.positionX && this.positionY==coordonnee.positionY){
	    		return true;
	    	}
	    	return false;
	    }

		@Override
		public String toString() {
			return "[" + positionX + ", " + positionY + "]";
		}
	    

}
