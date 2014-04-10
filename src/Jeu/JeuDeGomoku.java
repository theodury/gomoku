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
    /**
     * plateau de gomoku
     */
    private PlateauGomoku plateau;
    
    /**
     * joueurCourant en cour
     */
    private int joueurCourant;
    
    /**
     * taille du plateau
     */
    private int taillePlateau;
    
    /**
     * nombre de coup a aligner pour gagner
     */
    private int taillePourGagner;

    /**
     * Permet de générer une partie de Gomoku
     *
     * @param type type de la partie ( HumainVsAleatoire, ...)
     */
    public JeuDeGomoku() {
        joueurCourant = 0;
        joueurs = new Joueur[2];
        taillePlateau = 10;
        setTaillePourGagner();
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
     * le joueur suivant
     */
    private void joueurSuivant() {
        joueurCourant = 1-joueurCourant;
    }

    /**
     * Permet de voir si la partie est terminer
     * @return 1 pour partie terminee, 0 pour partie en cour
     */
    public boolean partieTerminee() {
        return plateau.checkColonneId(plateau.getDernierCoup().pos, joueurCourant, taillePourGagner)
                && plateau.checkLigneId(plateau.getDernierCoup().pos, joueurCourant, taillePourGagner);
    }

    /**
     * Verifie si le coup est valide
     * @param c Coup à vérifier
     * @return 0 si coup non valide 1 si coup valide
     */
    public boolean coupValide(Coup c) {
        return plateau.isEmpty(c.pos.x, c.pos.y);
    }

    /**
     * Permet de jouer la partie 
     * @return le joueur gagnant 
     */
    public Joueur jouerPartie() {
        while (!this.partieTerminee()) {
            this.joueurSuivant();
            Coup c = joueurs[joueurCourant].genererCoup(plateau);
            if (coupValide(c)) {
                plateau.jouer(c);
            } else {
               // On change de joueur pour pouvoir rejouer
               this.joueurSuivant();
            }
        }
        return joueurs[joueurCourant];
    }
}
