package letras;

public class LetraRepetida implements java.lang.Comparable<LetraRepetida>{

	private char letra;
	private int repeticiones;
	
	public LetraRepetida(char letra) {
		this.letra = letra;
		this.repeticiones = 1;
	}
	
	public char getLetra() {
		return this.letra;
	}
	
	public int getRepeticiones() {
		return this.repeticiones;
	}
	
	public void repetirLetra() {
		this.repeticiones++;
	}

	@Override
	public int compareTo(LetraRepetida o) {
		return o.getRepeticiones() - this.getRepeticiones();
	}

}
