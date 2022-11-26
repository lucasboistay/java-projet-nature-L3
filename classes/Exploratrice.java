/**
 * @author Lucas BOISTAY
 * 
 * Classe exploratrice
 */

import java.util.ArrayList; 

public class Exploratrice extends Agent{

    public static final int ENERGIE_MAX = 20;
    public static final int MAX_CHAMPI_PORTE = 3;
    public static final int DUREE_VIE_MAX = 50;

    private int energie;
    private int duree_vie;

    private ArrayList<Champignon> champi_porte;
    private Feuille feuille_porte;


    public Exploratrice(){
        super("Explo");

        this.energie = ENERGIE_MAX;
        this.duree_vie = DUREE_VIE_MAX;
    }

    // GETTEUR

    public int getEnergie(){
        return this.energie;
    }

    public int getDureeVie(){
        return this.duree_vie;
    }

    public ArrayList<Champignon> getChampiPorte(){
        return this.champi_porte;
    }

    public Feuille getFeuille(){
        return this.feuille_porte;
    }

    // SETTEUR

    public void energieDiminue(){
        this.energie --;
    }

    public void tempsPasseVie(){
        this.duree_vie --;
    }

    /**
     * Renvoie 1 si l'ajout a été fait
     * Renvoie -1 sinon
     */
    public int addChampiPorte(Champignon c){
        if(this.champi_porte.size() < MAX_CHAMPI_PORTE){
            this.champi_porte.add(c);
            return 1;
        }
        else{
            return -1;
        }
        
    }

    /**
     * Renvoie 1 si l'ajout a été fait
     * Renvoie -1 sinon
     */
    public int addFeuille(Feuille f){
        if(this.feuille_porte != NULL){
            this.feuille_porte = f;
            return 1;
        }
        else{
            return -1;
        }
    }


    public String toString(){
        return super.toString() + " Stats : {energie:" + this.energie + ",duree_vie:" + this.duree_vie+",Feuille:"+this.feuille_porte+",Champignon["+this.champi_porte.toString()+"]}" 
    }

}