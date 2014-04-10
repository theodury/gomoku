
package Plateau;

/**
 * Simulateur de jeu
 * @author Théo Dury
 */
public class SimulateurDeJeu {
    
     /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        PlateauGomoku plateau = new PlateauGomoku();
        System.out.println(plateau.toString());
        
    }
}
