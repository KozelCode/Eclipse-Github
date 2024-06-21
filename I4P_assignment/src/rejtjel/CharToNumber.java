package rejtjel;

public class CharToNumber {
	public static int charToNumber(char betu) throws Exception {
		for (int i = 0; i < Main.karakterek.length; i++) {
			if (Main.karakterek[i] == betu) {
				return i;
			}
		}
		throw new Exception("Error with this character:" + betu);
	}
}
