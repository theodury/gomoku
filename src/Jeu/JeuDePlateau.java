
package Jeu;

import Joueur.Joueur;

/**
 * Jeu de plateau générique
 * @author Mario
 */
public abstract class JeuDePlateau {
    
    /**
     * Liste des joueurs
     */
    protected Joueur joueurs[];
    
    /**
     * Joueur courant
     */
    protected Joueur joueurCourant;
    
    /**
     * Plateau de jeu
     */
    protected Plateau plateau;
    
    /**
     * Verifie si la partie est finie
     * @return Vrai si finie, faux sinon
     */
    public abstract boolean partieTerminee();
    
    /**
     * Verifie si le coup est valide
     * @param coup Coup à jouer
     * @return Vrai si valide, faux sinon
     */
    public abstract boolean coupValide(Coup coup);
    
    // TODO: Autres fonctions à définir ici!
   

}
