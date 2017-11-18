package GeneticAlgorithm;

import java.util.Arrays;

public class Population {

	private DNA populationDNA[];
	private int populationSize;
	private double populationMutation;
	private String populationGoal;
	private int generation;
	
	public Population(int populationSize, double populationMutation, String populationGoal) {
		this.populationSize = populationSize;
		this.populationMutation = populationMutation;
		this.populationGoal = populationGoal;
		populationDNA = createPopulationDNA(populationSize, populationGoal);
		generation = 1;
	}
	
	private DNA[] createPopulationDNA(int size, String goal) {
		DNA dna[] = new DNA[size];
		for(int i =0; i < size; i++) {
			dna[i] = new DNA(goal.length());
		}
		return dna;
	}
	
	public void calculateFitnessValues() {
		for(DNA dna: populationDNA) {
			dna.calculateFitnessValue(populationGoal);
		}
	}
	
	public void naturalSelection () {
		DNA newGeneration[] = new DNA[populationSize];
		for(int i = 0; i < populationSize; i++) {
			ProbabilityGenerator<DNA> pg = new ProbabilityGenerator<>();
			for(DNA dna: populationDNA) {
				pg.addElementProbability(dna, dna.getFitnessValue());
			}
			DNA parents[] = new DNA[2];
			for(int j =0; j < parents.length; j++) {
				parents[j] = pg.sumAndPick();
			}
			//pg.printCount();
			//Cross Over. AKA mixing both parents gene
			DNA offspring = parents[0].crossOver(parents[1]);
			offspring.mutation(populationMutation);
			newGeneration[i] = offspring;			
		}
		populationDNA = newGeneration;
		generation++;
	}
	
	public void printPopulationDNA () {
		System.out.println(Arrays.toString(populationDNA));
	}
	
	public boolean checkPopulation () {
		boolean result = false;
		char tg[] = populationGoal.toCharArray();
		for(int i = 0; i < populationDNA.length; i++) {
			char g[] = populationDNA[i].getGene().getGene();
			if (Arrays.equals(g, tg)) {
				result =  true;
				break;
			} else {
				result =  false;
			}
		}
		return result;
	}
	
	public int getGeneration() {
		return generation;
	}
	
	
	public void printPopulationDNAFitness() {
		double dnafitness[] = new double[populationSize];
		for(int i = 0; i < populationSize; i++) {
			dnafitness[i] = populationDNA[i].getFitnessValue();
		}
		System.out.println(Arrays.toString(dnafitness));
	}
}
