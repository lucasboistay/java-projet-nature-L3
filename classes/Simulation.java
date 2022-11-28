/**
 * @author Lucas BOISTAY
 * 
 * Gestion de la simulation
 *
 */

import java.util.ArrayList;

public class Simulation {

    private Jardin jar;
    private Terrain ter;

    public Simulation(int x, int y){
        this.jar = new Jardin(x,y);
        this.ter = new Terrain(x,y);

        this.popTree();
        this.popTree();
        this.popTree();

        Reine r = this.popQueen();
        r.popExplo(jar);

        System.out.println("----------- INITIALISATION FAITE ------------");
    }

    // --- GETTEURS ---

    public Jardin getJardin(){
        return this.jar;
    }
    public Terrain getTerrain(){
        return this.ter;
    }

    // --- Méthodes autres ---

    private Arbre popTree(){
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

        return a;
    }

    private Reine popQueen(){
        int x = (int) (Math.random()*jar.getLigne());
        int y = (int) (Math.random()*jar.getColonne());

        while(!jar.caseVide(x,y)){
            x = (int) (Math.random()*jar.getLigne());
            y = (int) (Math.random()*jar.getColonne());
        }

        Reine r = new Reine();
        jar.setCase(x,y,r);

        //A retirer ensuite
        System.out.println(r);
        return r;
    }

    private void popFeuilles(){
        ArrayList<Arbre> listeArbre = Arbre.getListeArbre();

        for(Arbre a : listeArbre){
            for(int i = 0 ; i<a.getTaille();i++){
                a.popFeuille(ter);
            }
        }
    }

    private void moveExplo(){
        ArrayList<Exploratrice> listeExplo = Exploratrice.getExploList();

        for(Exploratrice e : listeExplo){
            e.moveToRand(jar);
        }
    }

    public void iteration(){
        // Vérifie l'age des fourmis
        // Vérifie l'age des feuilles
        // Vérifie l'age des Champignons

        //Vérifie Energie des fourmis

        //Pop feuille sur les arbres
        popFeuilles();

        //Vérifie nombre de champignon sur le sol
        // Si 3 ou plus, créer exploratrice


        //Chaque fourmi vérifie la case sur laquelle elle est
        //Si vide, rien
        //Si feuille Récup si pas de feuille sur elle
        //Si champi, récup si elle a pas MAX_CHAMPI sur elle

        // Si feuille est sur fourmi : temps transfo -1

        //Si temps transfo = 0, fourmi transforme feuille en champi.
        // Si déjà MAX_CHAMPI sur elle, elle dépose au sol.

        //Fourmi move. 
        moveExplo();

    }



}