/**
 * @author Lucas BOISTAY
 * 
 * Classe Agent, héritage de tout les agent
 */

import java.util.ArrayList; 

public class Agent{
	public static final int MAX_AGENT = 100;

	private final int ident;
	private static int nbAgent = 0;
	private final String type;

	protected int x;
	protected int y;

	public Agent(String type){
		this.ident = nbAgent ++;
		this.type = type;

		this.x = -1;
		this.y = -1;
	}

	public String getType(){
		return this.type;
	}

	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}

	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return "Agent "+this.type + "[id:" + this.ident + " x:" + this.x + " y:" + this.y + "]";
	}
}