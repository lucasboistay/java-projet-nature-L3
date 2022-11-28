/**
 * @author Lucas BOISTAY
 * 
 * Gestion d'un terrain
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TestSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Simulation s = new Simulation(5,5);

		s.popTree();
		s.popTree();
		s.popTree();
		s.popTree();
		s.popTree();
		s.popTree();
		
		s.getTerrain().affiche(5);


	}
}