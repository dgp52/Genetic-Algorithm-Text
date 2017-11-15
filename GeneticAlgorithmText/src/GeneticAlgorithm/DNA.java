package GeneticAlgorithm;

public class DNA {
	private int size;
	private Gene gene;
	private double fitnessPercentage;
	
	public DNA (int size) {
		this.size = size;
		gene = new Gene(size);		
	}

	public Gene getGene() {
		return gene;
	}
	
	@Override 
	public String toString() {
		return gene.toString();
	}

}
