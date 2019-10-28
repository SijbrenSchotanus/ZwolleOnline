
import java.util.Random; 
import java.util.function.Function;

public class Tafel {

static Random rand = new Random(); 
	
	public static Vakje balletjeLatenGooien(Vakje[] vakje) { 		//Should return random number in range from 0-36
		
		
		int randomGetal = rand.nextInt(37);
		Vakje randomVakje = vakje[randomGetal]; 
		
		return randomVakje; 
	}
	
	
	

		
}
