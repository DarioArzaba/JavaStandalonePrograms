
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class drawComponentOlympicLogo extends JComponent {
	public void paintComponent(Graphics graphicsObj) {

		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
	
		Ellipse2D OuterRingOne = new Ellipse2D.Double(50, 50, 100, 100);
		Ellipse2D InnerRingOne = new Ellipse2D.Double(58, 58, 84, 84);
		Area FirstRingArea = new Area(OuterRingOne);
		FirstRingArea.subtract(new Area(InnerRingOne));
	    Shape FirstRing = FirstRingArea;
	    graphicsObj2D.setPaint(Color.BLUE);
		graphicsObj2D.fill(FirstRing);
	    
		Ellipse2D OuterRingTwo = new Ellipse2D.Double(150, 50, 100, 100);
		Ellipse2D InnerRingTwo = new Ellipse2D.Double(158, 58, 84, 84);
		Area SecondRingArea = new Area(OuterRingTwo);
		SecondRingArea.subtract(new Area(InnerRingTwo));
	    Shape SecondRing = SecondRingArea;
	    graphicsObj2D.setPaint(Color.BLACK);
		graphicsObj2D.fill(SecondRing);
		
		Ellipse2D OuterRingThree = new Ellipse2D.Double(250, 50, 100, 100);
		Ellipse2D InnerRingThree = new Ellipse2D.Double(258, 58, 84, 84);
		Area ThirdRingArea = new Area(OuterRingThree);
		ThirdRingArea.subtract(new Area(InnerRingThree));
	    Shape ThirdRing = ThirdRingArea;
	    graphicsObj2D.setPaint(Color.RED);
		graphicsObj2D.fill(ThirdRing);
		
		Ellipse2D OuterRingFour = new Ellipse2D.Double(100, 90, 100, 100);
		Ellipse2D InnerRingFour = new Ellipse2D.Double(108, 98, 84, 84);
		Area FourthRingArea = new Area(OuterRingFour);
		FourthRingArea.subtract(new Area(InnerRingFour));
	    Shape FourthRing = FourthRingArea;
	    graphicsObj2D.setPaint(Color.YELLOW);
		graphicsObj2D.fill(FourthRing);
		
		Ellipse2D OuterRingFive = new Ellipse2D.Double(200, 90, 100, 100);
		Ellipse2D InnerRingFive = new Ellipse2D.Double(208, 98, 84, 84);
		Area FifthRingArea = new Area(OuterRingFive);
		FifthRingArea.subtract(new Area(InnerRingFive));
	    Shape FifthRing = FifthRingArea;
	    graphicsObj2D.setPaint(Color.GREEN);
		graphicsObj2D.fill(FifthRing);
		
	}
}

public class OlympicLogoDrawer {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 800, 500);
		window.setTitle("Olympic Games Logo");
		Color backgroundColor = new Color(255,255,255);
		window.getContentPane().setBackground(backgroundColor);
		drawComponentOlympicLogo drawComp = new drawComponentOlympicLogo();
		window.add(drawComp);
		window.setVisible(true);		
		
	}

}

