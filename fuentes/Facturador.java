public class Facturador{

	//Repertorio de conciertos del grupo
	static String[][] repertorio = {
		 {"Tributo Robe", "heavy"}
		,{"Homaneje Queen", "rock"}
		,{"Magia Knoppler", "rock"}
		,{"Demonios Rojos", "heavy"}
	};

	//Actuaciones realizadas indicando el concierto ofrecido y audiencias obtenidas.
	static Integer[][] actuaciones = {{0, 2000}, {2, 1200}, {0, 950}, {3, 1140}, {1, 2140}};

	static String cliente = "Ayuntamiento de Badajoz";

	public static void main(String[] args) throws Exception{
		Double totalFactura = 0d;
		Integer creditos = 0;

		System.out.println("FACTURA DE ACTUACIONES");
		System.out.println("Cliente: " + cliente);

		for(int i = 0; i < actuaciones.length; i++){
			Integer iConcierto = actuaciones[i][0];
			totalFactura += calcularImporteActuacion(repertorio[iConcierto][1],actuaciones[i][1]);

			creditos += Math.max(actuaciones[i][1] - 500, 0);
			if (repertorio[iConcierto][1].equals("heavy"))
				creditos += actuaciones[i][1] / 5;

			System.out.println("\tConcierto: " + repertorio[iConcierto][0]);
			System.out.println("\t\tAsistentes: " + actuaciones[i][1]);
		}
		System.out.println("BASE IMPONIBLE: " + totalFactura + " euros");
		System.out.printf("IVA (21%%): %.2f euros\n", totalFactura * 0.21);
		System.out.printf("TOTAL FACTURA: %.2f euros\n", totalFactura * 1.21);
		System.out.println("Créditos obtenidos: " + creditos);

	}
	public static Double calcularImporteActuacion(String tipo,Integer Asistentes)throws Exception{
		Double importeActuacion;
		if(tipo=="heavy"){
			importeActuacion = 400d;
			if (Asistentes > 500)
				importeActuacion += 20 * (Asistentes - 500);
		}else if(tipo=="rock"){
			importeActuacion = 3000d;
				if (Asistentes > 1000)
					importeActuacion += 30 * (Asistentes - 1000);
		}else{
			throw new Exception("Tipo de concierto desconocido.");
		}
		return importeActuacion;
	}
}
