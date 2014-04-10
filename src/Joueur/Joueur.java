
package Joueur;

import Plateau.Coup;
import Plateau.Plateau;

/**
 * Joueur abstrait
 * @author Mario
 */
public abstract class Joueur {
    
    protected int id;

    public Joueur(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    /**
     * Genere un coup que le joueur peut jouer
     * @param etatJeu
     * @return Coup à jouer
     */
    public abstract Coup genererCoup(Plateau etatJeu);
    
}
