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
}
