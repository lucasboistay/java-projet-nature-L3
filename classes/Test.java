/**
 * @author Lucas
 * 
 * Gestion d'un terrain
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Exemple de création de terrain
		Terrain t = new Terrain(5,5);
		
		// On créé une ressource
		Arbre a1 = new Arbre();
		if (t.setCase(2,3,a1))
			System.out.println("Ajout de " +a1+" valide !");
		else
			System.out.println("Ajout incorrect: problème de coordonnées !");
		

		Feuille f1 = new Feuille();
		if (t.setCase(2,1,f1))
			System.out.println("Ajout de " +f1+" valide !");
		else
			System.out.println("Ajout incorrect: problème de coordonnées !");
		

		Champignon c1 = new Champignon();
		if (t.setCase(0,0,c1))
			System.out.println("Ajout de " +c1+ "valide !");
		else
			System.out.println("Ajout incorrect: problème de coordonnées !");

		t.affiche(6);

		System.out.println("Vidage d'une case:");
		Ressource etaitDansLaCase = t.videCase(1,0);
		if (etaitDansLaCase == null)
			System.out.println("La case était déjà vide.");
		else 
			System.out.println("La case contenait : "+etaitDansLaCase);
		
		System.out.println("Liste de toutes les ressources présentes actuellement:");
		ArrayList<Ressource> liste = t.lesRessources();
		for (Ressource r : liste) {
			System.out.println(r);
		}

		System.out.println(t);

		System.out.println("--------------------------------------");

		/***************************************************/

		System.out.println("----------------- TEST DES AGENTS ---------------------");
		Jardin j = new Jardin(10,10);

		Reine reine = Reine.INSTANCE;

		j.setCase(0,5,reine);

		System.out.println("Reine : " + reine);

		System.out.println("--------------- Ajout de 3 fourmis --------------");

		reine.popExplo(j);
		reine.popExplo(j);

		Exploratrice e = reine.popExplo(j);

		System.out.println("Fourmi suivi : " + e);

		j.affiche(6);

		System.out.println("------------------Ajout de 3 fourmis ------------------");

		
		reine.popExplo(j);
		reine.popExplo(j);
		reine.popExplo(j);

		j.affiche(6);

		ArrayList<Exploratrice> listeExplo = Exploratrice.getExploList();
		System.out.println("Liste des Explo présent actuellement : ");
		for(Exploratrice explo : listeExplo){
			System.out.println(explo);
		}

		System.out.println("-----------------Deplacement Fourmis--------------------");

		Scanner scan = new Scanner(System.in);

		for(int i=0;i<20;i++){
			for(Exploratrice explo : listeExplo){
				explo.moveToRand(j);
			}
			System.out.println("\033\143");
			j.affiche(5);

			scan.nextLine();

		}

		System.out.println("--------------------------------------");
		
		ArrayList<Agent> listeAgent = j.lesAgents();


		System.out.println("Liste des Agents présent actuellement : ");
		for(Agent a : listeAgent){
			System.out.println(a);
		}

		System.out.println(j);

		System.out.println("--------------------------------------");
		
	}

}
