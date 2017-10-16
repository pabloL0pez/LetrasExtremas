package letras;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			// generarCasoFatiga();
			LetrasExtremas extremas = new LetrasExtremas("extremas.in");
			extremas.resolver();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void generarCasoFatiga() throws IOException {
		char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String[] bases = {"xxxaaxxx","xxxabxxx","xxxacxxx","xxxadxxx","xxxaexxx","xxxafxxx","xxxagxxx","xxxahxxx","xxxaixxx","xxxajxxx","xxxakxxx","xxxalxxx","xxxamxxx","xxxanxxx","xxxaoxxx",
				"xxxapxxx","xxxaqxxx","xxxarxxx","xxxasxxx","xxxatxxx","xxxauxxx","xxxavxxx","xxxawxxx","xxxaxxxx","xxxayxxx","xxxazxxx"};
		
		FileWriter file = new FileWriter("extremas.in");
		BufferedWriter buffer = new BufferedWriter(file);
		buffer.write(String.valueOf(247));
		buffer.newLine();
		for (int i = 0 ; i < 19 ; i++) {
			for (int j = 0 ; j < 25 ; j+=2) {
				buffer.write(abecedario[j] + bases[i] + abecedario[j+1]);
				buffer.newLine();
			}
		}
		
		buffer.close();
	}

}
