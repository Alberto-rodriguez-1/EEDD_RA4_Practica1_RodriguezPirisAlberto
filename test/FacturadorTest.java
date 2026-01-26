import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
public class FacturadorTest {
		@Test
		public void testConstructor(){
			Facturador facturador=new Facturador();
			assertNotEquals(null, facturador);
		}
		@Test
		public void testCabeceraCorrecta(){
			PrintStream consola = System.out;
			ByteArrayOutputStream  baos= new  ByteArrayOutputStream ();
			PrintStream salidaTest= new PrintStream(baos);
			System.setOut(salidaTest);
			try{
			Facturador.main(null);
			}catch(Exception e){
				fail("Excepcion inesperada.");
			}
			String salida =baos.toString();
			assertTrue(salida.contains("FACTURA DE ACTUACIONES"),"La salida no contiene la cabecera esperada");
			System.setOut(consola);
		}
		@Test
		public void testClienteCorrecta(){
			PrintStream consola = System.out;
			ByteArrayOutputStream  baos= new  ByteArrayOutputStream ();
			PrintStream salidaTest= new PrintStream(baos);
			System.setOut(salidaTest);
			try{
			Facturador.main(null);
			}catch(Exception e){
				fail("Excepcion inesperada.");
			}
			String salida =baos.toString();
			assertTrue(salida.contains("Cliente: Ayuntamiento de Badajoz"),"La salida no contiene la cabecera esperada");
			System.setOut(consola);
		}
		@Test
		public void testBaseImponibleCorrecta(){
			PrintStream consola = System.out;
			ByteArrayOutputStream  baos= new  ByteArrayOutputStream ();
			PrintStream salidaTest= new PrintStream(baos);
			System.setOut(salidaTest);
			try{
			Facturador.main(null);
			}catch(Exception e){
				fail("Excepcion inesperada.");
			}
			String salida =baos.toString();
			assertTrue(salida.contains("BASE IMPONIBLE: 99200.0 euros"),"La salida no contiene la cabecera esperada");
			System.setOut(consola);
		}
		@Test
		public void testIVACorrecto(){
			PrintStream consola = System.out;
			ByteArrayOutputStream  baos= new  ByteArrayOutputStream ();
			PrintStream salidaTest= new PrintStream(baos);
			System.setOut(salidaTest);
			try{
			Facturador.main(null);
			}catch(Exception e){
				fail("Excepcion inesperada.");
			}
			String salida =baos.toString();
			assertTrue(salida.contains("IVA (21%): 20832,00 euros"),"La salida no contiene la cabecera esperada");
			System.setOut(consola);
		}
		@Test
		public void testTotalCorrecto(){
			PrintStream consola = System.out;
			ByteArrayOutputStream  baos= new  ByteArrayOutputStream ();
			PrintStream salidaTest= new PrintStream(baos);
			System.setOut(salidaTest);
			try{
			Facturador.main(null);
			}catch(Exception e){
				fail("Excepcion inesperada.");
			}
			String salida =baos.toString();
			assertTrue(salida.contains("TOTAL FACTURA: 120032,00 euros"),"La salida no contiene la cabecera esperada");
			System.setOut(consola);
		}
		@Test
		public void testCreditosCorrecto(){
			PrintStream consola = System.out;
			ByteArrayOutputStream  baos= new  ByteArrayOutputStream ();
			PrintStream salidaTest= new PrintStream(baos);
			System.setOut(salidaTest);
			try{
			Facturador.main(null);
			}catch(Exception e){
				fail("Excepcion inesperada.");
			}
			String salida =baos.toString();
			assertTrue(salida.contains("Créditos obtenidos: 5748"),"La salida no contiene la cabecera esperada");
			System.setOut(consola);
		}
		
}