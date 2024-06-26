package rejtjel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FinalAndOrganized {
	static char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
//	example cipher texts for my testing purposes
	static String ciphertext1 = "ocwybnquwuml yadk exfmsm";
	static String ciphertext2 = "qjwalvjjpybfpfzhpzxlnorpshf";
	static String starterWord = "early ";
	static int maxLength = Math.max(ciphertext1.length(), ciphertext2.length());
	static String keyBeginning = null;
    static HashSet<String> wordSet = new HashSet<>();
	
	public static void main(String[] args) {
		
//		load the words.txt into a set
        try (BufferedReader bf = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                wordSet.add(line.trim());
            }
        } 
        catch (IOException e) {
        	System.out.println("Error while reading the file");
        }
        
        String exampleMessage = "helloworld";
        String exampleKey = "abcdefgijkl";
        String encryptedMessage = "";
        
        for (int i = 0; i < exampleMessage.length(); i++) {
        	   encryptedMessage += characters[(charToCode(exampleMessage.charAt(i)) + charToCode(exampleKey.charAt(i))) % 27];
        	}
        	System.out.println("Encrypted message: " + encryptedMessage);

        	String decryptedMessage = "";
        	for (int i = 0; i < encryptedMessage.length(); i++) {
        	   decryptedMessage += characters[(charToCode(encryptedMessage.charAt(i)) - charToCode(exampleKey.charAt(i)) + 27) % 27];
        	   if (decryptedMessage.charAt(i) < 0) {
        	       decryptedMessage = decryptedMessage.substring(0, i) + characters[27 + decryptedMessage.charAt(i)];
        	   }
        	}
        	System.out.println("Decrypted message: " + decryptedMessage);
        convertStarterWord();
        keyFinder();
	}
	public static int charToCode(char letter) {
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == (letter)) {
				return i;
			}
		}
		return -1;
	}
	public static char codeToChar(int code) {
		return characters[code];
	}
	public static String convertStarterWord() { 
		keyBeginning = ""; 
		for(int i = 0; i < starterWord.length(); i++) { 
			keyBeginning += codeToChar((charToCode(ciphertext2.charAt(i)) - charToCode(starterWord.charAt(i)) + 27) % 27); 
		} 
//		System.out.println("Key beginning: " + keyBeginning); 
		return keyBeginning; 
	}
	public static void keyFinder() { String key = keyBeginning; String plainText1 = ""; String plainText2 = starterWord;

	for (int i = 0; i < key.length() && i < ciphertext1.length(); i++) {
	    int cipherCode = charToCode(ciphertext1.charAt(i));
	    int keyCode = charToCode(key.charAt(i));

	    if (cipherCode < keyCode) {
	        plainText1 += codeToChar((27 - keyCode + cipherCode) % 27);
	    } else {
	        plainText1 += codeToChar((cipherCode - keyCode + 27) % 27);
	    }
	}

	final String finalPlainText1 = plainText1;
	String line = wordSet.stream().filter(l -> l.contains(finalPlainText1)).findFirst().orElse(null);
	if (line != null) {
	    line = line.replace(plainText1, "") + " ";

	    for (int j = 0; j < ciphertext2.length(); j++) {
	        String tempKey = key + codeToChar((charToCode(line.charAt(j % line.length())) - charToCode(ciphertext2.charAt(j)) + 27) % 27);
	        String tempPlainText = plainText2 + line.charAt(j % line.length());

	        key = tempKey;
	        plainText2 = tempPlainText;
	    }
	}

	System.out.println("Key: " + key);
	}
}
