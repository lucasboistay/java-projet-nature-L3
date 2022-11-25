/**
 * @author Lucas BOISTAY
 * 
 * Classe de ressource Arbre, hérite de Ressource
 *
 */

import java.util.ArrayList;

public class Arbre extends Ressource{

	private static final int TAILLE_MAX = 3;

	private final int taille;

	public Arbre(){
		super("Arbre",1);
		this.taille = (int) (Math.random()*TAILLE_MAX + 1);
	}

	/**
	 * Renvoie la taille de l'arbre, qui détermine combien de feuilles vont tomber
	 */
	public int getTaille(){
		return this.taille;
	}

	public String toString(){
		return super.toString() + " Taille : "+ this.taille;
	}

}