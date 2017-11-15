package GeneticAlgorithm;

public class DNA {
	private int size;
	private Gene gene;
	private double fitnessValue;

	public DNA (int size) {
		this.size = size;
		gene = new Gene(size);		
	}
	
	public void calculateFitnessValue(String populationGoal) {
		char[] currentGene = gene.getGene();
		char popGoal[] = populationGoal.toCharArray();
		int value = 0;
		for (int i = 0; i < gene.getSize(); i++) {
			if(currentGene[i] == popGoal[i]) {
				value++;
			}
		}
		fitnessValue = Math.pow((double)value/(double)gene.getSize(), 2);
	}

	public Gene getGene() {
		return gene;
	}
	
	public double getFitnessValue() {
		return fitnessValue;
	}
	
	@Override 
	public String toString() {
		return gene.toString();
	}

}
