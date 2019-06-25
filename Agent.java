import java.util.ArrayList;
import java.util.Random;

public class Agent {

	private Random rand;
	private double x;
	private double y;
	 double[] coordinates;
	
	public Agent(ArrayList<double[]> dimensions)
	{
		rand = new Random();
		coordinates = new double[dimensions.size()]; //array to store the agent's coordinates
		
		for(int r=0;r<dimensions.size();r++)
		{
			
			int lbound = (int)dimensions.get(r)[0]; //lowerbound
			int ubound = (int)dimensions.get(r)[1]; //upperbound
			
			int value = rand.nextInt(ubound - lbound+1) + lbound; //random value from -5 to 5
			coordinates[r] = value;
		}
		
		this.x = coordinates[0];
		this.y = coordinates[1];
		
	}
	public void setCoordinates(double[] coordinates)
	{
		this.coordinates = coordinates;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double[] coordinates()
	{
		return this.coordinates;
	}
	
	
	
}
