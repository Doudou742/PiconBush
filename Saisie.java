package personnages;
import java.util.Scanner;

import javax.swing.JOptionPane;

	
	public class Saisie {

		static String message;
		private Scanner unScanner;
		static JOptionPane jop1;
		
		public Saisie(String message){
			this.message = message;
			jop1 = new JOptionPane();
			unScanner = new Scanner(System.in);
			
		}
		
		public static String SaisieString(){			
			//System.out.println(message + ": ");
			return  jop1.showInputDialog(null,message,"Mettez nous 20 svp");
		}
		
		public static int SaisieInt(){
			//System.out.println(message + ": ");
			String mess=jop1.showInputDialog(null,message,"42");
			return Integer.parseInt(mess);
		}
		
		public void setMessage(String message){
			
			this.message = message;
		}
		
		public static void main(String [] args){
			Saisie tank = new Saisie("Quel robot voulez vous bouger ?");
			String a ="";
			a=SaisieString();
			int b=SaisieInt();
			System.out.println(a + b);
		}
}