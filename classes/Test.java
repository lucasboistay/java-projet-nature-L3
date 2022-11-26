/**
 * @author Lucas
 * 
 * Gestion d'un terrain
 *
 */

import java.util.ArrayList;

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

		Agent agent1 = new Agent("Fourmi");
		System.out.println(agent1);

		Agent agent2 = new Agent("Reine");
		System.out.println(agent2);

		Jardin j = new Jardin(5,5);

		j.setCase(1,1,agent1);
		j.setCase(2,2,agent2);
		ArrayList<Agent> listeAgent = j.lesAgents();

		System.out.println("Liste des Agents présent actuellement : ");
		for(Agent a : listeAgent){
			System.out.println(a);
		}

		j.affiche(6);

		System.out.println(j);

		System.out.println("--------------------------------------");
		
	}

}
