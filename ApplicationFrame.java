
import javax.swing.JFrame;

public class ApplicationFrame extends JFrame {
	
	public ApplicationFrame(JFrame panel) { 
	panel = new JFrame(); // creates frame
	panel.setTitle("Aukely's Function (Figure 1)"); // sets name on title bar
	panel.setSize(600,600); // sets size of GUI frame
	panel.setLocationRelativeTo(null); // Centers GUI frame
	panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stop or Close program on exit 
	panel.setVisible(true); // Shows the frame
	}


}
