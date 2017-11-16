package GeneticAlgorithm;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Population population = new Population(10, 0.03, "test");
		population.printPopulationDNA();
		
		population.calculateFitnessValues();
		population.printPopulationDNAFitness();
		
		population.naturalSelection();
	}

}
