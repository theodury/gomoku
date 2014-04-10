package Jeu;

import Joueur.Joueur;
import Plateau.Coup;
import Plateau.Plateau;
import Plateau.PlateauGomoku;
import java.util.ArrayList;

/**
 * Permet de génerer une partie de Gomoku en fonction du type de la partie
 *
 * @author Mario
 */
public class JeuDeGomoku {

    /**
     * Tableau de joueurs pour la partie
     */
    private Joueur[] joueurs;
    private PlateauGomoku plateau;
    private int joueurCourant;
    private int taillePlateau;
    private int taillePourGagner;

    /**
     * Permet de générer une partie de Gomoku
     *
     * @param type type de la partie ( HumainVsAleatoire, ...)
     */
    public JeuDeGomoku(TypePartie type) {

        joueurCourant = 0;
        joueurs = new Joueur[2];
        taillePlateau = 10;
        setTaillePourGagner();

        switch (type) {
            case HumainVsHumain:
                break;
            case HumainVsAleatoire:
                break;
            case AleatoireVsAleatoire:
                break;
            default:
                throw new AssertionError(type.name());
        }
    }

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
    }

    /**
     * Permet de définir la valeurs des coups à aligner pour gagner
     */
    public void setTaillePourGagner() {
        this.taillePourGagner = taillePlateau / 2;
    }

    /**
     * Permet d'obtenir le joueur suivant
     *
     * @return le joueur suivant
     */
    private int joueurSuivant() {
        return joueurCourant = (joueurCourant == 0) ? 1 : 0;
    }

    /**
     * Permet de voir si la partie est terminer
     * @return 1 pour partie terminee, 0 pour partie en cour
     */
    public boolean partieTerminee() {
        return plateau.checkColonneId(plateau.getDernierCoup().pos, joueurCourant, taillePourGagner)
                && plateau.checkLigneId(plateau.getDernierCoup().pos, joueurCourant, taillePourGagner);
    }

    public boolean coupValide(Coup c) {
        return plateau.isEmpty(c.pos.x, c.pos.y);
    }

    public Joueur jouerPartie() {
        while (!this.partieTerminee()) {
            joueurCourant = this.joueurSuivant();
            Coup c = joueurs[joueurCourant].genererCoup(plateau);
            if (coupValide(c)) {
                plateau.jouer(c);
            } else {
                // gestion en cas de coup non valide
            }
        }
        return joueurs[joueurCourant];
    }
}
