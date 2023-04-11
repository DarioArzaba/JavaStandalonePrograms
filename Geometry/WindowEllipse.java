
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

class drawComponentWindowEllipse extends JComponent {
	public void paintComponent(Graphics graphicsObj) {
		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
		
		int x = getWidth();
		int y = getHeight();
		Ellipse2D circle = new Ellipse2D.Double(0,0,x,y);
		graphicsObj2D.setColor(Color.GREEN);
		graphicsObj2D.fill(circle);
		graphicsObj2D.setColor(Color.BLACK);
		graphicsObj2D.draw(circle);
		
	}
}

public class WindowEllipse {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(450, 200, 400, 400);
		window.setTitle("Window Ellipse");
		Color backgroundColor = new Color(152,51,152).brighter();
		window.getContentPane().setBackground(backgroundColor);
		drawComponentWindowEllipse drawComp = new drawComponentWindowEllipse();
		window.add(drawComp);
		window.setVisible(true);		
		
	}

}