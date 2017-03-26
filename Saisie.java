
import java.util.Scanner;
	
	public class Saisie {

		private String message;
		private Scanner unScanner;
		
		public Saisie(String message){
			this.message = message;
			unScanner = new Scanner(System.in);
			
		}
		
		public String SaisieString(){			
			System.out.println(message + ": ");
			return unScanner.next();
		}
		
		public int SaisieInt(){
			System.out.println(message + ": ");
			return unScanner.nextInt();
		}
		
		public void setMessage(String message){
			
			this.message = message;
		}
}
