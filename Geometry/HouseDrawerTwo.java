
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

class HouseTwo {
	
	private int xLeft;
	private int yTop;
	private int width;
	
	public HouseTwo(int x, int y, int aWidth) {
		xLeft = x;
		yTop = y;
		width = aWidth;
	}
	
	public int getXLeft() {
		return this.xLeft; 
	}
	
	public int getYTop() {
		return this.yTop; 
	}
	
	public int getWidth() {
		return this.width; 
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

class drawComponentHouseDrawTwo extends JComponent {
	public void paintComponent(Graphics graphicsObj) {

		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
		
		ArrayList<Integer> listOne = new ArrayList<Integer>(20);
		ArrayList<Integer> listTwo = new ArrayList<Integer>(20);
		ArrayList<Integer> size = new ArrayList<Integer>(20);
		
	    Random random = new Random();
	    for (int i = 0; i < 20; i++) {
	    	int tempX = random.nextInt((750 - 0) + 1) + 0;
	        listOne.add(i, tempX);
	        int tempY = random.nextInt((500 - 0) + 1) + 0;
	        listTwo.add(i, tempY);
	        int tempSize = random.nextInt((250 - 24) + 1) + 24;
	        /* while ((tempSize + tempX) > 800 || (tempSize + tempY) > 500) {
	        	tempSize = tempSize/2;
	        }*/
	        size.add(i, tempSize);
	    }
		
	    ArrayList<HouseTwo> HouseList = new ArrayList<HouseTwo>(20);
	   
	    for (int i = 0; i < 20; i++) {
	    	HouseList.add(i, (new HouseTwo(listOne.get(i),listTwo.get(i),size.get(i))));
	    }
	   
	    for (int i = 0; i < 20; i++) {
	    	HouseList.get(i).draw(graphicsObj2D);
	    }

	}
}

public class HouseDrawerTwo {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 800, 500);
		window.setTitle("Window House Two");
		Color backgroundColor = new Color(255,255,255);
		window.getContentPane().setBackground(backgroundColor);
		drawComponentHouseDrawTwo drawComp = new drawComponentHouseDrawTwo();
		window.add(drawComp);
		window.setVisible(true);		
		
	}

}
