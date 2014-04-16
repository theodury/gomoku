
package gomoku.Jeu;

import gomoku.Plateau.Coup;
import java.util.ArrayList;

/**
 * Fabrique pour contrôler la création de parties
 * @author Mario
 */
public interface JeuDePlateauFactory {
    
    /**
     * Créé une partie humain contre humain
     * @param situation Situation initiale
     * @return Le jeu initialisé
     */
    JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation);
    
    /**
     * Créé une partie humain contre humain
     * @return Le jeu initialisé
     */
    JeuDePlateau CreerPartieHumainVSHumain();
    
    /**
     * Créé une partie humain contre aleatoire
     * @param situation Situation initiale
     * @return Le jeu initialisé
     */
    JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation);
    
    /**
     * Créé une partie humain contre aleatoire
     * @return Le jeu initialisé
     */
    JeuDePlateau CreerPartieHumainVSAleatoire();
    
    /**
     * Créé une partie aleatoire contre aleatoire
     * @param situation Situation initiale
     * @return Le jeu initialisé
     */
    JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation);
    
    /**
     * Créé une partie aleatoire contre aleatoire
     * @return Le jeu initialisé
     */
    JeuDePlateau CreerPartieAleatoireVSAleatoire();
    
}
