/**
 * @author Lucas BOISTAY
 * 
 * Classe Reine
 */

import java.util.ArrayList; 

public class Reine extends Agent{

    public static final int CHAMPI_CREATION_FOURMI = 3;
    public static final int MAX_FOURMI = 10;

    public Reine(){
        super("Reine");

    }

    // SETTEUR

    /**
     * Renvoie une Exploratrice qui spawn aléatoirement autour de la reine
     * Renvoie null si pas de possibilité de spawn
     */
    public Exploratrice popExplo(Jardin jard){
        int dx = (int) (Math.random() * 3) - 1;
        int dy = (int) (Math.random() * 3) - 1;

        boolean b = false; // ON teste si il existe une case vide autour de la reine
        for(int i=-1 ; i < 2 ; i ++){
            for(int j =-1 ; j < 2 ; j++){
                if(jard.caseVide(this.x + i,this.y + j)){
                    b = true;
                }
            }
        }

        if(!b){ //On renvoie null si pas de case dispo
            System.out.println("PAS DE CASE DISPO, pas de fourmis créer...");
            return null;
        }

        while((dx==0 && dy == 0) || (!jard.caseVide(this.x+dx,this.y+dy))){ // ON évite que la fourmi spawn sur la case Reine ou sur un autre agent
            dx = (int) (Math.random() * 3) - 1;
            dy = (int) (Math.random() * 3) - 1;
        }

        Exploratrice e = new Exploratrice();
        jard.setCase(this.x+dx,this.y+dy,e);

        return e;
    }

    public String toString(){
        return super.toString();
    }

}