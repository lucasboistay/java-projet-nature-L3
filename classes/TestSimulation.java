/**
 * @author Lucas BOISTAY
 * 
 * Gestion d'un terrain
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TestSimulation {

	public static final int MAX_ITERATION = 1000;
	public static Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Gestion Arguments
		int iteration = MAX_ITERATION;
		boolean logAffiche = false;

		for(int i=0; i < args.length ; i++){

			String argum = args[i];
			String value;

			switch(argum){
				case "-i":
					i++;
					value = args[i];
					iteration = Integer.parseInt(value);
					if(iteration > MAX_ITERATION){
						iteration = MAX_ITERATION;
					}
					System.out.println(argum + " : " + value+"\n");
					break;
				case "-log":
					logAffiche = true;
					System.out.println("Affichage log\n");
					break;
			}
		} 

		// CREATION DE LA SIMULATION

		Simulation s = new Simulation(10,10);

		//AFFICHAGE INITIAL

		s.getJardin().affiche(5);
		s.getTerrain().affiche(5);

		scan.nextLine();

		for(int i = 0 ; i<iteration;i++){

			String log = s.iteration();

			System.out.println("\033\143");
			System.out.println("---------------------------   I : " + i +"  --------------------------------");

			s.getJardin().affiche(5);
			s.getTerrain().affiche(5);

			if(logAffiche){
				System.out.println("---------------------------  LOGS --------------------------------");
				System.out.println(log);
			}
			System.out.println(s.getJardin().toString());
			System.out.println(s.getTerrain().toString());
			scan.nextLine();
		}

	}
}