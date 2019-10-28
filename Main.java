
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

//MAAK ALLE VAKJES AAN 
		int[] GroeneVakjesWaarde = { 0 };
		int[] RodeVakjesWaarde = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
		int[] ZwarteVakjesWaarde = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 21, 33, 35 };

		Vakje[] RodeVakjesMetWaarde = new Vakje[18];
		Vakje[] ZwarteVakjesMetWaarde = new Vakje[18];

		Vakje vakje0 = new Vakje("Groen", GroeneVakjesWaarde[0]);

		for (int i = 0; i < RodeVakjesWaarde.length; i++) {
			RodeVakjesMetWaarde[i] = new Vakje("Rood", RodeVakjesWaarde[i]);
		}

		for (int i = 0; i < ZwarteVakjesWaarde.length; i++) {
			ZwarteVakjesMetWaarde[i] = new Vakje("Zwart", ZwarteVakjesWaarde[i]);
		}

//MAAK HET SPEELBORD AAN IN EEN ARRAY  
		Vakje[] AlleVakjes = new Vakje[37]; // HIER HET SPEELBORD
		AlleVakjes[0] = vakje0;

		for (int i = 0; i < RodeVakjesWaarde.length; i++) {
			AlleVakjes[i + 1] = RodeVakjesMetWaarde[i];
		}
		for (int i = 0; i < ZwarteVakjesWaarde.length; i++) {
			AlleVakjes[i + 19] = ZwarteVakjesMetWaarde[i];
		}
		

//MAAK SPELER AAN 
		Speler nieuweSpeler = new Speler();

		int inhoudPortemonnee = nieuweSpeler.Portemonnee();
		System.out.println("Er zit $" + inhoudPortemonnee + ",- in je portemonnee");

//DEALER WORDT GEBOREN 

		Dealer Jeanette = new Dealer();

//TAFEL WORDT OPGEZET 

		Tafel MooieTafel = new Tafel();

//LAAT DE DEALER DE SPELER VRAGEN OM IN TE ZETTEN 

//BEGIN VAN DE RONDE  

		String watWilJeDoen = "Spelen";

		// Boolean gaanWeDoor = true;
		Boolean gaanWeDoor = Jeanette.wilJeDoorgaanOfNiet();

		while (gaanWeDoor) {
			// gaanWeDoor = Jeanette.wilJeDoorgaanOfNiet(gaanWeDoor);

			System.out.println("Er zit nog $" + inhoudPortemonnee + ",- in je portemonnee");

			int InzetDezeRonde = 0;
			Boolean tryAgain = true;
			while (tryAgain) {
				try {
					InzetDezeRonde = Jeanette.vraagOmInzet(inhoudPortemonnee);
					tryAgain = false;
				} catch (InputMismatchException e) {
					System.out.println("Kies een getal!");
				}
			}
			inhoudPortemonnee = inhoudPortemonnee - InzetDezeRonde;
			System.out.println("Er zit nog $" + inhoudPortemonnee + ",- in je portemonnee");

			String KeuzeVanDezeRonde = "";
			Boolean tryAgainKeuze = true;
			while (tryAgainKeuze) {
				try {
					KeuzeVanDezeRonde = Jeanette.vraagOmKeuze();
					tryAgainKeuze = false;
				} catch (Exception e) {
					System.out.println("Vul een gevraagde waarde in");
				}
			}

			System.out.println("Je heb $" + InzetDezeRonde + ",- Ingezet op " + KeuzeVanDezeRonde);

//BEPAAL WINST OF VERLIES 
			
			
			Vakje vakjeVanDezeRonde = MooieTafel.balletjeLatenGooien(AlleVakjes); 

			int vakjesWaardeVanDezeRonde = vakjeVanDezeRonde.waarde; 
			String vakjesKleurVanDezeRonde = vakjeVanDezeRonde.kleur; 
			
			System.out.println(
					"De bal is gevallen op: " + vakjesWaardeVanDezeRonde + " Met de kleur: " + vakjesKleurVanDezeRonde);

			Boolean winstOfVerlies = Jeanette.winstOfVerlies(KeuzeVanDezeRonde, vakjesWaardeVanDezeRonde,
					vakjesKleurVanDezeRonde);

			inhoudPortemonnee = inhoudPortemonnee
					+ Jeanette.bepaalHoeveelWinst(InzetDezeRonde, winstOfVerlies, KeuzeVanDezeRonde);

			System.out.println("Na deze ronde is de inhoud van je portemonnee: $" + inhoudPortemonnee + ",-");

			tryAgain = true;
			
			

			
			gaanWeDoor = Jeanette.wilJeDoorgaanOfNiet();

		}

	}

}
