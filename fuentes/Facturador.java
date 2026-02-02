public class Facturador{
	private static final Double BASE_HEAVY=400d;
	private static final Double BASE_ROCK=3000d;
	private static final Integer MIN_ASISTENTES_HEAVY=500;
	private static final Integer MIN_ASISTENTES_ROCK=1000;
	private static final float IVA = 0.21f;
	//Repertorio de conciertos del grupo	
	static String[][] conciertosDisponibles = {
		 {"Tributo Robe", "heavy"}
		,{"Homaneje Queen", "rock"}
		,{"Magia Knoppler", "rock"}
		,{"Demonios Rojos", "heavy"}
	};

	//Actuaciones realizadas indicando el concierto ofrecido y audiencias obtenidas.
	static Integer[][] actuacionesRealizadas = {{0, 2000}, {2, 1200}, {0, 950}, {3, 1140}, {1, 2140}};

	static String cliente = "Ayuntamiento de Badajoz";

	public static void main(String[] args) throws Exception{
		Double totalFactura = 0d;
		Integer creditos = 0;

		System.out.println("FACTURA DE ACTUACIONES");
		System.out.println("Cliente: " + cliente);

		for(int i = 0; i < actuacionesRealizadas.length; i++){
			Integer indiceConcierto = actuacionesRealizadas[i][0];
			String tipoConcierto=conciertosDisponibles[indiceConcierto][1];
			Integer asistentes=actuacionesRealizadas[i][1];
			totalFactura += calcularImporteActuacion(tipoConcierto,asistentes);
			creditos+=calcularCreditos(tipoConcierto,asistentes);
			System.out.println("\tConcierto: " + conciertosDisponibles[indiceConcierto][0]);
			System.out.println("\t\tAsistentes: " + actuacionesRealizadas[i][1]);
		}
		System.out.println("BASE IMPONIBLE: " + totalFactura + " euros");
		System.out.printf("IVA (21%%): %.2f euros\n", totalFactura * IVA);
		System.out.printf("TOTAL FACTURA: %.2f euros\n", totalFactura * (1+IVA));
		System.out.println("Créditos obtenidos: " + creditos);

	}
	public static Double calcularImporteActuacion(String tipo,Integer asistentes)throws Exception{
		Double importeActuacion;
		if(tipo=="heavy"){
			importeActuacion = BASE_HEAVY;
			if (asistentes > MIN_ASISTENTES_HEAVY)
				importeActuacion += 20 * (asistentes - MIN_ASISTENTES_HEAVY);
		}else if(tipo=="rock"){
			importeActuacion = BASE_ROCK;
				if (asistentes > MIN_ASISTENTES_ROCK)
					importeActuacion += 30 * (asistentes - MIN_ASISTENTES_ROCK);
		}else{
			throw new Exception("Tipo de concierto desconocido.");
		}
		return importeActuacion;
	}
	public static Integer calcularCreditos(String tipo,Integer asistentes){
		Integer creditos= Math.max(asistentes - MIN_ASISTENTES_HEAVY, 0);
		if (tipo.equals("heavy"))
			creditos += asistentes / 5;
		return creditos;
	}
}
