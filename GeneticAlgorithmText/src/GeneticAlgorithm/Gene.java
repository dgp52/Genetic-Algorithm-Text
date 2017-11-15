package GeneticAlgorithm;

import java.util.Random;

public class Gene {
	private char gene[];
	private int size;
	
	public Gene (int size) {
		this.size = size;
		//Initially gene is random char from a-z (lower case only)
		this.gene = createGene(size);
	}
	
	private char[] createGene (int size) {
		char g[] = new char[size];
		for(int i = 0; i < size; i++) {
			g[i] = getRandomChar();
		}
		return g;
	}
	
	private char getRandomChar() {
		Random r = new Random();
		return (char)(r.nextInt(26) + 'a');
	}
	
	public char[] getGene() {
		return gene;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return String.valueOf(gene);
	}

}
