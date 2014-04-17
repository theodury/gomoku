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

    public double getMoyenne() {

        return 10;
    }

    /**
     * Cherche le meilleur coup à jouer
     *
     * @return meilleur coup
     */
    public Coup getCoup() {
      return this.coup;
    }

    public void ajouteurVictoire() {

    }

    public void ajouteurDefaite() {

    }
}
