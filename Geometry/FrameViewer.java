
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

public class FrameViewer {

	public static void main(String[] args) throws MalformedURLException {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		Color myColor = new Color(152,251,152).brighter();
		
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);
		
		JLabel label = new JLabel("      Hello, Dario!      ");
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setOpaque(true);
		frame.add(label);
		
		URL imageLocation = new URL("https://upload.wikimedia.org/wikipedia/commons/b/b4/Michael_Stevens_VidCon_2016.jpg");
		ImageIcon image = new ImageIcon(imageLocation);
		JLabel imageComp = new JLabel(image);
		frame.add(imageComp);
		
		frame.getContentPane().setBackground(myColor);
		label.setBackground(myColor);
		frame.setVisible(true);

	}

}
