
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class House {
	
	private int xLeft;
	private int yTop;
	private int width;
	
	public House(int x, int y, int aWidth) {
		xLeft = x;
		yTop = y;
		width = aWidth;
	}
	
	public void draw(Graphics2D graphicsObj2D) {

		double unit = width/24;
				
		Line2D TechoIzquierda = new Line2D.Double(xLeft, yTop+(14*unit), xLeft+(4*unit) , yTop+(6*unit));
		Line2D TechoDerecha = new Line2D.Double(xLeft+(4*unit), yTop+(6*unit), xLeft+(11*unit) , yTop+(11*unit));
		Line2D FachadaIzquierda = new Line2D.Double(xLeft+(0*unit), yTop+(14*unit), xLeft+(2*unit) , yTop+(24*unit));
		Line2D FachadaAbajo = new Line2D.Double(xLeft+(2*unit), yTop+(24*unit), xLeft+(13*unit) , yTop+(22*unit));
		Line2D FachadaDerecha = new Line2D.Double(xLeft+(13*unit), yTop+(22*unit), xLeft+(11*unit) , yTop+(11*unit));
		Line2D FachadaArriba  = new Line2D.Double(xLeft+(0*unit), yTop+(14*unit), xLeft+(11*unit) , yTop+(11*unit));
		Line2D PuertaIzquierda = new Line2D.Double(xLeft+(6*unit), yTop+(23*unit), xLeft+(4*unit) , yTop+(18*unit));
		Line2D PueraArriba = new Line2D.Double(xLeft+(4*unit), yTop+(18*unit), xLeft+(9*unit) , yTop+(17*unit));
		Line2D PuertaDerecha = new Line2D.Double(xLeft+(9*unit), yTop+(17*unit), xLeft+(9.5*unit) , yTop+(22.5*unit));
		Line2D TejasArriba = new Line2D.Double(xLeft+(4*unit), yTop+(6*unit), xLeft+(18*unit) , yTop+(3*unit));
		Line2D TejasDerecha = new Line2D.Double(xLeft+(18*unit), yTop+(3*unit), xLeft+(23*unit) , yTop+(9*unit));
		Line2D TejasAbajo = new Line2D.Double(xLeft+(11*unit), yTop+(11*unit), xLeft+(23*unit) , yTop+(9*unit));
		Line2D ParedDerecha = new Line2D.Double(xLeft+(23*unit), yTop+(9*unit), xLeft+(25*unit) , yTop+(18*unit));
		Line2D ParedAbajo = new Line2D.Double(xLeft+(25*unit), yTop+(18*unit), xLeft+(13*unit) , yTop+(22*unit));
		Line2D VentanaIzquierda = new Line2D.Double(xLeft+(15*unit), yTop+(13*unit), xLeft+(16*unit) , yTop+(15*unit));
		Line2D VentanaAbajo = new Line2D.Double(xLeft+(16*unit), yTop+(15*unit), xLeft+(22*unit) , yTop+(14*unit));
		Line2D VentanaDerecha = new Line2D.Double(xLeft+(22*unit), yTop+(14*unit), xLeft+(21*unit) , yTop+(12*unit));
		Line2D VentanaArriba  = new Line2D.Double(xLeft+(21*unit), yTop+(12*unit), xLeft+(15*unit) , yTop+(13*unit));
		Ellipse2D Ventana = new Ellipse2D.Double(xLeft+(4*unit), yTop+(9*unit), 2*unit , 2*unit);
		
		graphicsObj2D.setColor(Color.BLACK);
		graphicsObj2D.draw(TechoIzquierda);
		graphicsObj2D.draw(TechoDerecha);
		graphicsObj2D.draw(FachadaIzquierda);
		graphicsObj2D.draw(FachadaAbajo);
		graphicsObj2D.draw(FachadaArriba);
		graphicsObj2D.draw(FachadaDerecha);
		graphicsObj2D.draw(PuertaIzquierda);
		graphicsObj2D.draw(PueraArriba);
		graphicsObj2D.draw(PuertaDerecha);
		graphicsObj2D.draw(TejasArriba);
		graphicsObj2D.draw(TejasDerecha);
		graphicsObj2D.draw(TejasAbajo);
		graphicsObj2D.draw(ParedDerecha);
		graphicsObj2D.draw(ParedAbajo);
		graphicsObj2D.draw(VentanaIzquierda);
		graphicsObj2D.draw(VentanaAbajo);
		graphicsObj2D.draw(VentanaDerecha);
		graphicsObj2D.draw(VentanaArriba);
		graphicsObj2D.draw(Ventana);		
		
	}
	
}

class drawComponentHouseOne extends JComponent {
	public void paintComponent(Graphics graphicsObj) {

		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;		
		House mainHouse = new House(80, 80, 200);
		mainHouse.draw(graphicsObj2D);

	}
}

public class HouseDrawerOne {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 800, 500);
		window.setTitle("Window House");
		Color backgroundColor = new Color(255,255,255);
		window.getContentPane().setBackground(backgroundColor);
		drawComponentHouseOne drawComp = new drawComponentHouseOne();
		window.add(drawComp);
		window.setVisible(true);		
		
	}

}
