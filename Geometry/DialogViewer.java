
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DialogViewer {
	
	public static void main(String[] args) throws MalformedURLException {
		
		String name = JOptionPane.showInputDialog("What is your name?");
		
		System.out.println("Hello, " + name + "!");
		
		JOptionPane.showInputDialog("My name is Hal! What would you like me to do?");
		
		System.out.println("I'm sorry, "+ name + ". I'm afraid I can't do that.");
		
		String ValidLink = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/White_and_yellow_flower.JPG/320px-White_and_yellow_flower.JPG";

		URI imageLocationURI = URI.create(ValidLink);

		URL imageLocationURL = imageLocationURI.toURL();

		JOptionPane.showMessageDialog(null, "Hello!", "Greeting Box", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocationURL));
		
		System.exit(0);
		
	}
	
}



