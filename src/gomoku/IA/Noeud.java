package gomoku.IA;

import gomoku.Plateau.Coup;
import gomoku.Plateau.Position;
import java.util.ArrayList;

/**
 * Noeud utilisé pour Monte Carlo
 *
 * @author Mario
 */
public class Noeud {

    private int nbVictoire;
    private int nbSimulation;
    private Coup coup;

    /**
     * Constructeur de noeud
     *
     * @param coup
     */
    public Noeud(Coup coup) {
        this.coup = coup;
    }

    public void setNbSimulation(int nombre){
        this.nbSimulation = nombre;
    }
    
    public double getMoyenne() {
        return (double)this.nbVictoire/this.nbSimulation ;
    }

    /**
    * Cherche le meilleur coup à jouer
    * @return meilleur coup
    */
    public Coup getCoup() {
      return this.coup;
    }

    /**
     * Compte une victoire en fonction des coups
     * @param nCoup 
     */
    public void ajouterVictoire(int nCoup) {
        nbVictoire += 10; //(99-nCoup) * 10 ;  
    }

    public void ajouterDefaite(int nCoup){
        nbVictoire -= 10;//nCoup * 10;
    }
}
