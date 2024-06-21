package rejtjel;

public class KezdoKulcs {
	public static String kezdoKulcs(String kezdoszo, String rejt_uzenet) {
		String kulcsDarab = null;
		for (int i = 0; i < kezdoszo.length(); i++) {
			try {
				kulcsDarab += NumberToChar.numberToChar((CharToNumber.charToNumber(rejt_uzenet.charAt(i)) - CharToNumber.charToNumber(kezdoszo.charAt(i)) + 27) % 27);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		return kulcsDarab;
	}
}
