package rejtjel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class SzotarReader {
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
}
