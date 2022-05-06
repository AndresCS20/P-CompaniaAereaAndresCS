package compania;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
public class Principal {

	public static Scanner scString=new Scanner(System.in);
	
	public static void main(String[] args) {
		LocalDateTime fecha=LocalDateTime.now();
		ArrayList <Vuelo> historialVuelos=new ArrayList();
		DateTimeFormatter formatoFechaSolo=DateTimeFormatter.ofPattern("dd-MM-YYYY");
		DateTimeFormatter formatoFechaHora=DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
		int opcion=0;
		LocalDateTime fechaNueva=fecha.plusHours(5);
		System.out.println(fechaNueva);
		Vuelo vuelo1=new Vuelo("Madrid", "Sevilla", fechaNueva);
		historialVuelos.add(vuelo1);
		while (true) {
		do {
			
			System.out.println(fecha.format(formatoFechaSolo));
			System.out.println("1.- Listado de vuelos totales");
			System.out.println("2.- Pasar día siguiente y ver vuelos");
			System.out.println("3.- Finalizar programa");
			System.out.println("Introduce un numero (1 o 2) para elegir una opción del menu");
			
			
			
			opcion=introducirNumeroEntero(opcion);
	
			
			switch (opcion) {
			case 1:
				System.out.println("[1] Listado de Vuelos Totales");
				for (int i=0; i<historialVuelos.size(); i++) {
					
					System.out.println("- Vuelo #"+i+" | Salida: "+historialVuelos.get(i).getProcedencia()+" ("+historialVuelos.get(i).getFechaProcedencia().format(formatoFechaHora)+") | Destino: "+historialVuelos.get(i).getDestino()+" ("+historialVuelos.get(i).getFechaDestino().format(formatoFechaHora)+") ");
					
				}
			break;
			
			case 2:
				
			break;
			}
		
		} while (opcion < 0 || opcion > 3);
		
		//[7] Opcion extra  para terminar el programa
		if (opcion == 3) {
			System.out.println("\n[3] - Terminar el Programa el día "+fecha.format(formatoFechaHora)+".");
			System.exit(0);
			}
		}
		
	}
	

	//[Extra] Try-Catch para Int
	private static int introducirNumeroEntero(int opcion) {
		String texto;
		boolean correcto=false;
		
		do {
		try {
			texto = scString.nextLine();
			opcion = Integer.valueOf(texto);
			correcto=true;
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		}
		while (!correcto);
		return opcion;
	}

}
