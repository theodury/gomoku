package gomoku.Jeu;

import gomoku.Joueur.Joueur;
import gomoku.Plateau.Coup;
import gomoku.Plateau.Plateau;
import gomoku.Plateau.PlateauGomoku;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Jeu de plateau générique
 *
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
    protected int joueurCourant;

    /**
     * Plateau de jeu
     */
    protected Plateau plateau;

    /**
     * Verifie si la partie est finie
     *
     * @return Vrai si partie finie, faux sinon
     */
    public abstract boolean partieTerminee();

    /**
     * Verifie si le coup est valide
     *
     * @param coup Coup à jouer
     * @return Vrai si valide, faux sinon
     */
    public abstract boolean coupValide(Coup coup);

    /**
     * Permet de modifier les valeurs d'un des joueurs
     *
     * @param ordre position du joueur
     * @param joueur Joueur
     */
    public void setJoueur(int ordre, Joueur joueur) {
        this.joueurs[ordre] = joueur;
    }

    /**
     * Permet de modifier la valeurs du plateau
     *
     * @param plateau Plateau
     */
    public void setPlateau(PlateauGomoku plateau) {
        this.plateau = plateau;
        // Initialise le premier joueur si plateau avec situation initiale
        if (plateau.getDernierCoup().getId() != 0) {
            this.joueurCourant = plateau.getDernierCoup().getId() - 1;
        }
    }

    /**
     * Retourne le plateau de jeu
     *
     * @return Plateau de jeu
     */
    public Plateau getPlateau() {
        return plateau;
    }

    /**
     * Permet d'obtenir le joueur suivant le joueur suivant
     */
    public void joueurSuivant() {
        joueurCourant = 1 - joueurCourant;
    }

    /**
     * Retourne le Joueur courant
     *
     * @return Joueur courant
     */
    public Joueur getJoueurCourant() {
        return this.joueurs[this.joueurCourant];
    }

    /**
     * Permet de jouer la partie
     *
     * @return le joueur gagnant
     */
    public abstract Joueur jouerPartie();


}
