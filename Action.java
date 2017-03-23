
public abstract class Action {

	private Robot robot;
	private Coord direction;
	protected Coord objectif;
	
	public Action (Robot robot, Coord direction) {
		this.robot = robot;
		this.direction = direction;
	}
	
	public Robot getRobot() {
		return this.robot;
	}
	
	public Coord getDirection() {
		return this.direction;
	}
	
	public Coord getObjectif() {
		return this.objectif;
	}
	
	public abstract void agit();
	
}
