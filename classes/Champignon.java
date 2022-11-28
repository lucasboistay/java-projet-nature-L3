/**
 * @author Lucas BOISTAY
 * 
 * Classe Champignon, hérite de Ressource
 */

import java.util.ArrayList; 

public class Champignon extends Ressource{
	public static final int ENERGIE_RENDU = 5;
	public static final int DUREE_VIE_MAX = 20;

	private static ArrayList<Champignon> listeChampi = new ArrayList<>();

	private int dureeVie;

	public Champignon(){
		super("Champignon",1);

		this.dureeVie = DUREE_VIE_MAX;
		this.listeChampi.add(this);
	}

	public static ArrayList<Champignon> getChampiList(){
        return listeChampi;
    }
	public int getDureeVie(){
		return this.dureeVie;
	}

	public void tempsPasseVie(){
		this.dureeVie --;
	}

	public String toString(){
		return super.toString() + " Vie : "+this.dureeVie;
	}

}