import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class CarDrawing {
	
	private int xLeft;
	private int yTop;
	private Color color;
	private int size;
	
	public CarDrawing(int x, int y, int sizeTemp, Color colorTemp) {
		xLeft = x;
		yTop = y;
		size = sizeTemp;
		color = colorTemp;
	}

	public void draw(Graphics2D graphicsObj2D) {
		
		double unit = (double)(size)/100.0;
		
		Rectangle2D body = new Rectangle2D.Double(xLeft + (0*unit), yTop + (10*unit), (60*unit), (10*unit));
		Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + (10*unit), yTop + (20*unit), (10*unit), (10*unit));
		Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + (40*unit), yTop + (20*unit), (10*unit), (10*unit));
		GeneralPath roof = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		roof.moveTo(xLeft + (10*unit), yTop + (10*unit));
		roof.lineTo(xLeft + (20*unit), yTop);
		roof.lineTo(xLeft + (40*unit), yTop);
		roof.lineTo(xLeft + (50*unit), yTop + (10*unit));
		roof.closePath();
		Line2D eraseLine = new Line2D.Double(xLeft + (50*unit), yTop + (10*unit), xLeft + (10*unit), yTop + (10*unit) );
		graphicsObj2D.setColor(Color.BLACK);
		graphicsObj2D.draw(frontTire);
		graphicsObj2D.draw(rearTire);
		graphicsObj2D.setColor(Color.GRAY);
		graphicsObj2D.fill(frontTire);
		graphicsObj2D.fill(rearTire);
		graphicsObj2D.setColor(color);
		graphicsObj2D.fill(body);
		graphicsObj2D.fill(roof);
		graphicsObj2D.setColor(Color.BLACK);
		graphicsObj2D.draw(body);
		graphicsObj2D.draw(roof);
		graphicsObj2D.setColor(color);
		graphicsObj2D.draw(eraseLine);
		
	}
}	

class drawComponentCar extends JComponent {
	public void paintComponent(Graphics graphicsObj) {

		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
		
		CarDrawing car1 = new CarDrawing(0, 0, 120, Color.RED);
		
		int x = getWidth() - 73;
		int y = getHeight() - 37;
		CarDrawing car2 = new CarDrawing(x, y, 120,  Color.BLUE);
		
		x = getWidth()/2 - 73;
		y = getHeight()/2 - 37;
		CarDrawing car3 = new CarDrawing(x, y, 240, Color.GREEN);

		car1.draw(graphicsObj2D);
		car2.draw(graphicsObj2D);
		car3.draw(graphicsObj2D);
		
	}
}

public class CarViewerColorTwo {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 800, 500);
		window.setTitle("Car Two");
		Color backgroundColor = new Color(255,255,255);
		window.getContentPane().setBackground(backgroundColor);
		drawComponentCar drawComp = new drawComponentCar();
		window.add(drawComp);
		window.setVisible(true);		
		
	}

}
