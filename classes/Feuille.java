/**
 * @author Lucas BOISTAY
 * 
 * Classe de ressource Feuille, hérite de Ressource
 */

public class Feuille extends Ressource{

	private int dureeVie;
	private int dureeTransfo;

	private static final int DUREE_VIE_MAX = 10;
	private static final int DUREE_TRANSFO_MAX = 3;

	public Feuille(){
		super("Feuille",1);

		this.dureeVie = DUREE_VIE_MAX;
		this.dureeTransfo = DUREE_TRANSFO_MAX;
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