package rejtjel;

public class DecryptWholeMessage {
	public static String decrypt(String rejtjelezett, String kulcs) {
		String visszafejtett = "";
		for (int i = 0; i < rejtjelezett.length(); i++) {
			try {
				if (CharToNumber.charToNumber(rejtjelezett.charAt(i)) < CharToNumber.charToNumber(kulcs.charAt(i))) {
					visszafejtett += NumberToChar.numberToChar(27 - (CharToNumber.charToNumber(kulcs.charAt(i)) - CharToNumber.charToNumber(rejtjelezett.charAt(i))));
				}
				else {
					visszafejtett += NumberToChar.numberToChar(CharToNumber.charToNumber(rejtjelezett.charAt(i))-CharToNumber.charToNumber(kulcs.charAt(i)));	
				}
				
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		return visszafejtett;
	}
}
