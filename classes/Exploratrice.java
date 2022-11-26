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





}