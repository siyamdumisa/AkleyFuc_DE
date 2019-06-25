import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author Siyamdumisa Maphisa
 * 201572627
 * Evolutionary Computation
 * Optimization
 *
 */

public class Main {

	
	private static final int populationsize = 50;
	private static final int noiterations = 10000;
	private static final double F = 0.4;
	private static final double CR = 0.5;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Random rand = new Random();
		int nextpopulation = 0;//counter(integer used for incrementing after each generation)
	
		double[] xdimension = new double[2]; //x-dimension of the agent's range from -5 <= x <= 5
		xdimension[0] = -5.0;
		xdimension[1] = 5.0;
		
		double[] ydimension = new double[2]; //y-dimension of the agent's range from -5 <= y <= 5
		ydimension[0] = -5.0;
		ydimension[1] = 5.0;
		
		
		ArrayList<double[]> dimensionlist = new ArrayList<double[]>(); //arraylist to store the arrays
		dimensionlist.add(xdimension);
		dimensionlist.add(ydimension);
		
		
		int dimensionsize = dimensionlist.size()-1; //dimension size
	
		ArrayList<ArrayList<Agent>> generations = new ArrayList<ArrayList<Agent>>();
		ArrayList<Agent> agents = new ArrayList<>(); //initializing the agent's arraylist to store the population
		
		/**
		 * adding agents of the population size to the arrayList
		 */
		
		for(int r=0;r<populationsize;r++)
		{
			Agent agent = new Agent(dimensionlist); //agent to be stored in the arraylist
			agents.add(agent); //adding agents in the arraylist
			
		}
		
		ArrayList<Agent> trialvectors = new ArrayList<Agent>(); //arraylist to store the trialvector
		
		/**
		 *  Main loop for the algorithm
		 */
	
		while(nextpopulation<noiterations)
		{	
			ArrayList<Agent> selectedAgents = new ArrayList<Agent>(); //arraylist to store the 3 selected agents
			
			for(int r=0;r<agents.size();r++) // for each agent x:
			{
			
			    Agent x = agents.get(r); //get the agent x
			   
			    //while loop to get the distinct indices for the 3 selected agents
			    while(selectedAgents.size() != 3)
			    {
			
			    	int a = rand.nextInt(49-0+1)+0; //random index for the first agent
			    
			    	int b = rand.nextInt(49-0+1)+0; //random index for the second agent
			    
			    	int c = rand.nextInt(49-0+1)+0; //random index for the third agent
			    
			    	//if all indices are distinct then add all the 3 agents to the arraylist
			    	if(a != r && a!= b && a!= c && b != r && b != c && c!=r)
			    	{
			    		selectedAgents.add(agents.get(a));
			    		selectedAgents.add(agents.get(b));
			    		selectedAgents.add(agents.get(c));
			    
			    	}
			    	
			    	
			    }
		
				
				Agent agenta = selectedAgents.get(0); //assigning the first index to agenta
				Agent agentb = selectedAgents.get(1); //assigning the second index to agentb
				Agent agentc = selectedAgents.get(2); //assigning the third index to agentc
				
				Random randomdim = new Random(); //
				
				Agent trialvector = new Agent(dimensionlist); //trial vector
				int R = randomdim.nextInt(dimensionsize-0+1)+0; //random integer from 1 to dimension size = 2
			
				for(int j=0;j<dimensionlist.size();j++)
				{
					double randomnumber = rand.nextDouble(); //random number from [0,1]
					// Binomial crossover
					if(randomnumber <CR  || R==j)
					{
					
						trialvector.coordinates[j] = (int) (agenta.coordinates[j] + F * (agentc.coordinates[j] - agentb.coordinates[j]));
					}
					else
					{
						
						trialvector.coordinates[j] = (int) (x.coordinates[j]);
					}
							
				}
				trialvectors.add(trialvector); //adding all the trial vectors
				
			}
			
			//for each population
			for(int r=0;r<populationsize;r++)
			{
				Agent x = agents.get(r); 
				Agent mutant = trialvectors.get(r);
				//calculating the fittest agent from the population
				if(fitnessFunction(mutant,x))
				{
					agents.set(r, mutant); //replacing the agent in index r with  a fit agent				
				}
				
			}
		
			nextpopulation++;
		    generations.add(agents);
		}
		
		printPopulations(generations);
		
		Agent best = agents.get(0); //current best at index 0

		for(int r=0;r<populationsize;r++)
		{
			
			if(fitnessFunction(agents.get(r),best))
			{
				best = agents.get(r); //retrieving the best result out of all agents
			}
		}
		System.out.println("Fittest result"+" "+best.coordinates[0]+","+best.coordinates[1]); //outputting the coordinates for the best agent
	
		
	}
	//fitness function
	public static boolean fitnessFunction(Agent mutantvector,Agent x)
	{
	
		
		
		double fofmv = 20 + Math.E -
				Math.pow(20, (double)-0.2 * Math.sqrt((double)1/2 *((double)Math.pow(mutantvector.coordinates[0], 2) + 
						(double)Math.pow(mutantvector.coordinates[1], 2))) - 
						((double)1/2*Math.cos(2*Math.PI*mutantvector.coordinates[0]) +
								Math.cos(2*Math.PI*mutantvector.coordinates[1])))+ Math.E + 20;
		
		double fofx = 20 + Math.E -
				Math.pow(20, -0.2 * Math.sqrt((double)1/2 *((double)Math.pow(x.coordinates[0], 2) + 
						(double)Math.pow(x.coordinates[1], 2))) - ((double)1/2*Math.cos(2*Math.PI*x.coordinates[0]) 
								+ Math.cos(2*Math.PI*x.coordinates[1]))) + Math.E + 20;
		
		boolean fitness = fofmv < fofx;
        
		return fitness;
	}
	public static void printPopulations(ArrayList<ArrayList<Agent>> generations)
	{
		
		for(int r=0;r<generations.size();r++)
		{
			ArrayList<Agent> population = generations.get(r);
			System.out.println("Generation"+" "+r);
			for(int j=0;j<population.size();j++)
			{
				System.out.println(population.get(j).getX()+" "+population.get(j).getY());
			}
			System.out.println();
			System.out.println("---------------------------------------------------------");
		}
		
	}

}