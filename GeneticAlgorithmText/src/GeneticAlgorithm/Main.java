package GeneticAlgorithm;

public class Main {

	public static void main(String[] args) {
		String targetString = "test";
		int populationSize = 100;
		double mutationRate = 0.02;
		Main main = new Main();
		main.geneticAlgorithm(populationSize, mutationRate, targetString);	
	}
	
	public void geneticAlgorithm(int populationSize, double mutationRate, String targetString) {
		Population population = new Population(populationSize, mutationRate, targetString);
		population.printPopulationDNA();
		while(true) {
			if(population.checkPopulation()) {
				break;
			} else {
				population.calculateFitnessValues();
				population.naturalSelection();
				population.printPopulationDNA();
			}
		}
		System.out.println(population.getGeneration());
	}

}
