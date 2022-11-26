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

    public static ArrayList<Exploratrice> explo_list;

    private Reine(){
        super("Reine");

        this.explo_list = new ArrayList<>();
    }

    // SETTEUR
    public int popExplo(Jardin j){
        int dx = (int) (Math.random() * 3) - 1;
        int dy = (int) (Math.random() * 3) - 1;

        while((dx==0 && dy == 0) || (!j.caseVide(this.x+dx,this.y+dy))){ // ON évite que la fourmi spawn sur la case Reine ou sur un autre agent
            System.out.println("Position : "+x+","+y+"Tentative : " + dx + " " + dy);
            dx = (int) (Math.random() * 3) - 1;
            dy = (int) (Math.random() * 3) - 1;
        }

        Exploratrice e = new Exploratrice();
        j.setCase(this.x+dx,this.y+dy,e);

        this.explo_list.add(e);

        return 1;
    }

    public static void removeExplo(Exploratrice e){
        Reine.explo_list.remove(e);
    }

}