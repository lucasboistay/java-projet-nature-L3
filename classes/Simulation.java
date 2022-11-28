/**
 * @author Lucas BOISTAY
 * 
 * Gestion de la simulation
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private Jardin jar;
    private Terrain ter;

    public Simulation(int x, int y){
        this.jar = new Jardin(x,y);
        this.ter = new Terrain(x,y);
    }

    // --- GETTEURS ---

    public Jardin getJardin(){
        return this.jar;
    }
    public Terrain getTerrain(){
        return this.ter;
    }

    // --- Méthodes autres ---

    public void popTree(){
        int x = (int) (Math.random()*ter.nbLignes);
        int y = (int) (Math.random()*ter.nbColonnes);

        while(!ter.caseEstVide(x,y)){
            x = (int) (Math.random()*ter.nbLignes);
            y = (int) (Math.random()*ter.nbColonnes);
        }

        Arbre a = new Arbre();
        ter.setCase(x,y,a);

        //A retirer ensuite
        System.out.println(a);
    }

    public void popQueen(){
        // A FAIRE
    }


}