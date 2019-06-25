import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;



public class ApplicationPanel extends JPanel {

	private ArrayList<Agent> agents;
	private int x;

	public ApplicationPanel(ArrayList<Agent> agents)
	{
		this.agents = agents;
	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(int r=0;r<agents.size()-25;r++)
		{
		    Agent x = agents.get(r);
				
		
		}
		g.setColor(Color.RED);
		g.fillOval(x, x, 10, 10);
		g.fillOval(50+x, 50, 12, 12);
	    
		
	}
	public void update(ArrayList<Agent> agents, int x)
	{
		this.agents = agents;
		this.x =x;
		repaint();
		
	}
	




	public void draw(ArrayList<Agent> agents,int x)
	{
		//panel.update(agents,x);
	
	}




}
