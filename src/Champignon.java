/**
 * @author Lucas BOISTAY
 * 
 * Classe Champignon, hérite de Ressource
 */

import java.util.ArrayList; 

public class Champignon extends Ressource{
	public static final int ENERGIE_RENDU = 5;
	public static final int DUREE_VIE_MAX = 10;

	private static ArrayList<Champignon> listeChampi = new ArrayList<>();

	private int dureeVie;
	public boolean estPorte;

	public Champignon(){
		super("Champignon",1);

		this.dureeVie = DUREE_VIE_MAX;
		this.listeChampi.add(this);
		this.estPorte = false;
	}

	public static Champignon getChampiByID(int id){
		for(Champignon f : listeChampi){
			if(f.ident == id){
				return f;
			}
		}
		return null;
	}

	public static ArrayList<Champignon> getChampiList(){
        return listeChampi;
    }

    public void retirer(){
    	this.listeChampi.remove(this);
    }
	public int getDureeVie(){
		return this.dureeVie;
	}
	private void setDureeVie(int duree){
		this.dureeVie = duree;
	}

	public void tempsPasseVie(){
		this.dureeVie --;
	}


	@Override
	public String toString(){
		return super.toString() + " Vie : "+this.dureeVie;
	}

	@Override
	public Champignon clone(){
		Champignon c = new Champignon();
		c.setDureeVie(this.dureeVie);
		c.estPorte = this.estPorte;

		return c;
	}

}