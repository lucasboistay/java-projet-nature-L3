/**
 * @author Lucas BOISTAY
 * 
 * Classe temps
 */

import java.util.ArrayList; 

public class Temps extends Agent{

    public static Temps INSTANCE = new Temps();

    private Temps(){
        super("Temps");
    }

    public static int fairePasserTemps(Jardin jar, Terrain ter){
        // Faire passer temps pour fourmis

        ArrayList<Exploratrice> listeExplo = new ArrayList<>();
        listeExplo = Exploratrice.getExploList();

        for(Exploratrice e : listeExplo){
            e.tempsPasseVie();
        }

        // Faire passer temps pour champignons

        ArrayList<Champignon> listeChampi = new ArrayList<>();
        listeChampi = Champignon.getChampiList();

        for(Champignon c : listeChampi){
            c.tempsPasseVie();
        }

        // Faire passer temps pour Feuilles

        ArrayList<Feuille> listeFeuille = new ArrayList<>();
        listeFeuille = Feuille.getFeuilleList();

        for(Feuille f : listeFeuille){
            f.tempsPasseVie();
        }

        return 1;
    }



}