package rejtjel;

public class KulcsGuesser {
	public static char karakterVissza(char rejt_kar, char kulcs_kar) {
		try {
			int rejt_kod = Rejtjelezes.charToNumber(rejt_kar);
			int kulcs_kod = Rejtjelezes.charToNumber(kulcs_kar);	
		}
		catch(Exception e) {
			System.out.println("Exception: " + e);
		}
		char visszafejtett_kar = Rejtjelezes.numberToChar((rejt_kar - kulcs_kar + 27) % 27);
		return visszafejtett_kar;
	}
}
