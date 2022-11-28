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

    private Simulation(int x, int y){
        this.jard = new Jardin(x,y);
        this.ter = new Terrain(x,y);
    }

    // --- GETTEURS ---

    public getJardin(){
        return this.jar;
    }
    public getTerrain(){
        return this.ter;
    }

    // --- Méthodes autres ---

    public popTree(){
        // A FAIRE
    }

    public popQueen(){
        // A FAIRE
    }


}