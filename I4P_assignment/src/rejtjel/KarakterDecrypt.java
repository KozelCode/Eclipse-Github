package rejtjel;

public class KarakterDecrypt {
	public static char karakterDecrypt(char rejt_kar, char kulcs_kar) {
		return NumberToChar.numberToChar((rejt_kar - kulcs_kar + 27) % 27);
	}
}
