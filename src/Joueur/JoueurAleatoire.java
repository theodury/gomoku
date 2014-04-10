
package Joueur;

import IA.Utilitaire;
import Plateau.Coup;
import Plateau.Plateau;
import Plateau.Position;
import java.util.ArrayList;

/**
 * Joueur aléatoire
 * @author Mario
 */
public class JoueurAleatoire extends Joueur {

    public JoueurAleatoire(int id) {
        super(id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        ArrayList<Coup> coupsDisponibles = new ArrayList<>();
        for (int i = 0; i < etatJeu.getLongueur(); i++) {
            for (int j = 0; j < etatJeu.getHauteur(); j++) {
                if (etatJeu.isEmpty(i, j)) {
                    coupsDisponibles.add(new Coup(id, new Position(i, j)));
                }
            }
        }
        
        return coupsDisponibles.get(Utilitaire.monRandom(0, coupsDisponibles.size()));
    }

}
