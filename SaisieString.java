
import java.util.Scanner;

	public class SaisieString {

		private String message;
		private Scanner unScanner;
		
		public SaisieString(String message){
			this.message = message;
			unScanner = new Scanner(System.in);
			
		}
		
		public String newSaisieString(){
		
			System.out.println(message + ": ");
			return  unScanner.next();
		}
		
		public void changeMessageString(String message){
			this.message = message;
			
		}
		
}
