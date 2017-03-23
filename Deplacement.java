package personnages;

public class Deplacement extends Action{

	public Deplacement(Robot robot, Coord direction){
		super(robot,direction);
	}
	public void bougerRobot() {
		if(super.getRobot() instanceof Char){
			//deplacement de 2
		} else if(super.getRobot() instanceof Tireur || super.getRobot() instanceof Piegeur){
			//deplacement de 1
		}
	}
	

	
}
