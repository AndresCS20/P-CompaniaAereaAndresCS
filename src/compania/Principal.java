package compania;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.Random;
public class Principal {

	public static Scanner scString=new Scanner(System.in);
	
	public static void main(String[] args) {
		LocalDateTime fechaPrograma=LocalDateTime.now();
		ArrayList <Vuelo> historialVuelos=new ArrayList();
		DateTimeFormatter formatoFechaSolo=DateTimeFormatter.ofPattern("dd-MM-YYYY");
		DateTimeFormatter formatoFechaHora=DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
		int opcion=0;
		boolean primerDia=false;
		String salida="";
		String destino="";
		Random r=new Random();
		int numAleatorioDestino=0;
		String codigoVuelo="";
		int numVuelo=0;
		
		//----------------(Solo Pruebas) Eliminar--------------------//
			LocalDateTime fechaNueva=fechaPrograma.plusHours(5);
			Vuelo vuelo1=new Vuelo("Madrid", "Sevilla", fechaNueva);
			historialVuelos.add(vuelo1);
		//-----------------------------------------------------------//
			
		//fechaPrograma.withHour(10); Cambiar de Hora
		while (true) {
		do {
			
			System.out.println("\n"+fechaPrograma.format(formatoFechaSolo));
			System.out.println("1.- Listado de vuelos totales");
			System.out.println("2.- Pasar día siguiente y ver vuelos");
			System.out.println("3.- Finalizar programa");
			System.out.println("Introduce un numero (1-3) para elegir una opción del menu");
			
			
			opcion=introducirNumeroEntero(opcion);
			
			
			
			switch (opcion) {
			case 1:
				historialVuelos(historialVuelos, formatoFechaHora);
			break;
			
			case 2:
				System.out.println("[2]Pasar dia siguiente y ver vuelos");
				fechaPrograma=fechaPrograma.plusDays(1);
				int avion=1;
				//Hacer una variable booleana, hacer un if para que mientras
				//esa variable sea falsa se ejecute el if sino else, 
				//y cuando pase el día cambiarla a true
				//Dentro de ese if que tome como ORIGEN MADRID y el resto tome el destino de su vuelo anterior 
				//a partir del ARRAY historial vuelos
				//Ejemplo: Vuelo 5 toma el destino del vuelo 1 como origen, vuelo 6 el destino de vuelo 2 etc

				if (!primerDia) {
					
					salida="Madrid";
					
					String [] destinos= {"Madrid","Barcelona", "Valencia", "Alicante", "Bilbao", "Tenerife"};
					for (int i =1; i < 5; i++) {
					boolean destinoIgualSalida=true;
					while (destinoIgualSalida) {
					numAleatorioDestino=r.nextInt(6);		
						if (!destinos[numAleatorioDestino].equals(salida) && !(destinos[numAleatorioDestino].isEmpty())) {
							
							numVuelo++;
							System.out.println("numvuelo"+numVuelo);
							destinoIgualSalida=false;
							codigoVuelo=avion+salida.substring(0,2)+destinos[numAleatorioDestino].substring(0,2)+numVuelo;
							codigoVuelo=codigoVuelo.toUpperCase();
							System.out.println(codigoVuelo);
							avion++;
							
							Vuelo vuelo=new Vuelo(salida,destinos[numAleatorioDestino], fechaNueva);
							historialVuelos.add(vuelo);
						}
					}
					
					System.out.println("Vuelo #"+i+ " Salida: "+salida+" Destino: "+destinos[numAleatorioDestino]);
					destinos[numAleatorioDestino]="";

					
					}
					
					
					primerDia=true;
				}
				
				else {
					
					
				}
				vuelo1.setFechaProcedencia(fechaPrograma);
				break;
			}
		
		} while (opcion < 0 || opcion > 3);
		
		//[3] Opcion extra  para terminar el programa
		if (opcion == 3) {
			System.out.println("\n[3] - Terminar el Programa el día "+fechaPrograma.format(formatoFechaHora)+".");
			System.exit(0);
			}
		}
		
	}


	private static void historialVuelos(ArrayList<Vuelo> historialVuelos, DateTimeFormatter formatoFechaHora) {
		System.out.println("[1] Listado de Vuelos Totales");
		for (int i=0; i<historialVuelos.size(); i++) {
			System.out.println("- Vuelo #"+i+" | Salida: "+historialVuelos.get(i).getProcedencia()+" ("+historialVuelos.get(i).getFechaProcedencia().format(formatoFechaHora)+") | Destino: "+historialVuelos.get(i).getDestino()+" ("+historialVuelos.get(i).getFechaDestino().format(formatoFechaHora)+") ");	
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
