
import java.util.Scanner;

public class Speler {
		String username = ""; 
	public Speler() {
		Scanner eersteInput = new Scanner(System.in);
		System.out.println("Please enter your name to start the Game");
		username = eersteInput.next();
	}

	public static String maakKeuze(String s) {
		Scanner scanner = new Scanner(s);
		String gemaakteKeuze = scanner.next();

		return "gemaakteKeuze";
	}
	/*
	 * System.out.println("Zet een bedrag in: "); 
	 * Scanner input = new Scanner(System.in);
	 */
	
	
	int inhoud = 0; 
	public int Portemonnee() {
		System.out.println("Hoeveel $'s heb je meegenomen?");
		Scanner scanner = new Scanner(System.in); 
		int inhoudPortemonnee = scanner.nextInt(); 
		
		int inhoud =+ inhoudPortemonnee; 
		return inhoud; 
		
	}
	
	
	
	public int portemonneeVullen(int inhoud, int inzet, int winst) {
		inhoud = inhoud - inzet + winst; 
		return inhoud; 
	} 
}
