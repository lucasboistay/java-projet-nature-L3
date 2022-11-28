/**
 * @author Lucas BOISTAY
 * 
 * Classe Champignon, hérite de Ressource
 */

import java.util.ArrayList; 

public class Champignon extends Ressource{
	public static final int ENERGIE_RENDU = 10;

	private static ArrayList<Champignon> listeChampi = new ArrayList<>();

	public boolean estPorte;

	public Champignon(){
		super("Champignon",1);

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

	public String toString(){
		return super.toString();
	}

}