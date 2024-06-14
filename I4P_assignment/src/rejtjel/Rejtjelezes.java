package rejtjel;

public class Rejtjelezes {
	static final char[] karakterek = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
	
	public static int charToNumber(char betu) throws Exception {
		for (int i = 0; i < karakterek.length; i++) {
			if (karakterek[i] == betu) {
				return i;
			}
		}
		throw new Exception("Error with this character:" + betu);
	}
	public static char numberToChar(int kod) {
		return karakterek[kod];
	}
	public static void main(String args[]) {
		String uzenet = "helloworld";
		String kulcs = "abcdefgijkl";
		String rejtjelezett = rejtjelez(uzenet, kulcs);
		System.out.println(rejtjelezett);
	}
	public static String rejtjelez(String uzenet, String kulcs) {
		String rejt_uzenet = "";
		for (int i = 0; i < uzenet.length(); i++) {
			try {
				rejt_uzenet += Rejtjelezes.numberToChar((Rejtjelezes.charToNumber(uzenet.charAt(i)) + Rejtjelezes.charToNumber(kulcs.charAt(i))) % 27);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rejt_uzenet;
	}
}