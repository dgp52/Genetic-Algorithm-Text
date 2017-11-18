package GeneticAlgorithm;

public class Main {
	private String targetString = "genetics";
	private int populationSize = 500;
	private double mutationRate = 0.0;
	
	public static void main(String[] args) {
		Main main = new Main();
		//main.testPopulationBehaviour();
		//main.testMutationBehaviour();
		main.geneticAlgorithm(main.populationSize, main.mutationRate, main.targetString);	
	}
	
	private void geneticAlgorithm(int populationSize, double mutationRate, String targetString) {
		Population population = new Population(populationSize, mutationRate, targetString);
		//population.printPopulationDNA();
		while(true) {
			if(population.checkPopulation()) {
				break;
			} else {
				population.calculateFitnessValues();
				population.naturalSelection();
				//population.printPopulationDNA();
			}
		}
		System.out.println("Population size: " + populationSize + 
				", Mutation Rate: " + String.format( "%.2f", mutationRate) +
				", Generation: " + population.getGeneration());
	}
	
	/*Testing Purposes
	What happens if we increase the size of the population? 
	Double the size of population in each loop and compare the number of generations
	Conclusion: As the number of population increases, the generation decreases*/
	private void testPopulationBehaviour () {
		while(populationSize < 10000) {
			geneticAlgorithm(populationSize, mutationRate, targetString);
			populationSize = populationSize*2;
		}
	}
	
	/*What happens if we increase the mutation rate?
	 Increase mutation by 0.1 in each for loop.
	 Conclusion: In general, higher mutation rate takes longer generation,but we should also add 
	 a small change/mutation in every generation. Adding a small amount of mutation is 
	 important because every generation will be different and unique from previous generation.*/
	private void testMutationBehaviour () {
		while(mutationRate <= 1.0) {
			geneticAlgorithm(populationSize, mutationRate, targetString);
			mutationRate = mutationRate + 0.01;
		}
	}

}
