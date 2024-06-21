package rejtjel;

public class EncryptWholeMessage {
	public static String encrypt(String uzenet, String kulcs) {
		String rejt_uzenet = "";
		for (int i = 0; i < uzenet.length(); i++) {
			try {
				rejt_uzenet += NumberToChar.numberToChar((CharToNumber.charToNumber(uzenet.charAt(i)) + CharToNumber.charToNumber(kulcs.charAt(i))) % 27);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		return rejt_uzenet;
	}
}
