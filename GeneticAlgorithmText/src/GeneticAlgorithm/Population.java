package GeneticAlgorithm;

import java.util.Arrays;

public class Population {

	private DNA populationDNA[];
	private int populationSize;
	private double populationMutation;
	private String populationGoal;
	
	public Population(int populationSize, double populationMutation, String populationGoal) {
		this.populationSize = populationSize;
		this.populationMutation = populationMutation;
		this.populationGoal = populationGoal;
		populationDNA = createPopulationDNA(populationSize, populationGoal);
	}
	
	private DNA[] createPopulationDNA(int size, String goal) {
		DNA dna[] = new DNA[size];
		for(int i =0; i < size; i++) {
			dna[i] = new DNA(goal.length());
		}
		return dna;
	}
	
	public void printPopulationDNA () {
		System.out.println(Arrays.toString(populationDNA));
	}
}
