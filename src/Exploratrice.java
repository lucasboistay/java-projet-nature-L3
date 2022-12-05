/**
 * @author Lucas BOISTAY
 * 
 * Classe exploratrice
 */

import java.util.ArrayList; 

public class Exploratrice extends Agent implements Mortel{

    public static final int ENERGIE_MAX = 20;
    public static final int MAX_CHAMPI_PORTE = 3;
    public static final int DUREE_VIE_MAX = 50;

    private static ArrayList<Exploratrice> listeExplo = new ArrayList<>();

    private int energie;
    private int duree_vie;

    private ArrayList<Champignon> champi_porte;
    private Feuille feuille_porte;


    public Exploratrice() {
        super("Explo");

        this.energie = ENERGIE_MAX;
        this.duree_vie = DUREE_VIE_MAX;
        this.listeExplo.add(this);

        this.champi_porte = new ArrayList<>();
    }

    // GETTEUR
    public static ArrayList<Exploratrice> getExploList(){
        return listeExplo;
    }
    @Override
    public int getEnergie(){
        return this.energie;
    }
    @Override
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
    @Override
    public void mange(){
        if(this.energie + Champignon.ENERGIE_RENDU >= ENERGIE_MAX){
            this.energie = ENERGIE_MAX;
        }
        else{
            this.energie += Champignon.ENERGIE_RENDU;
        }
    }
    @Override
    public void energieDiminue(){
        this.energie --;
    }
    @Override
    public void tempsPasseVie(){
        this.duree_vie --;
    }

    public void removeFeuille(){
        this.feuille_porte = null;
    }

    public void removeExplo(){
        this.listeExplo.remove(this);
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
    public void addFeuille(Feuille f){
        this.feuille_porte = f;
    }

    /**
     * Permet de déplacer la fourmi dans le jardin jard donné
     */
    public void moveTo(int x,int y, Jardin jard){
        jard.videCaseAgent(this.x,this.y);
        super.seDeplacer(x,y);
        jard.setCase(x,y,this);
    }

    /**
     * Déplace la fourmi à une position aléatoire autour d'elle
     * Renvoie 1 si c'est réussi
     * Renvoie -1 si la fourmi n'a pas bougé
     */
    public int moveToRand(Jardin jard){
        int dx = (int) (Math.random() * 3) - 1;
        int dy = (int) (Math.random() * 3) - 1;

        boolean b = false; // ON teste si il existe une case vide autour de la fourmi
        for(int i=-1 ; i < 2 ; i ++){
            for(int j =-1 ; j < 2 ; j++){
                if(jard.caseVide(this.x + i,this.y + j)){
                    b = true;
                }
            }
        }

        if(!b){ //On renvoie null si pas de case dispo
            System.out.println("PAS DE CASE DISPO, pas de déplacement.");
            return -1;
        }

        while((dx==0 && dy == 0) || (!jard.caseVide(this.x+dx,this.y+dy))){ // ON évite que la fourmi spawn sur la case Reine ou sur un autre agent
            dx = (int) (Math.random() * 3) - 1;
            dy = (int) (Math.random() * 3) - 1;
        }

        this.moveTo(this.x+dx,this.y+dy,jard);
        return 1;
    }

    public int popChampi(Terrain t){
        int dx = (int) (Math.random() * 3) - 1;
        int dy = (int) (Math.random() * 3) - 1;

        boolean b = false; // ON teste si il existe une case vide autour de la fourmi
        for(int i=-1 ; i < 2 ; i ++){
            for(int j =-1 ; j < 2 ; j++){
                if(t.caseEstVide(this.x + i,this.y + j)){
                    b = true;
                }
            }
        }

        if(!b){ //On renvoie null si pas de case dispo
            return -1;
        }

        while((dx==0 && dy == 0) || (!t.caseEstVide(this.x+dx,this.y+dy))){ // ON évite que la fourmi spawn sur la case Reine ou sur un autre agent
            dx = (int) (Math.random() * 3) - 1;
            dy = (int) (Math.random() * 3) - 1;
        }

        Champignon c = new Champignon();
        t.setCase(this.x+dx , this.y+dy, c);
        return 1;
    }

    @Override
    public String toString(){
        return super.toString() + " Stats : {energie:" + this.energie + ",duree_vie:" + this.duree_vie+"}";
    }

}