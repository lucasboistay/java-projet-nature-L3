/**
 * @author Lucas BOISTAY
 * 
 * Classe de ressource Feuille, hérite de Ressource
 */

import java.util.ArrayList; 

public class Feuille extends Ressource{

	private int dureeVie;
	private int dureeTransfo;
	public boolean estPorte;

	public static final int DUREE_VIE_MAX = 10;
	public static final int DUREE_TRANSFO_MAX = 3;

	private static ArrayList<Feuille> listeFeuille = new ArrayList<>();

	public Feuille(){
		super("Feuille",1);

		this.dureeVie = DUREE_VIE_MAX;
		this.dureeTransfo = DUREE_TRANSFO_MAX;
		this.estPorte = false;

		this.listeFeuille.add(this);
	}

	public static ArrayList<Feuille> getFeuilleList(){
        return listeFeuille;
    }
	public int getDureeVie(){
		return this.dureeVie;
	}

	public int getDureeTransfo(){
		return this.dureeTransfo;
	}

	public void tempsPasseVie(){
		this.dureeVie --;
	}

	public void tempsPasseTransfo(){
		this.dureeTransfo --;
	}

	public String toString(){
		return super.toString() + " Vie : " + this.dureeVie + ". Transfo : " + this.dureeTransfo;
	}

}