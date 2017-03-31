package personnages;

public class test {
	public static int [] efzg(int[] tab ){
		tab[0]--;
		return tab;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] tab = new int [1];
		tab[0]=4;
		efzg(tab);
		System.out.println(tab[0]);
		
	

	}

}
