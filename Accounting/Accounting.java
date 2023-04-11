package contaduria;

public class Accounting {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Balance empresaDario = new Balance("Empresa D y M Inc.");
		
		empresaDario.comentario("Creacion de empresa", "14 Febrero 2018");
		empresaDario.crearCuenta("Efectivo", "De Activo");
		empresaDario.asientoContableDebe("Efectivo", 10000);
		empresaDario.crearCuenta("Capital", "De Pasivo");
		empresaDario.asientoContableHaber("Capital", 10000);
		
		empresaDario.comentario("Compra maquina a contado", "16 Febrero 2018");
		empresaDario.crearCuenta("Maquina", "De Activo");
		empresaDario.asientoContableDebe("Maquina", 3000);
		empresaDario.asientoContableHaber("Efectivo", 3000);
		
		empresaDario.comentario("Compra camion a deber", "19 Febrero 2018");
		empresaDario.crearCuenta("Camion", "De Activo");
		empresaDario.asientoContableDebe("Camion", 1000);
		empresaDario.crearCuenta("Deudas", "De Pasivo");
		empresaDario.asientoContableHaber("Deudas", 1000);
		
		empresaDario.comentario("Compra de mercancia", "23 Febrero 2018");
		empresaDario.crearCuenta("Mercancia", "De Activo");
		empresaDario.asientoContableDebe("Mercancia", 5000);
		empresaDario.asientoContableHaber("Efectivo", 2500);
		empresaDario.asientoContableHaber("Deudas", 2500);
		
		empresaDario.comentario("Venta de Mercancia ", "29 Febrero 2018");
		empresaDario.asientoContableDebe("Efectivo", 2000);
		empresaDario.asientoContableHaber("Mercancia", 2000);
		
		empresaDario.imprimirAsiento("23 Febrero 2018");
		empresaDario.imprimirCuenta("Capital");
		empresaDario.imprimirCuentas();
		
		empresaDario.imprimirBalance();

		empresaDario.resetBalance();
		
		System.exit(0);
	
	}
	
}



