
package gomoku.Jeu;

import gomoku.Joueur.JoueurAleatoire;
import gomoku.Joueur.JoueurHumain;
import gomoku.Plateau.Coup;
import gomoku.Plateau.PlateauGomoku;
import java.util.ArrayList;

/**
 * Fabrique pour contrôler le jeu de Gomoku
 * @author Mario
 */
public class JeuDeGomokuFactory implements JeuDePlateauFactory{
    
    /**
     * Hauteur par défaut du plateau
     */
    static final int HAUTEUR = 9;
    
    /**
     * Longueur par défaut du plateau
     */
    static final int LONGUEUR = 9;
    
    /**
     * Identifiant du 1er joueur
     */
    static final int JOUEUR1 = 1;
    
    /**
     * Identifiant du 2eme joueur
     */
    static final int JOUEUR2 = 2;

    @Override
    public JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        JeuDeGomoku jeu = new JeuDeGomoku();
        // Joueur 1
        jeu.setJoueur(0, new JoueurHumain(JOUEUR1));
        // Joueur 2
        jeu.setJoueur(1, new JoueurHumain(JOUEUR2));
        // Plateau
        PlateauGomoku plateau = new PlateauGomoku(LONGUEUR, HAUTEUR);
        if (situation != null) {
            plateau.initialiser(situation);
        }
        jeu.setPlateau(plateau);
        
        return jeu;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        JeuDeGomoku jeu = new JeuDeGomoku();
        // Joueur 1
        jeu.setJoueur(0, new JoueurHumain(JOUEUR1));
        // Joueur 2
        jeu.setJoueur(1, new JoueurAleatoire(JOUEUR2));
        // Plateau
        PlateauGomoku plateau = new PlateauGomoku(LONGUEUR, HAUTEUR);
        if (situation != null) {
            plateau.initialiser(situation);
        }
        jeu.setPlateau(plateau);
        
        return jeu;
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        JeuDeGomoku jeu = new JeuDeGomoku();
        // Joueur 1
        jeu.setJoueur(0, new JoueurAleatoire(JOUEUR1));
        // Joueur 2
        jeu.setJoueur(1, new JoueurAleatoire(JOUEUR2));
        // Plateau
        PlateauGomoku plateau = new PlateauGomoku(LONGUEUR, HAUTEUR);
        if (situation != null) {
            plateau.initialiser(situation);
        }
        jeu.setPlateau(plateau);
        
        return jeu;
    }
    
    public JeuDePlateau CreerPartieMonteCarloVSAleatoire(ArrayList<Coup> situation) {
        JeuDeGomoku jeu = new JeuDeGomoku();
        // Joueur 1
        jeu.setJoueur(0, new JoueurMonteCarlo(JOUEUR1));
        // Joueur 2
        jeu.setJoueur(1, new JoueurAleatoire(JOUEUR2));
        // Plateau
        PlateauGomoku plateau = new PlateauGomoku(LONGUEUR, HAUTEUR);
        if (situation != null) {
            plateau.initialiser(situation);
        }
        jeu.setPlateau(plateau);
        
        return jeu;
    }
    
    public JeuDePlateau CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation) {
        JeuDeGomoku jeu = new JeuDeGomoku();
        // Joueur 1
        jeu.setJoueur(0, new JoueurHumain(JOUEUR1));
        // Joueur 2
        jeu.setJoueur(1, new JoueurMonteCarlo(JOUEUR2));
        // Plateau
        PlateauGomoku plateau = new PlateauGomoku(LONGUEUR, HAUTEUR);
        if (situation != null) {
            plateau.initialiser(situation);
        }
        jeu.setPlateau(plateau);
        
        return jeu;
    }
    
    public JeuDePlateau CreerPartieHumainVSHumain() {
        return CreerPartieHumainVSMonteCarlo(null);
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSHumain() {
        return CreerPartieHumainVSHumain(null);
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire() {
        return CreerPartieHumainVSAleatoire(null);
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire() {
        return CreerPartieAleatoireVSAleatoire(null);
    }
    
    
    
}
