/**
 * @author Lucas BOISTAY
 * 
 * Classe Champignon, hérite de Ressource
 */

public class Champignon extends Ressource{
	public static final int ENERGIE_RENDU = 5;
	private static final int DUREE_VIE_MAX = 20;

	private int dureeVie;

	public Champignon(){
		super("Champignon",1);

		this.dureeVie = DUREE_VIE_MAX;
	}

	public int getDureeVie(){
		return this.dureeVie;
	}

	public void tempsPasseVie(){
		this.dureeVie --;
	}

	public String toString(){
		return super.toString() + "Vie : "+this.dureeVie;
	}

}