package es.iesdonosocortes.dam.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiPrimerProceso {

	public static void main(String[] args) {
		
		//Muestro  el pid del main 
		//lsConParametro();
		lsConParametrosSalida();
		
	}
	

	private static void lsConParametrosSalida() {
		System.out.println(ProcessHandle.current().pid());
		
		
		try {
			
			//Crear un objeto de proceesBuilder  pasando el parametro lo que quiere ejecutar 
			ProcessBuilder pb = new ProcessBuilder("ls","-l", "/home"); 
			// inicio el proceso 
			Process p = pb.start();
			// muestro el proceso que he ejecutado 
			System.out.println("PID proceso ls "+ p.pid()); 
			
			
			
			//Creo el objeto InputStreamReader 
			InputStreamReader isr = new  InputStreamReader(p.getInputStream());
			//Creo el objeto BufferedReader
			BufferedReader  br = new  BufferedReader(isr);
			
			//  leer lineas mientras sea cierto
			//String para almacenar linea  siempre se necesita  la variable para mostrar el texto 
			String linea; 
			while((linea=br.readLine()) !=null) {
				
				System.out.println(linea);
			}
			
			
			
		}catch(IOException e) {
			
			System.out.println(e.getMessage()); 
		}
	}



	private static void lsConParametro() {
		System.out.println(ProcessHandle.current().pid());
		
		
		try {
			
			//Crear un objeto de proceesBuilder  pasando el parametro lo que quiere ejecutar 
			ProcessBuilder pb = new ProcessBuilder("ls"); 
			// inicio el proceso 
			Process p = pb.start();
			// muestro el proceso que he ejecutado 
			System.out.println("PID proceso ls "+ p.pid()); 
			
		}catch(IOException e) {
			
			System.out.println(e.getMessage()); 
		}
	}

}
