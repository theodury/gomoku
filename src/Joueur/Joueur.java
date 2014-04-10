
package Joueur;

import Plateau.Coup;
import Plateau.Plateau;

/**
 * Joueur abstrait
 * @author Mario
 */
public abstract class Joueur {
    
    /**
     * Représente l'id du joueur
     */
    protected int id;

    public Joueur(int id) {
        this.id = id;
    }

    /**
     * Retourne l'id du joueur
     * @return id du joueur
     */
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
