public class TouteCasePleine extends Exception {
    private static final long serialVersionUID = 1L;

    public TouteCasePleine(){
        super("Toutes les cases du Jardin sont remplis, pas de mouvement possible");
    }
}
