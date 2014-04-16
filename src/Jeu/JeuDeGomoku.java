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
        PlateauGomoku plateauGomoku = (PlateauGomoku)plateau;
        return plateauGomoku.checkColonneId(plateau.getDernierCoup(), plateauGomoku.getNombreVictoire())
                && plateauGomoku.checkLigneId(plateau.getDernierCoup(), plateauGomoku.getNombreVictoire());
    }

    @Override
    public boolean coupValide(Coup c) {
        return ((PlateauGomoku)plateau).isEmpty(c.pos.x, c.pos.y);
    }
}
