
import java.util.ArrayList;

public class Cuenta {
	
	private ArrayList<Double> DebeLista = new ArrayList<Double>();
	private ArrayList<Double> HaberLista = new ArrayList<Double>();
	
	private int numeroDebe = 0;
	private int numeroHaber = 0;
	private double debeTotal = 0.0;
	private double haberTotal = 0.0;
	private double saldoTotal = 0.0;
	private boolean tipoSaldoDebe = true;
	private boolean deActivo = true;
	private String nombre;
	
	public void setActivo( boolean set) {
		this.deActivo = set;
	}
	
	public void setNombre (String nom) {
		this.nombre = nom;
	}
	
	public void setDebe (double quantity) {
		DebeLista.add(quantity);
		numeroDebe++;
	}
	
	public void setHaber (double quantity) {
		HaberLista.add(quantity);
		numeroHaber++;
	}
	
	public void resetValues() {
		debeTotal = 0.0;
		haberTotal = 0.0;
		saldoTotal = 0.0;
		tipoSaldoDebe = true;
	}
	
	public boolean getActivo () {
		return deActivo;
	}
	
	public double getSaldo() {
		for (double debeActual : DebeLista) { this.debeTotal += debeActual; }
		for (double haberActual : HaberLista) { this.haberTotal += haberActual; }
		if (this.debeTotal >= this.haberTotal) {
			this.saldoTotal = (this.debeTotal)-(this.haberTotal);
		} else {
			this.saldoTotal = (this.haberTotal)-(this.debeTotal);
		}		
		double saldo = this.saldoTotal;
		this.resetValues();
		return saldo;
	}
	
	public void imprimir() {

		System.out.println("Cuenta : " + this.nombre +   "      ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("           DEBE            |            HABER              ");
		System.out.println("-----------------------------------------------------------");
		
		for (double debeActual : DebeLista) { this.debeTotal += debeActual; }
		for (double haberActual : HaberLista) { this.haberTotal += haberActual; }
		
		boolean terminarLista = false;
		int numeroDebeContados = 0;
		int numeroHaberContados = 0;
		
		if (numeroDebe >= numeroHaber) {
			for (double debeActual : DebeLista) {
				if (numeroHaberContados == numeroHaber) {
					terminarLista = true;
				}
				if (terminarLista == false) {
					System.out.println("\n         " + debeActual + "          |          " + this.HaberLista.get(numeroHaberContados) );
					numeroHaberContados++;
				} else {
					System.out.println("\n         " + debeActual + "          |                              " );
				}
			}
		} else {
			for (double haberActual : HaberLista) {
				if (numeroDebeContados == numeroDebe) {
					terminarLista = true;
				}
				if (terminarLista == false) {
					System.out.println("\n         " + this.DebeLista.get(numeroDebeContados) + "          |          " + haberActual );
					numeroDebeContados++;
				} else {
					System.out.println("\n                           |          " + haberActual );
				}
			}
		}
				
		System.out.println("-----------------------------------------------------------");
		
		if (deActivo == true) {
			System.out.println("     CARGOS (Aumento)      |    ABONOS (Disminuye)   ");
		} else {
			System.out.println("     CARGOS (Disminuye)    |    ABONOS (Aumenta)     ");
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("\n         " + this.debeTotal + "          |          " + this.haberTotal );
		
		if (this.debeTotal >= this.haberTotal) {
			this.saldoTotal = (this.debeTotal)-(this.haberTotal);
			this.tipoSaldoDebe = true;
		} else {
			this.saldoTotal = (this.haberTotal)-(this.debeTotal);
			this.tipoSaldoDebe = false;
		}
		
		if (this.tipoSaldoDebe == true) {
			System.out.println("\nSaldo Total Debe  :    (" + ((this.debeTotal) + ") - (" + (this.haberTotal)) + ") = " + this.saldoTotal + "\n\n" );
		} else {
			System.out.println("\nSaldo Total Haber  :    (" + ((this.haberTotal) + ") - (" + (this.debeTotal)) + ") = " + this.saldoTotal + "\n\n");
		}
		
		this.resetValues();
		
	}
	
}
