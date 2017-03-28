package personnages;

public abstract class Action {

	private Robot robot;
	protected Cellule objectif;
	
	public Action (Robot robot, Cellule objectif) {
		this.robot = robot;
		this.objectif=objectif;
		}
	
	public Robot getRobot() {
		return this.robot;
	}
	public Cellule getObjectif() {
		return this.objectif;
	}
	
	public abstract void agit();
}