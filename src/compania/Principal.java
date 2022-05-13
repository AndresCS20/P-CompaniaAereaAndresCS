package compania;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.Random;
import java.time.temporal.*;
public class Principal {

	public static Scanner scString=new Scanner(System.in);
	public static LocalDate fechaPrograma=LocalDate.now();
	public static ArrayList <Vuelo> historialVuelos=new ArrayList();
	public static ArrayList <Vuelo> vuelosDelDia=new ArrayList();
	public static DateTimeFormatter formatoFechaSolo=DateTimeFormatter.ofPattern("dd-MM-YYYY");
	public static DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
	public static int opcion=0;
	public static int otroVuelo=0;
	public static boolean primerDia=false;
	public static String salida="";
	public static String destino="";
	public static Random r=new Random();
	public static int numAleatorioDestino=0;
	public static String codigoVuelo="";
	public static String codigoSalidaDestino="";
	public static int numVuelo=0;
	public static int horas=0;
	public static int minutos=0;
	public static Integer duracionVuelo=0;
	public static LocalTime horaSalidaVuelo=LocalTime.now();
	public static LocalTime horaDestinoVuelo;
	
	public static HashMap <String,Integer> listaHistorial = new HashMap();
	public static void main(String[] args) {


		while (true) {
		do {
			
			System.out.println("\n"+fechaPrograma.format(formatoFechaSolo));
			System.out.println("1.- Listado de vuelos totales");
			System.out.println("2.- Pasar dia siguiente y ver vuelos");
			System.out.println("3.- Finalizar programa");
			System.out.println("Introduce un numero (1-3) para elegir una opcion del menu");
			
			
			opcion=introducirNumeroEntero(opcion);
			
			
			
			switch (opcion) {
			case 1:
				historialVuelos(historialVuelos, formatoFechaSolo);
			break;
			
			case 2:
				pasarDiayGenerarVuelos();
				break;
			}
		
		} while (opcion < 0 || opcion > 3);
		
		//[3] Opcion extra  para terminar el programa
		if (opcion == 3) {
			System.out.println("\n[3] - Terminar el Programa el dia "+fechaPrograma.format(formatoFechaSolo)+".");
			System.exit(0);
			}
		}
		
	}

	//[2] Pasar al Dia Siguiente y Generar Vuelos
	
	private static void pasarDiayGenerarVuelos() {
		System.out.println("[2]Pasar dia siguiente y ver vuelos");
		fechaPrograma=fechaPrograma.plusDays(1);
		int avion=1;
		//Generar vuelos el primer dia
		if (!primerDia) {
			
			salida="Madrid";
			
			String [] destinos= {"Madrid","Barcelona", "Valencia", "Alicante", "Bilbao", "Tenerife"};
			for (int i =1; i < 5; i++) {
			boolean destinoIgualSalida=true;
			while (destinoIgualSalida) {
			numAleatorioDestino=r.nextInt(6);		
				if (!destinos[numAleatorioDestino].equals(salida) && !(destinos[numAleatorioDestino].isEmpty())) {
					numVuelo++;
					destinoIgualSalida=false;
					codigoSalidaDestino=salida.substring(0,2)+destinos[numAleatorioDestino].substring(0,2);
					codigoSalidaDestino=codigoSalidaDestino.toUpperCase();
					codigoVuelo=avion+codigoSalidaDestino+numVuelo;
			
					
						horas=r.nextInt(17)+7;

						boolean numMultiCinco=false;
						while (!numMultiCinco) {
						
							minutos=r.nextInt(56);
							
							if (minutos%5==0) {
								numMultiCinco=true;
							}
							
						}
						
						horaSalidaVuelo=LocalTime.of(horas, minutos);
					
						Vuelo vuelo=new Vuelo(salida,destinos[numAleatorioDestino],codigoVuelo,codigoSalidaDestino,horaSalidaVuelo,fechaPrograma);
						vuelosDelDia.add(vuelo);
						System.out.println(codigoVuelo+": "+salida+" - "+destinos[numAleatorioDestino]+" \t"+horaSalidaVuelo);


					}
				}
			destinos[numAleatorioDestino]="";
			
			}	
			
				for (int i=0; i<vuelosDelDia.size(); i++) {
								int duracion=0;
								LocalDate fechaDestino=fechaPrograma;
						System.out.println("Hora de Salida "+ vuelosDelDia.get(i).getHoraSalida().format(formatoHora));								
						do {
							
							System.out.println("Duracion del vuelo en minutos avion "+avion+": "+salida+ " - "+vuelosDelDia.get(i).getDestino()+"?");
							System.out.println("(Duracion Maxima 5 Horas (300 minutos)");
							duracion=introducirNumeroEntero(opcion);
						} while (duracion<=0 || duracion>300);
						
						System.out.println("Hora de Salida "+ vuelosDelDia.get(i).getHoraSalida().format(formatoHora));								
						horaDestinoVuelo=vuelosDelDia.get(i).getHoraSalida().plusMinutes(duracion);
						System.out.print("Hora de llegada "+ horaDestinoVuelo.format(formatoHora));
						vuelosDelDia.get(i).setFechaDestino(fechaPrograma);
						
						if (horaDestinoVuelo.getHour()>=00 && horaDestinoVuelo.getHour()<=06) {
							
							System.out.println(" del dia siguiente.");
							fechaDestino=fechaDestino.plusDays(1);
							vuelosDelDia.get(i).setFechaDestino(fechaDestino);
						}
						else System.out.println("\n");
						duracionVuelo=Integer.valueOf(duracion);
					listaHistorial.put(vuelosDelDia.get(i).getCodigoSalidaDestino(), duracionVuelo);
					
					avion++;
					vuelosDelDia.get(i).setFechaDestino(fechaDestino);
					vuelosDelDia.get(i).setHoraDestino(horaDestinoVuelo);
					historialVuelos.add(vuelosDelDia.get(i));
	
		
			
			System.out.println("-----------------------------------\n");
			

		primerDia=true;
		
				}
				vuelosDelDia.clear();
		}
		//Generar vuelos a partir del dia primero
		
		else {
			String [] destinos= {"Madrid","Barcelona", "Valencia", "Alicante", "Bilbao", "Tenerife"};
			for (int i =1; i < 5; i++) {
			salida=historialVuelos.get(otroVuelo).getDestino();
			boolean destinoIgualSalida=true;
			while (destinoIgualSalida) {
			numAleatorioDestino=r.nextInt(6);		
				if (!destinos[numAleatorioDestino].equals(salida) && !(destinos[numAleatorioDestino].isEmpty())) {
					numVuelo++;
					destinoIgualSalida=false;
					codigoSalidaDestino=salida.substring(0,2)+destinos[numAleatorioDestino].substring(0,2);
					codigoSalidaDestino=codigoSalidaDestino.toUpperCase();
					codigoVuelo=avion+codigoSalidaDestino+numVuelo;
			
					
						horas=r.nextInt(17)+7;

						boolean numMultiCinco=false;
						while (!numMultiCinco) {
						
							minutos=r.nextInt(56);
							
							if (minutos%5==0) {
								numMultiCinco=true;
							}
							
						}
						
						horaSalidaVuelo=LocalTime.of(horas, minutos);
					
						Vuelo vuelo=new Vuelo(salida,destinos[numAleatorioDestino],codigoVuelo,codigoSalidaDestino,horaSalidaVuelo,fechaPrograma);
						vuelosDelDia.add(vuelo);
						System.out.println(codigoVuelo+": "+salida+" - "+destinos[numAleatorioDestino]+" \t"+horaSalidaVuelo);


					}
				}
			destinos[numAleatorioDestino]="";
			otroVuelo++;
			}			
						for (int i=0; i<vuelosDelDia.size(); i++) {
						int duracion=0;
						LocalDate fechaDestino=fechaPrograma;
						if (listaHistorial.containsKey(vuelosDelDia.get(i).getCodigoSalidaDestino())) {
							System.out.println("Duracion del vuelo en minutos avion "+avion+": "+vuelosDelDia.get(i).getProcedencia()+ " - "+vuelosDelDia.get(i).getDestino());
							duracion=listaHistorial.get(vuelosDelDia.get(i).getCodigoSalidaDestino());//Posible fallo dentro de codigo salida
							horaDestinoVuelo=horaSalidaVuelo.plusMinutes(duracion);
							
						}
						
						else {
							
							do {
								
								System.out.println("Duracion del vuelo en minutos avion "+avion+": "+vuelosDelDia.get(i).getProcedencia()+ " - "+vuelosDelDia.get(i).getDestino()+"?");
								System.out.println("(Duracion Maxima 5 Horas (300 minutos)");
								duracion=introducirNumeroEntero(opcion);
							} while (duracion<=0 || duracion>300);
							duracionVuelo=duracion;
							listaHistorial.put(vuelosDelDia.get(i).getCodigoSalidaDestino(), duracionVuelo);
						}
						System.out.println("Hora de Salida "+ vuelosDelDia.get(i).getHoraSalida().format(formatoHora));	
						horaDestinoVuelo=vuelosDelDia.get(i).getHoraSalida().plusMinutes(duracion);
						System.out.print("Hora de llegada "+ horaDestinoVuelo.format(formatoHora));
						vuelosDelDia.get(i).setFechaDestino(fechaPrograma);
						if (horaDestinoVuelo.getHour()>=00 && horaDestinoVuelo.getHour()<=06) {
							
							System.out.println(" del dia siguiente.");
							fechaDestino=fechaDestino.plusDays(1);
							vuelosDelDia.get(i).setFechaDestino(fechaDestino);

						}
						else System.out.println("\n");
					avion++;
					vuelosDelDia.get(i).setFechaDestino(fechaDestino);
					vuelosDelDia.get(i).setHoraDestino(horaDestinoVuelo);
					historialVuelos.add(vuelosDelDia.get(i));

			
		
			System.out.println("-----------------------------------\n");


						}
			
		} vuelosDelDia.clear();
	}

	//[1] Listar Historial de Vuelos
	
	private static void historialVuelos(ArrayList<Vuelo> historialVuelos, DateTimeFormatter formatoFechaHora) {
		System.out.println("[1] Listado de Vuelos Totales");
		if (historialVuelos.size()>0) {
			for (int i=0; i<historialVuelos.size(); i++) {
				System.out.println("- Vuelo #"+(i+1)+" | Codigo Vuelo: "+historialVuelos.get(i).getCodigo()+" | Salida: "+historialVuelos.get(i).getProcedencia()+" ("+historialVuelos.get(i).getFechaSalida().format(formatoFechaHora)+" "+historialVuelos.get(i).getHoraSalida()+
						") | Destino: "+historialVuelos.get(i).getDestino()+" ("+historialVuelos.get(i).getFechaDestino().format(formatoFechaHora)+" "+historialVuelos.get(i).getHoraDestino()+")");	
			}			
		}
		
		else System.err.println("ERROR: No hay vuelos creados para poder mostrar.");

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
