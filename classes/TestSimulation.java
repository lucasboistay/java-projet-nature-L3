/**
 * @author Lucas BOISTAY
 * 
 * Gestion d'un terrain
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TestSimulation {

	public static final int MAX_ITERATION = 50;
	public static Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if(args.length < 1){
			System.out.println("PAS ASSEZ D'ARGUMENTS !!");
			System.exit(-1);
		}

		Simulation s = new Simulation(10,10);

		s.getJardin().affiche(5);
		s.getTerrain().affiche(5);

		int iteration = Integer.parseInt(args[0]);
		if(iteration > MAX_ITERATION){
			iteration = MAX_ITERATION;
		}

		scan.nextLine();

		String log;

		for(int i = 0 ; i<iteration;i++){

			log = s.iteration();

			System.out.println("\033\143");
			System.out.println("---------------------------   I : " + i +"  --------------------------------");

			s.getJardin().affiche(5);
			s.getTerrain().affiche(5);

			System.out.println("---------------------------  LOGS --------------------------------");
			System.out.println(log);
			System.out.println(s.getJardin().toString());
			System.out.println(s.getTerrain().toString());
			
			scan.nextLine();
		}

	}
}