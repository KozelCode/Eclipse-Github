package rejtjel;

public class Visszafejt {
	public static String visszafejt(String rejtjelezett, String kulcs) {
		String visszafejtett = "";
		for (int i = 0; i < rejtjelezett.length(); i++) {
			try {
				if (Rejtjelezes.charToNumber(rejtjelezett.charAt(i)) < Rejtjelezes.charToNumber(kulcs.charAt(i))) {
					visszafejtett += Rejtjelezes.numberToChar(27 - (Rejtjelezes.charToNumber(kulcs.charAt(i)) - Rejtjelezes.charToNumber(rejtjelezett.charAt(i))));
				}
				else {
					visszafejtett += Rejtjelezes.numberToChar(Rejtjelezes.charToNumber(rejtjelezett.charAt(i))-Rejtjelezes.charToNumber(kulcs.charAt(i)));	
				}
				
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		return visszafejtett;
	}
}
