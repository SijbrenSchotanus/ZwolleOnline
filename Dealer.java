
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Dealer {

	static Random rand = new Random();

	public static int balletjeGooien() { // Should return random number in range from 0-36
		int randomGetal = rand.nextInt(37);
		return randomGetal;

	}

//INZET VAN DE SPELER INPUT 

	int bedrag = 0; 
	
	public int vraagOmInzet(int inhoudPortemonnee) throws Exception {
		Boolean tryAgain = true;
		while (tryAgain) {
			System.out.println("Zet een bedrag in: ");
			Scanner input = new Scanner(System.in);
			bedrag = input.nextInt();
			if (bedrag <= inhoudPortemonnee) {
				tryAgain = false;
			}else {
				System.out.println("Je kunt niet meer geld inzetten dan dat je hebt meegenomen");
			}
			

		}
		tryAgain = false; 

		return bedrag;

	}

	String[] keuzeinput = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
			"33", "34", "35", "36", "Rood", "Zwart" };
	ArrayList<String> keuzeinputList = new ArrayList<String>();

//	public static String keuze = "keuze";

//KEUZE VAN DE SPELER INPUT 
	public String vraagOmKeuze() throws Exception {

		for (int i = 0; i < keuzeinput.length; i++) {
			keuzeinputList.add(keuzeinput[i]);
		}

		System.out.println("Kies voor 0-36, Rood of Zwart");
		Scanner input = new Scanner(System.in);
		String keuze = input.next();
		AB: if (keuzeinputList.contains(keuze)) {
			break AB;
		} else {
			System.out.println("Kies een geldig statement");
			throw new Exception();
		}
		return keuze;
	}

//DEALER VERGELIJKT INZET MET TYPE VAKJE 

	public String bepaalTypeKeuze(String[] array, String keuze) {
		int i = 0;

		return array[i];
	}

//VERGELIJK DE UITKOMST MET DE INPUT 
//	static Boolean winstOfNiet = false;

	public boolean winstOfVerlies(String keuzeVanDezeRonde, int waardeVanRandom, String kleurVanRandom) {
		Boolean winstOfNiet = false;
		String waardeVanRandomMethode = "";
		waardeVanRandomMethode = Integer.toString(waardeVanRandom);
		if (keuzeVanDezeRonde.equals("Zwart") || keuzeVanDezeRonde.equals("Rood")) {
			if (keuzeVanDezeRonde.equals(kleurVanRandom)) {
				winstOfNiet = true;
				System.out.println("Gefeliciteerd je hebt de juiste kleur geraden!");
			} else {
				System.out.println("Helaas mis");
			}
		} else if (keuzeVanDezeRonde.equals(waardeVanRandomMethode)) {
			winstOfNiet = true;
			System.out.println("Gefeliciteerd je hebt de juiste waarde geraden!");
		} else {
			System.out.println("U heeft helaas verloren");
		}

		return winstOfNiet;
	}

	// ALS INZET 40 + WINST DAN RETOUR 80 v 40*35 ANDERS RETOUR INZET8-1
	public int bepaalHoeveelWinst(int inzetDezeRonde, boolean winstOfNiet, String keuze) {

		if (winstOfNiet) {
			if (keuze.equals("Zwart") || keuze.equals("Rood")) {
				inzetDezeRonde = inzetDezeRonde*2;
			} else {
				inzetDezeRonde = inzetDezeRonde * 35;
			}
		} else {
			inzetDezeRonde = 0;
		}

		return inzetDezeRonde;

	}

	
	public boolean wilJeDoorgaanOfNiet() {
		Boolean gaanWeDoor; 
		System.out.println("Voer in of je wilt \"Stoppen\" of \"Spelen\" ");
		Scanner watGaanWeDoen = new Scanner(System.in); 
		String weGaanDitDoen = watGaanWeDoen.next(); 
		if(weGaanDitDoen.equalsIgnoreCase("Spelen"))
			gaanWeDoor = true; 
		if(weGaanDitDoen.equalsIgnoreCase("Stoppen")) {
			System.out.println("Bedankt voor het spelen, tot de volgende keer!");
			gaanWeDoor = false; 
		}else {
			gaanWeDoor = true; 
		}
		return gaanWeDoor; 
	}

}
