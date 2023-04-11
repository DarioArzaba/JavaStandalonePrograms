
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class LetterH {
	
	private int xLeft;
	private int yTop;
	private int size;
	
	public LetterH(int x, int y, int sizeTemp) {
		xLeft = x;
		yTop = y;
		size = sizeTemp;
	}

	public void draw(Graphics2D graphicsObj2D) {
		
		double unit = (double)(size)/100.0;
		
		GeneralPath letter = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		letter.moveTo(xLeft, yTop);
        letter.lineTo(xLeft + (35*unit), yTop + (0*unit));
        letter.lineTo(xLeft + (35*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (25*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (25*unit), yTop + (40*unit));
        letter.lineTo(xLeft + (75*unit), yTop + (40*unit));
        letter.lineTo(xLeft + (75*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (65*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (65*unit), yTop + (0*unit));
        letter.lineTo(xLeft + (100*unit), yTop + (0*unit));
        letter.lineTo(xLeft + (100*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (90*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (90*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (100*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (100*unit), yTop + (100*unit));
        letter.lineTo(xLeft + (65*unit), yTop + (100*unit));
        letter.lineTo(xLeft + (65*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (75*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (75*unit), yTop + (60*unit));
        letter.lineTo(xLeft + (25*unit), yTop + (60*unit));
        letter.lineTo(xLeft + (25*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (35*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (35*unit), yTop + (100*unit));
        letter.lineTo(xLeft + (0*unit), yTop + (100*unit));
        letter.lineTo(xLeft + (0*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (10*unit), yTop + (90*unit));
        letter.lineTo(xLeft + (10*unit), yTop + (10*unit));
        letter.lineTo(xLeft + (0*unit), yTop + (10*unit));
		letter.lineTo(xLeft, yTop);
		letter.closePath();
		
		graphicsObj2D.fill(letter);
		
	}
}	

class LetterE {
	
	private int xLeft;
	private int yTop;
	private int size;
	
	public LetterE(int x, int y, int sizeTemp) {
		xLeft = x;
		yTop = y;
		size = sizeTemp;
	}

	public void draw(Graphics2D graphicsObj2D) {
		
		double unit = (double)(size)/100.0;
		
		GeneralPath letter = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		letter.moveTo(xLeft, yTop);
		 letter.lineTo(xLeft + (100*unit), yTop + (0*unit));
	        letter.lineTo(xLeft + (100*unit), yTop + (20*unit));
	        letter.lineTo(xLeft + (20*unit), yTop + (20*unit));
	        letter.lineTo(xLeft + (20*unit), yTop + (40*unit));
	        letter.lineTo(xLeft + (75*unit), yTop + (40*unit));
	        letter.lineTo(xLeft + (75*unit), yTop + (60*unit));
	        letter.lineTo(xLeft + (20*unit), yTop + (60*unit));
	        letter.lineTo(xLeft + (20*unit), yTop + (80*unit));
	        letter.lineTo(xLeft + (100*unit), yTop + (80*unit));
	        letter.lineTo(xLeft + (100*unit), yTop + (100*unit));
	        letter.lineTo(xLeft + (0*unit), yTop + (100*unit));
		letter.lineTo(xLeft, yTop);
		letter.closePath();
		
		graphicsObj2D.fill(letter);
		
	}
}	

class LetterL {
	
	private int xLeft;
	private int yTop;
	private int size;
	
	public LetterL(int x, int y, int sizeTemp) {
		xLeft = x;
		yTop = y;
		size = sizeTemp;
	}

	public void draw(Graphics2D graphicsObj2D) {
		
		double unit = (double)(size)/100.0;
		
		GeneralPath letter = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		letter.moveTo(xLeft, yTop);
		letter.lineTo(xLeft + (20*unit), yTop + (0*unit));
        letter.lineTo(xLeft + (20*unit), yTop + (80*unit));
        letter.lineTo(xLeft + (80*unit), yTop + (80*unit));
        letter.lineTo(xLeft + (80*unit), yTop + (100*unit));
        letter.lineTo(xLeft + (0*unit), yTop + (100*unit));
		letter.lineTo(xLeft, yTop);
		letter.closePath();

		graphicsObj2D.fill(letter);
		
	}
}	

class LetterO {
	
	private int xLeft;
	private int yTop;
	private int size;
	
	public LetterO(int x, int y, int sizeTemp) {
		xLeft = x;
		yTop = y;
		size = sizeTemp;
	}

	public void draw(Graphics2D graphicsObj2D) {
		
		double unit = (double)(size)/100.0;
		
		Ellipse2D letter = new Ellipse2D.Double(xLeft, yTop, size, size);
		Ellipse2D letter2 = new Ellipse2D.Double(xLeft + (20*unit), yTop + (20*unit), size - (40*unit), size - (40*unit));
		
		graphicsObj2D.fill(letter);
		graphicsObj2D.setColor(Color.WHITE);
		graphicsObj2D.fill(letter2);
		
		graphicsObj2D.setColor(Color.BLACK);
		
	}
}	

class drawComponentLetters extends JComponent {
	public void paintComponent(Graphics graphicsObj) {

		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
		graphicsObj2D.setColor(Color.BLACK);
		
		LetterH H1 = new LetterH(100, 100, 100);
		H1.draw(graphicsObj2D);
		LetterE E1 = new LetterE(225, 100, 100);
		E1.draw(graphicsObj2D);
		LetterL L1 = new LetterL(360, 100, 100);
		L1.draw(graphicsObj2D);
		LetterL L2 = new LetterL(475, 100, 100);
		L2.draw(graphicsObj2D);
		LetterO O1 = new LetterO(585, 100, 100);
		O1.draw(graphicsObj2D);
		LetterH H2 = new LetterH(100, 225, 66);
		H2.draw(graphicsObj2D);
		LetterE E2 = new LetterE(191, 225, 66);
		E2.draw(graphicsObj2D);
		LetterL L3 = new LetterL(282, 225, 66);
		L3.draw(graphicsObj2D);
		LetterL L4 = new LetterL(373, 225, 66);
		L4.draw(graphicsObj2D);
		LetterO O2 = new LetterO(464, 225, 66);
		O2.draw(graphicsObj2D);
		LetterH H3 = new LetterH(100, 320, 33);
		H3.draw(graphicsObj2D);
		LetterE E3 = new LetterE(158, 320, 33);
		E3.draw(graphicsObj2D);
		LetterL L5 = new LetterL(216, 320, 33);
		L5.draw(graphicsObj2D);
		LetterL L6 = new LetterL(274, 320, 33);
		L6.draw(graphicsObj2D);
		LetterO O3 = new LetterO(332, 320, 33);
		O3.draw(graphicsObj2D);
		
	}
}

public class HelloDrawerLetters {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 800, 500);
		window.setTitle("Hello String Print");
		Color backgroundColor = new Color(255,255,255);
		window.getContentPane().setBackground(backgroundColor);
		drawComponentLetters drawComp = new drawComponentLetters();
		window.add(drawComp);
		window.setVisible(true);		
		
	}

}
