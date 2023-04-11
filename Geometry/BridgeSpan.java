
/*

25.-  Make a bar chart to plot the following data set. Label each bar. Make the bars horizontal for easier labeling. Provide a class BarChartViewer and a class BarChartComponent.

	Bridge Name Longest Span (ft)
	Golden Gate       4,200
	Brooklyn          1,595
	Delaware Memorial 2,150
	Mackinac          3,800

*/


import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class drawComponentChart extends JComponent {
	public void paintComponent(Graphics graphicsObj) {

		Graphics2D graphicsObj2D = (Graphics2D) graphicsObj;
		
		//Draw Title
		graphicsObj2D.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
		graphicsObj2D.drawString("Bridges Span", 350, 35);
		
		//Draw Bridge Names
		graphicsObj2D.setFont(new Font("TimesRoman", Font.PLAIN, 17)); 
		graphicsObj2D.drawString("Golden Gate", 140, 120); 
		graphicsObj2D.drawString("Brooklyn", 160, 180); 
		graphicsObj2D.drawString("Delaware Memorial", 90, 240); 
		graphicsObj2D.drawString("Mackinac", 160, 300);
		
		//Draw line numbers and division lines
		graphicsObj2D.setFont(new Font("TimesRoman", Font.PLAIN, 9));
		graphicsObj2D.drawString("0", 253 , 378 ); 
		graphicsObj2D.drawString("1000", 323, 378); 
		graphicsObj2D.drawString("2000", 393, 378); 
		graphicsObj2D.drawString("3000", 463, 378); 
		graphicsObj2D.drawString("4000", 533, 378); 
		graphicsObj2D.drawString("5000", 603, 378);
		graphicsObj2D.draw(new Line2D.Double(334, 356, 334, 362));
		graphicsObj2D.draw(new Line2D.Double(402, 356, 402, 362));
		graphicsObj2D.draw(new Line2D.Double(471, 356, 471, 362));
		graphicsObj2D.draw(new Line2D.Double(542, 356, 542, 362));
		graphicsObj2D.draw(new Line2D.Double(610, 356, 610, 362));
		
		//Draw line message
		graphicsObj2D.setPaint(Color.BLACK);
		graphicsObj2D.setFont(new Font("TimesRoman", Font.PLAIN, 13)); 
		graphicsObj2D.drawString("Span in ft", 687, 363);
		
		//Draw Axis
		Line2D EjeY = new Line2D.Double(255, 80, 255, 360);
		graphicsObj2D.draw(EjeY);
		Line2D EjeX = new Line2D.Double(215, 360, 660, 360);
		graphicsObj2D.draw(EjeX);
		
		//Draw blue rectangles
		Rectangle2D GoldenGate = new Rectangle2D.Double(255, 100, 303, 25);
		Rectangle2D Brooklyn = new Rectangle2D.Double(255, 160, 122, 25);
		Rectangle2D DelawareMemorial = new Rectangle2D.Double(255, 220, 159, 25);
		Rectangle2D Mackinac = new Rectangle2D.Double(255, 280, 275, 25);
		graphicsObj2D.setColor(Color.BLACK);
		Color LightBlue = new Color(51,153,255);
		graphicsObj2D.setPaint(LightBlue);
		graphicsObj2D.fill(GoldenGate);
		graphicsObj2D.fill(Brooklyn);
		graphicsObj2D.fill(DelawareMemorial);
		graphicsObj2D.fill(Mackinac);
		graphicsObj2D.setColor(Color.BLACK);
		graphicsObj2D.draw(GoldenGate);
		graphicsObj2D.draw(Brooklyn);
		graphicsObj2D.draw(DelawareMemorial);
		graphicsObj2D.draw(Mackinac);
		
		//Draw markers red point
		graphicsObj2D.setPaint(Color.RED);
		Ellipse2D MarcadorUno = new Ellipse2D.Double(375, 358, 5, 5);
		graphicsObj2D.fill(MarcadorUno);
		Ellipse2D MarcadorDos = new Ellipse2D.Double(412, 358, 5, 5);
		graphicsObj2D.fill(MarcadorDos);
		Ellipse2D MarcadorTres = new Ellipse2D.Double(528, 358, 5, 5);
		graphicsObj2D.fill(MarcadorTres);
		Ellipse2D MarcadorCuatro = new Ellipse2D.Double(556, 358, 5, 5);
		graphicsObj2D.fill(MarcadorCuatro);
		
		//Draw makers pointed line
		graphicsObj2D.setColor(Color.GRAY);
		float dash[] = { 1.0f };
	    graphicsObj2D.setStroke(new BasicStroke(0.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, dash, 0.0f));
		graphicsObj2D.draw(new Line2D.Double(559, 359, 559, 397));
		graphicsObj2D.draw(new Line2D.Double(378, 359, 378, 397));
		graphicsObj2D.draw(new Line2D.Double(415, 359, 415, 397));
		graphicsObj2D.draw(new Line2D.Double(531, 359, 531, 397));
		
		//Draw markers information
		graphicsObj2D.setFont(new Font("TimesRoman", Font.PLAIN, 9)); 
		graphicsObj2D.setColor(Color.BLACK);
		graphicsObj2D.drawString("1595", 368, 410); 
		graphicsObj2D.drawString("2150", 405, 410); 
		graphicsObj2D.drawString("3800", 521, 410); 
		graphicsObj2D.drawString("4200", 549, 410);
		
	}
}

public class BridgeSpan {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 900, 500);
		window.setTitle("Bridge Span Chart");
		Color backgroundColor = new Color(255,255,255);
		window.getContentPane().setBackground(backgroundColor);
		drawComponentChart drawCompChart = new drawComponentChart();
		window.add(drawCompChart);
		window.setVisible(true);		
		
	}

}