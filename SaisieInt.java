import java.util.Scanner;

	public class SaisieInt {

	private String message;
	private Scanner unScanner;
	
	public SaisieInt(String message){
		this.message = message;
		unScanner = new Scanner(System.in);
		
	}
	
	public int newSaisieInt() {
		System.out.println(message + ": ");
		return unScanner.nextInt();
		
	}
	
	public void changeMessageInt(String message){

		this.message = message;
	}
	
}
