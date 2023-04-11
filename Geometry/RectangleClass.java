
import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

class drawComponent extends JComponent {
	public void paintComponent(Graphics graphicsObj) {
		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
		
		//CONSTRUCTORS
		
		//Create a new rectangle with position and size (0)
		Rectangle2D.Double constructorTest0 = new Rectangle2D.Double();
		
		//Create a new rectangle with specified position and size (x, y, w, h)
		Rectangle2D.Double constructorTest1 = new Rectangle2D.Double(10.0, 10.0, 10.0, 10.0);
		
		//METHODS
		
		Rectangle2D.Double test = new Rectangle2D.Double();
		
		//Change Height, Width, X position and Y position
		test.height = 10.0;
		test.width = 10.0;
		test.x = 10.0;
		test.y = 10.0;
		graphicsObj2D.draw(test);
		
		//Set new values for every Field
		test.setRect(35.0, 35.0, 20.0, 20.0);
		graphicsObj2D.draw(test);
		
		//Set new values for every Field based on another Rectangle
		Rectangle2D.Double test2 = new Rectangle2D.Double(35.0, 70.0, 15.0, 15.0);
		test.setRect(test2);
		graphicsObj2D.draw(test);
		
		//Bitmask variables that tell java the area of the rectangle for intersection calculations.
		int pixelLeftRectangle = test.OUT_LEFT;
		int pixelUpRectangle = test.OUT_TOP;
		int pixelRightRectangle = test.OUT_RIGHT;
		int pixelBottomRectangle = test.OUT_BOTTOM;
		
		//Using the above bitmasks values (1, 2, 4, 8) for (L, T, R, B) test a point direction.
		int pixelDirectionToRectangle = test.outcode(36.0, 200.0); //Result = 8 = Bottom
		
		//Return the values from the fields of a rectangle
		double currentHeight = test.getHeight();
		double currentWidth = test.getWidth();
		double currentX = test.getX();
		double currentY = test.getY();
		double currentCenterX = test.getCenterX();
		double currentCenterY = test.getCenterY();
		
		//Test if the rectangle is empty (All its values are 0)
		boolean constructor0IsEmpty = constructorTest0.isEmpty();
		boolean testIsEmpty = test.isEmpty();
		
		//Return a rectangle that encloses the current one.
		//Useful for making sure some modification applies to this rectangle.
		Rectangle2D boundingBox = test.getBounds2D();
		
		//Create a new rectangle based on the intersection (contained) inside both rectangles.
		Rectangle2D.Double test4 = new Rectangle2D.Double(80.0, 35.0, 15.0, 15.0);
		Rectangle2D.Double test5 = new Rectangle2D.Double(86.0, 40.0, 15.0, 15.0);
		Rectangle2D test6 = test4.createIntersection(test5);
		graphicsObj2D.draw(test4);
		graphicsObj2D.draw(test5);
		graphicsObj2D.fill(test6);
		
		//Create a new rectangle based on the union that (contains) both rectangles.
		Rectangle2D.Double test7 = new Rectangle2D.Double(150.0, 35.0, 30.0, 30.0);
		Rectangle2D.Double test8 = new Rectangle2D.Double(165.0, 40.0, 40.0, 40.0);
		Rectangle2D test9 = test7.createUnion(test8);
		graphicsObj2D.draw(test7);
		graphicsObj2D.draw(test8);
		graphicsObj2D.draw(test9);
		
	}
}

public class RectangleClass {
	
	public static void main(String[] args){
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(200, 70, 500, 500);
		window.setTitle("Rectangle Class Program");
		Color backgroundColor = new Color(250,250,250);
		window.getContentPane().setBackground(backgroundColor);
		drawComponent drawComp = new drawComponent();
		window.add(drawComp);
		window.setVisible(true);
		
	}
	
}