
package IA;

import Plateau.Coup;
import Plateau.Position;
import java.util.ArrayList;

/**
 * Noeud utilisé pour Monte Carlo
 * @author Mario
 */
public class Noeud {

    
        private int nbVictoire;
        private int nbSimulation;
        private Coup coup;
        /**
         * Constructeur de noeud
         * @param coup 
         */             
        public Noeud(Coup coup)
        {
        this.coup=coup;
        }

        public double getMoyenne()
        {
        
            return 10;
        }
        
        public Coup getCoup(){
            Noeud meilleurCoup = null;
            ArrayList<Position> positionPossible =  etatJeu.getEtat
            return Coup;
        }

        
        public void ajouteurVictoire(){
            
        }
        
        public void ajouteurDefaite(){
            
        }
}
