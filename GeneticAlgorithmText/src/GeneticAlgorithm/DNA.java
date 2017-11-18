package GeneticAlgorithm;

import java.util.Random;

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
		//adding 0.1 for all elements to have equal chance to get picked
		//This is a case where the fitness value is 0.0
		fitnessValue = Math.pow((double)value/(double)gene.getSize(), 2) + 0.1;
	}
	
	public DNA crossOver(DNA partner) {
		DNA child = new DNA(size);
		char parentOne[] = gene.getGene();
		char parentTwo[] = partner.gene.getGene();
		char childGene[] = child.gene.getGene();
		Random random = new Random();
		int index = random.nextInt(gene.getSize());
		for(int i = 0; i < gene.getSize(); i++) {
			if(i > index) {
				childGene[i] = parentOne[i];
			} else {
				childGene[i] = parentTwo[i];
			}
		}
		return child;
	}
	
	public void mutation(double mutationRate) {
		for(int i =0; i < gene.getSize(); i++) {
			Random random = new Random();
			char childGene[] = gene.getGene();
			double r = 1*random.nextDouble();
			if(r < mutationRate) {
				childGene[i] = gene.getRandomChar();
			}
		}
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
