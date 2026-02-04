import java.util.ArrayList;
import java.util.List;
public class Facturador{
	private enum TIPO_CONCIERTO{rock,heavy};
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
	static Integer[][] DatosActuacionesRealizadas = {{0, 2000}, {2, 1200}, {0, 950}, {3, 1140}, {1, 2140}};
	static String cliente = "Ayuntamiento de Badajoz";

	public static void main(String[] args) throws Exception{
		Double totalFactura = 0d;
		Integer creditos = 0;
		List<Actuacion> listaActuaciones = crearListaActuaciones(DatosActuacionesRealizadas);
		System.out.println("FACTURA DE ACTUACIONES");
		System.out.println("Cliente: " + cliente);

		for(Actuacion actuacion:listaActuaciones){
			String tipoConcierto=conciertosDisponibles[actuacion.tipoConcierto()][1];
			Integer asistentes=actuacion.numeroAsistentes();
			totalFactura += calcularImporteActuacion(tipoConcierto,asistentes);
			creditos+=calcularCreditos(tipoConcierto,asistentes);
			System.out.println("\tConcierto: " + conciertosDisponibles[actuacion.tipoConcierto()][0]);
			System.out.println("\t\tAsistentes: " + actuacion.numeroAsistentes());
		}
		System.out.println("BASE IMPONIBLE: " + totalFactura + " euros");
		System.out.printf("IVA (21%%): %.2f euros\n", totalFactura * IVA);
		System.out.printf("TOTAL FACTURA: %.2f euros\n", totalFactura * (1+IVA));
		System.out.println("Créditos obtenidos: " + creditos);
	}
	public static Double calcularImporteActuacion(String tipo,Integer asistentes)throws Exception{
		Double importeActuacion;
		tipo.toLowerCase().replace(" ","");
		TIPO_CONCIERTO tipoCambiado=TIPO_CONCIERTO.valueOf(tipo);
		if(tipoCambiado==TIPO_CONCIERTO.heavy){
			importeActuacion = BASE_HEAVY;
			if (asistentes > MIN_ASISTENTES_HEAVY)
				importeActuacion += 20 * (asistentes - MIN_ASISTENTES_HEAVY);
		}else if(tipoCambiado==TIPO_CONCIERTO.rock){
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
	public static List crearListaActuaciones(Integer[][] array){
		List<Actuacion> resultado=new ArrayList<>();
		for(Integer[] datoActuacion: array){
			Integer tipoConcierto=datoActuacion[0];
			Integer asistentes=datoActuacion[1];
			resultado.add(new Actuacion(tipoConcierto,asistentes));
		}
		return resultado;
	}
}
record Actuacion(Integer tipoConcierto,Integer numeroAsistentes){}
