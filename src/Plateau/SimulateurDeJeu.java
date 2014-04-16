
package Plateau;

import GUI.GomokuGUI;
import Jeu.JeuDeGomoku;
import Jeu.JeuDeGomokuFactory;

/**
 * Simulateur de jeu
 * @author Théo Dury
 */
public class SimulateurDeJeu {
    
     /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        JeuDeGomokuFactory factory  = new JeuDeGomokuFactory();
        JeuDeGomoku jeu = (JeuDeGomoku)factory.CreerPartieHumainVSHumain(null);
        
        GomokuGUI gui = new GomokuGUI(jeu);
        
    }
}
