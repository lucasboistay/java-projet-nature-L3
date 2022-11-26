/**
 * @author Lucas BOISTAY
 * 
 * Classe Reine
 */

import java.util.ArrayList; 

public class Reine extends Agent{

    public static final int CHAMPI_CREATION_FOURMI = 3;
    public static final int MAX_FOURMI = 10;

    public static Reine INSTANCE = new Reine();

    private static ArrayList<Exploratrice> explo_list;

    private Reine(){
        super("Reine");
    }

    // GETTEUR 
    public static getExploList(){
        return this.explo_list;
    }

    // SETTEUR
    public static int popExplo(Jardin j){
        int dx = (int) (Math.random() * 2) - 1;
        int dy = (int) (Math.random() * 2) - 1;

        while((dx==0 && dy == 0)|| j.caseVide(super.x+dx,super.y+dy)){ // ON évite que la fourmi spawn sur la case Reine ou sur un autre agent
            dx = (int) (Math.random() * 2) - 1;
            dy = (int) (Math.random() * 2) - 1;
        }

        Exploratrice e = new Exploratrice();
        j.setCase(super.x+dx,super.y+dy,e);

        this.explo_list.add(e);
    }

    public static removeExplo(Exploratrice e){
        this.explo_list.remove(e);
    }

}