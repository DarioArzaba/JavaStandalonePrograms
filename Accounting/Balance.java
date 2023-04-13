
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Balance {

	private Map<String, Cuenta> Mapa = new HashMap<String, Cuenta>();
	private Map<String, Asiento> Asientos = new HashMap<String, Asiento>();
	private ArrayList<Double> Activos = new ArrayList<Double>();
	private ArrayList<Double> Pasivos = new ArrayList<Double>();
	private double activosTotales = 0.0;
	private double pasivosTotales = 0.0;
	private double balanceFinal = 0.0;
	private String nombre;
	
	private String fechaAsientoActual;
	
	public Balance (String nom) {
		this.nombre = nom;
	}
	
	public void comentario (String mensaje, String fecha) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.fechaAsientoActual = fecha;
		Class<?> nuevaClase = Class.forName("Asiento");
		Asiento nuevoAsiento = (Asiento)nuevaClase.newInstance();
		nuevoAsiento.setMensaje(mensaje);
		nuevoAsiento.setFecha(fecha);
		Asientos.put(fecha, nuevoAsiento);
	}
	
	public void imprimirAsiento(String fecha) {
		
		Asiento asientoImprimir = Asientos.get(fecha);
		System.out.println("\n\n***********************   INICIA ASIENTO   **************************\n\n");
		System.out.println(asientoImprimir.getMensaje() +   "   del   " + asientoImprimir.getFecha() );
		asientoImprimir.imprimir();
			
	}
	
	public void asientoContableDebe(String nombreCuenta, double importe) {
		Cuenta cuentaDebe = Mapa.get(nombreCuenta);
		cuentaDebe.setDebe(importe);
		Asiento AsientoDebe = Asientos.get(fechaAsientoActual);
		AsientoDebe.setDebe(nombreCuenta, importe);
		AsientoDebe.setTipoDebe(true);
	}
	
	public void asientoContableHaber(String nombreCuenta, double importe) {
		Cuenta cuentaHaber = Mapa.get(nombreCuenta);
		cuentaHaber.setHaber(importe);
		Asiento AsientoHaber = Asientos.get(fechaAsientoActual);
		AsientoHaber.setHaber(nombreCuenta, importe);
		AsientoHaber.setTipoDebe(false);
	}
	
	public void resetBalance () {
		Activos.clear();
		Pasivos.clear();
		Mapa.clear();
		activosTotales = 0.0;
		pasivosTotales = 0.0;
		balanceFinal = 0.0;
	}
	
	public void crearCuenta(String nombreCuenta, String tipoCuenta) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String nuevaCuentaNombre = nombreCuenta;
		Class<?> nuevaClase = Class.forName("Cuenta");
		Cuenta nuevaCuenta = (Cuenta)nuevaClase.newInstance();
		if (tipoCuenta.equals("De Activo")) {
			nuevaCuenta.setActivo(true);
		} else {
			nuevaCuenta.setActivo(false);
		}
		nuevaCuenta.setNombre(nombreCuenta);
		Mapa.put(nuevaCuentaNombre, nuevaCuenta);
	}
		
	public void imprimirCuenta(String nombreCuenta) {
		Cuenta cuentaImprimir = Mapa.get(nombreCuenta);
		System.out.println("\n\n***********************   INICIA CUENTA   **************************\n\n");
		cuentaImprimir.imprimir();
		System.out.println("\n\n***********************   TERMINA CUENTA   **************************\n\n");
	}
	
	public void imprimirCuentas() {
		System.out.println("\n\n***********************   INICIA CUENTAS   **************************\n\n");
		for (Cuenta cuentaActual : Mapa.values()) {
		    cuentaActual.imprimir();
		}
		System.out.println("\n\n***********************   TERMINA CUENTAS  **************************\n\n");
	}
	
	public void imprimirBalance() {
		
		System.out.println("\n\n***********************   INICIA BALANCE   **************************\n\n");
		System.out.println("\n            Balance de :  " + this.nombre +   "      ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("           ACTIVOS          |         PASIVOS              ");
		System.out.println("-----------------------------------------------------------");
		
		for (Map.Entry<String, Cuenta> entry : Mapa.entrySet()) {
			if (entry.getValue().getActivo()) {
				Activos.add(entry.getValue().getSaldo());
			} else {
				Pasivos.add(entry.getValue().getSaldo());
			}
		}
	
		int numeroActivos = 0;
		int numeroPasivos = 0;
		
		for (Double activoActual : Activos) {
			this.activosTotales += activoActual;
			numeroActivos++;
		}
		
		for (Double pasivoActual : Pasivos) {
			this.pasivosTotales += pasivoActual;
			numeroPasivos++;
		}
		
		boolean terminarLista = false;
		int numeroPasivosContados = 0;
		int numeroActivosContados = 0;
		
		
		if (numeroActivos >= numeroPasivos) {
			for (double activoActual : Activos) {
				if (numeroPasivosContados == numeroPasivos) {
					terminarLista = true;
				}
				if (terminarLista == false) {
					System.out.println("\n         " + activoActual + "          |          " + this.Pasivos.get(numeroPasivosContados) );
					numeroPasivosContados++;
				} else {
					System.out.println("\n           " + activoActual + "          |                           " );
				}
			}
		} else {
			for (double pasivoActual : Pasivos) {
				if (numeroActivosContados == numeroActivos) {
					terminarLista = true;
				}
				if (terminarLista == false) {
					System.out.println("\n         " + this.Activos.get(numeroActivosContados) + "          |          " + pasivoActual );
					numeroActivosContados++;
				} else {
					System.out.println("\n                            |          " + pasivoActual );
				}
			}
		}
		
		this.balanceFinal = activosTotales - pasivosTotales;
		
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("     ACTIVOS TOTALES        |       PASIVOS TOTALES    ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("\n            " + this.activosTotales + "          |           " + this.pasivosTotales );
		System.out.println("\n            Balance : " + ((this.activosTotales) + " - " + (this.pasivosTotales)) + " = " + this.balanceFinal );
		System.out.println("\n\n***********************   TERMINA BALANCE   **************************\n\n");
		
	}
	
}












