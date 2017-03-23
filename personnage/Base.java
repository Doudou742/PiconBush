package personnage;

public class Base extends Case {

	private Equipe equipe;
	
	public Base(int x,int y, Equipe equipe){
		super(x,y);
		this.equipe = equipe;
	}
}
