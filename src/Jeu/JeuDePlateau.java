package Jeu;

import Joueur.Joueur;
import Plateau.Coup;
import Plateau.Plateau;
import Plateau.PlateauGomoku;

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
     * @return Vrai si partie finie, faux sinon
     */
    public abstract boolean partieTerminee();

    /**
     * Verifie si le coup est valide
     * @param coup Coup à jouer
     * @return Vrai si valide, faux sinon
     */
    public abstract boolean coupValide(Coup coup);

    /**
     * Permet de modifier les valeurs d'un des joueurs
     * @param ordre position du joueur
     * @param joueur Joueur
     */
    public void setJoueur(int ordre, Joueur joueur) {
        this.joueurs[ordre] = joueur;
    }

    /**
     * Permet de modifier la valeurs du plateau
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
     * Permet d'obtenir le joueur suivant le joueur suivant
     */
    protected void joueurSuivant() {
        joueurCourant = 1 - joueurCourant;
    }

    /**
     * Permet de jouer la partie
     * @return le joueur gagnant
     */
    public Joueur jouerPartie() {
        while (!this.partieTerminee()) {
            Coup c = joueurs[joueurCourant].genererCoup(plateau);
            if (coupValide(c)) {
                plateau.jouer(c);
            } else {
                // On change de joueur pour pouvoir rejouer
                this.joueurSuivant();
            }
            // On change de joueur
            this.joueurSuivant();
        }

        return joueurs[joueurCourant];
    }

}
