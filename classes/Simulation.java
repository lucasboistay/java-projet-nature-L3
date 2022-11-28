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

    private Reine r;

    public Simulation(int x, int y){
        this.jar = new Jardin(x,y);
        this.ter = new Terrain(x,y);

        Champignon c1 = new Champignon();
        Champignon c2 = new Champignon();
        Champignon c3 = new Champignon();
        Champignon c4 = new Champignon();
        Champignon c5 = new Champignon();
        Champignon c6 = new Champignon();
        Champignon c7 = new Champignon();



        ter.setCase(0,0,c1);
        ter.setCase(2,2,c2);
        ter.setCase(3,3,c3);
        ter.setCase(4,4,c4);
        ter.setCase(1,1,c5);
        ter.setCase(5,5,c6);
        ter.setCase(6,6,c7);

        this.popTree();
        this.popTree();
        this.popTree();

        this.r = this.popQueen();
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

    private String verifChampi(){
        ArrayList<Champignon> listeChampi = Champignon.getChampiList();

        ArrayList<Champignon> champiPasPorte = new ArrayList<>();

        for(Champignon c : listeChampi){
            if(!c.estPorte){
                champiPasPorte.add(c);
            }
            if(champiPasPorte.size() == 3){
                Exploratrice e = r.popExplo(jar);
                for (Champignon champ : champiPasPorte){
                    ter.videCase(champ.getX(),champ.getY());
                    champ.retirer();   
                }
                return e.toString();
            }
        }
        return "Aucune";
    }

    // RENVOIE LES LOGS
    public String iteration(){
        // Vérifie l'age des fourmis
        // Vérifie l'age des feuilles
        // Vérifie l'age des Champignons

        //Vérifie Energie des fourmis

        //Pop feuille sur les arbres
        popFeuilles();

        //Vérifie nombre de champignon sur le sol
        // Si 3 ou plus, créer exploratrice
        String fourmiForme = verifChampi();

        //Chaque fourmi vérifie la case sur laquelle elle est
        //Si vide, rien
        //Si feuille Récup si pas de feuille sur elle
        //Si champi, récup si elle a pas MAX_CHAMPI sur elle

        // Si feuille est sur fourmi : temps transfo -1

        //Si temps transfo = 0, fourmi transforme feuille en champi.
        // Si déjà MAX_CHAMPI sur elle, elle dépose au sol.

        //Fourmi move. 
        moveExplo();

        return "Fourmi Né : " + fourmiForme;

    }



}