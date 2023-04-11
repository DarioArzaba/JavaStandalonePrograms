package contaduria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Asiento {
	private String fecha;
	private String mensaje;
	public ArrayList<Boolean> Tipo = new ArrayList<Boolean>();
	
	private Map<String, Double> Debe = new HashMap<String, Double>();
	private Map<String, Double> Haber = new HashMap<String, Double>();
	
	public void setFecha (String nuevaFecha) {
		this.fecha = nuevaFecha;
	}
	public String getFecha () {
		return this.fecha;
	}
	public void setMensaje (String nuevoMensaje) {
		this.mensaje = nuevoMensaje;
	}
	public String getMensaje () {
		return this.mensaje;
	}
	public void setTipoDebe (boolean nuevoTipo) {
		this.Tipo.add(nuevoTipo);
	}
	
	public void setDebe (String cuenta, double importe) {
		this.Debe.put(cuenta, importe);
	}
	
	public void setHaber (String cuenta, double importe) {
		this.Haber.put(cuenta, importe);
	}
	
	public void imprimir() {

		System.out.println("\n-----------------------------");
		System.out.println("           DEBE              ");
		System.out.println("-----------------------------");
		
		for (Map.Entry<String, Double> entry : Debe.entrySet()) {
		    System.out.println(entry.getKey() + "     |      " + entry.getValue());
		}
		
		System.out.println("\n-----------------------------");
		System.out.println("           HABER              ");
		System.out.println("-----------------------------");
		
		for (Map.Entry<String, Double> entry : Haber.entrySet()) {
		    System.out.println(entry.getKey() + "     |      " + entry.getValue());
		}
		
		System.out.println("\n\n***********************   TERMINA ASIENTO   **************************\n\n");
		
	}
	
}
