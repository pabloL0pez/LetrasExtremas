package letras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class LetrasExtremas {
	
	private ArrayList<LetraRepetida> letrasExtremas = new ArrayList<LetraRepetida>();
	private String[] palabras;
	private int cantPalabras;
	
	public LetrasExtremas(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		String palabra = null;
		
		this.cantPalabras = scan.nextInt();
		this.palabras = new String[this.cantPalabras];
		
		for(int i = 0 ; i < this.cantPalabras ; i++) {
			palabra = scan.next();
			this.palabras[i] = palabra;
			
			agregarLetraExtrema(palabra.charAt(0));
			agregarLetraExtrema(palabra.charAt(palabra.length() - 1));
		}
		
		scan.close();
	}
	
	private void agregarLetraExtrema(char letra) {
		for (int i = 0 ; i < this.letrasExtremas.size() ; i++) {
			if (this.letrasExtremas.get(i).getLetra() == letra) {
				this.letrasExtremas.get(i).repetirLetra();
				return;
			}
		}
		
		this.letrasExtremas.add(new LetraRepetida(letra));
	}
	
	public void resolver() throws IOException {
		int i = 1;
		int repeticiones = 0;
		ArrayList<LetraRepetida> lasMasRepetidas = new ArrayList<LetraRepetida>();
		TreeSet<String> palabrasTree = new TreeSet<String>();
		
		Collections.sort(this.letrasExtremas);
		repeticiones = this.letrasExtremas.get(0).getRepeticiones();
		lasMasRepetidas.add(this.letrasExtremas.get(0));
		
		while (i < this.letrasExtremas.size() && repeticiones == this.letrasExtremas.get(i).getRepeticiones()) { // Acá me quedo con las letras que están más repetidas.
			lasMasRepetidas.add(this.letrasExtremas.get(i));
			i++;
		}
		
		for (i = 0 ; i < lasMasRepetidas.size() ; i++) {
			for (int j = 0 ; j < this.palabras.length ; j++) {
				if (contieneLetraExtrema(this.palabras[j], lasMasRepetidas.get(i).getLetra())) {
					palabrasTree.add(this.palabras[j]);
				}
			}
		}
		
		escribirSolucion(lasMasRepetidas, palabrasTree);
	}
	
	private boolean contieneLetraExtrema(String palabra, char letra) {
		return palabra.charAt(0) == letra || palabra.charAt(palabra.length() - 1) == letra;
	}
	
	private void escribirSolucion(ArrayList<LetraRepetida> lasMasRepetidas, TreeSet<String> palabrasTree) throws IOException {
		FileWriter file = new FileWriter("extremas.out");
		BufferedWriter buffer = new BufferedWriter(file);
		
		for (int i = 0 ; i < lasMasRepetidas.size() ; i++) {
			buffer.write(String.valueOf(lasMasRepetidas.get(i).getLetra()) + " ");
		}
		
		buffer.newLine();
		
		for (String palabra : palabrasTree) {
			buffer.write(palabra);
			buffer.newLine();
		}
		
		buffer.close();
	}

}
