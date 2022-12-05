/**
 * @author Lucas BOISTAY
 * 
 * Classe de ressource Arbre, hérite de Ressource
 *
 */

import java.util.ArrayList;

public class Arbre extends Ressource{

	public static final int TAILLE_MAX = 3;

	private static ArrayList<Arbre> listeArbre = new ArrayList<>();

	private final int taille;

	public Arbre(){
		super("Arbre",1);
		this.taille = (int) (Math.random()*TAILLE_MAX + 1);

		this.listeArbre.add(this);
	}

	/**
	 * Renvoie la taille de l'arbre, qui détermine combien de feuilles vont tomber
	 */
	public int getTaille(){
		return this.taille;
	}

	public static ArrayList<Arbre> getListeArbre(){
		return listeArbre;
	}

	public int popFeuille(Terrain t){
		int dx = (int) (Math.random() * 3) - 1;
        int dy = (int) (Math.random() * 3) - 1;

        boolean b = false; // ON teste si il existe une case vide autour de l'arbre
        for(int i=-1 ; i < 2 ; i ++){
            for(int j =-1 ; j < 2 ; j++){
                if(t.caseEstVide(this.getX() + i,this.getY() + j) && this.getX()+i > 0 && this.getX()+i < t.nbLignes && this.getY()+j > 0 && this.getY()+j < t.nbColonnes){
                    b = true;
                }
            }
        }

        if(!b){ //On renvoie -1 si pas de case dispo
            System.out.println("PAS DE CASE DISPO, pas de Feuille créer...");
            return -1;
        }

        while((dx==0 && dy == 0) || (!t.caseEstVide(this.getX()+dx,this.getY()+dy)) || (this.getX()+dx >= t.nbLignes) || (this.getX()+dx < 0)|| (this.getY()+dy >= t.nbColonnes) || (this.getY()+dy < 0)){ // ON évite que la feuille spawn sur la case Arbre ou sur une autre ressource
            dx = (int) (Math.random() * 3) - 1;
            dy = (int) (Math.random() * 3) - 1;
        }

        Feuille f = new Feuille();
        t.setCase(this.getX()+dx,this.getY()+dy,f);

        return 1;
	}

	public String toString(){
		return super.toString() + " Taille : "+ this.taille;
	}

}