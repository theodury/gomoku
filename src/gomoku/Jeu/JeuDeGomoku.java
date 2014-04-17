package gomoku.Jeu;

import gomoku.Joueur.Joueur;
import gomoku.Plateau.Coup;
import gomoku.Plateau.PlateauGomoku;

/**
 * Permet de génerer une partie de Gomoku en fonction du type de la partie
 *
 * @author Mario
 */
public class JeuDeGomoku extends JeuDePlateau {

    /**
     * Nombre de coups a aligner pour gagner
     */
    private int taillePourGagner;

    /**
     * Permet de générer une partie de Gomoku
     */
    public JeuDeGomoku() {
        joueurCourant = 0;
        joueurs = new Joueur[2];
    }

    @Override
    public boolean partieTerminee() {
        Coup c = plateau.getDernierCoup();
        if (c.getId() == 0) {
            return false;
        }
        PlateauGomoku plateauGomoku = (PlateauGomoku) plateau;
        return plateauGomoku.checkColonneId(c, plateauGomoku.getNombreVictoire())
                || plateauGomoku.checkLigneId(c, plateauGomoku.getNombreVictoire())
                || plateauGomoku.checkCroix(c, plateauGomoku.getNombreVictoire());
    }

    @Override
    public boolean coupValide(Coup c) {
        return ((PlateauGomoku) plateau).isEmpty(c.pos.x, c.pos.y);
    }

    @Override
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
