package rejtjel;

public class Main {
	public static void main(String args[]) {
		String uzenet = "helloworld";
		String kulcs = "abcdefgijkl";
		String rejtjelezett = EncryptWholeMessage.encrypt(uzenet, kulcs);
		System.out.println("Rejtjelezett üzenet: " + rejtjelezett);
		String visszafejtett = DecryptWholeMessage.decrypt(rejtjelezett, kulcs);
		System.out.println("Visszafejtett üzenet: " + visszafejtett);
		String elsoUzenet = "curiosity killed the cat";
		String masodikUzenet = "early bird catches the worm";
		String tudottKulcs = "early";
	}
	public static final char[] karakterek = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
}
