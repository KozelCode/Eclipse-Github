package rejtjel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class KulcsGuesser {
	public static char karakterDecrypt(char rejt_kar, char kulcs_kar) {
		return Rejtjelezes.numberToChar((rejt_kar - kulcs_kar + 27) % 27);
	}
	public static Set<String> Szotar(){
		Set<String> szotar = new HashSet<>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("words.txt"));
			String sor = null;
			while ((sor = bf.readLine()) != null) {
				szotar.add(sor.trim());
			}
			bf.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return szotar;
	}
	public static String kezdoKulcs(String kezdoszo, String rejt_uzenet) {
		String kulcsDarab = null;
		for (int i = 0; i < kezdoszo.length(); i++) {
			try {
				kulcsDarab += Rejtjelezes.numberToChar((Rejtjelezes.charToNumber(rejt_uzenet.charAt(i)) - Rejtjelezes.charToNumber(kezdoszo.charAt(i)) + 27) % 27);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		return kulcsDarab;
	}
	
}
