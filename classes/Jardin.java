/**
 * @author Lucas BOISTAY
 * 
 * Classe Jardin, "copie" de la classe Terrain pour les agent.
 */

import java.util.ArrayList;

public class Jardin{
	public static final int NBLIGNESMAX = 20;
	public static final int NBCOLONNESMAX = 20;

	private ArrayList<Agent> listeAgent;
	private Agent[][] tabAgent;

	public Jardin(int ligne, int colonne){
		this.listeAgent = new ArrayList<Agent>();
		if(ligne > NBLIGNESMAX){
			ligne = NBLIGNESMAX;
		}
		if(colonne > NBCOLONNESMAX){
			colonne = NBCOLONNESMAX;
		}

		this.tabAgent = new Agent[ligne][colonne];
	}

	private void addAgent(Agent a){
		this.listeAgent.add(a);
	}

	private void removeAgent(Agent a){
		this.listeAgent.remove(a);
	}

	// Même que dans Terrain mais signature différente !
	public void setCase(int lig,int col, Agent a){
		this.tabAgent[lig][col] = a;
		this.addAgent(a);
		a.setPosition(lig,col);
	}

	public ArrayList<Agent> lesAgents(){
		return this.listeAgent;
	}

	public Agent videCaseAgent(int lig,int col){
		Agent a = this.tabAgent[lig][col];
		this.tabAgent[lig][col] = null;

		this.removeAgent(a);
		a.setPosition(-1,-1);
		return a;
	}

	public int getLigne(){
		return this.tabAgent.length;
	}
	public int getColonne(){
		return this.tabAgent[0].length;
	}

	//A FAIRE
	public String toString(){
		return "Jardin de " + this.getLigne() + "x" + this.getColonne() + " : il y a " + this.listeAgent.size() + " cases occupées.";
	}

	public void affiche(int nbCaractere){
		String delimLigne = ":";

		for (int y=0;y<tabAgent.length;y++){
			for (int i=0;i<nbCaractere;i++){
				delimLigne += "-";
			}
			delimLigne += ":";
		}

		String blanc = "";

		for (int i=0;i<nbCaractere;i++){
			blanc += " ";
		}

		System.out.println(delimLigne);
		for (int i=0; i<tabAgent.length;i++){
			String ligne = "|";
			for (int y=0;y<tabAgent[0].length;y++){
				if (tabAgent[i][y] != null){
					String type = tabAgent[i][y].getType();
					if (type.length() > nbCaractere){
						ligne += type.substring(0,nbCaractere);
					} else {
						ligne += type;
						for(int n=0;n<(nbCaractere-type.length());n++){
							ligne += " ";
						}
					}
				} else {
					ligne += blanc;
				}
				ligne += "|";
				
			}
			System.out.println(ligne);
			System.out.println(delimLigne);
		}

	}
}