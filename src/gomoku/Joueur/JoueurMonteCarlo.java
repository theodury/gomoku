/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku.Joueur;

import gomoku.IA.Noeud;
import gomoku.Jeu.JeuDePlateauFactory;
import gomoku.Plateau.Coup;
import gomoku.Plateau.Plateau;
import gomoku.Plateau.Position;
import java.util.ArrayList;

/**
 *
 * @author TD
 */
public class JoueurMonteCarlo extends Joueur {

    private int nbSimulation;

    private JeuDePlateauFactory factory;
    
    public JoueurMonteCarlo(int id, int nbSimulation, JeuDePlateauFactory factory) {
        super(id);
        this.nbSimulation = nbSimulation;
        this.factory = factory;
    }

    /**
     * Cherche le meilleur coup à jouer
     *
     * @return meilleur coup
     */
    public Coup getCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionPossible = etatJeu.etatId(0);
        for (Position p : positionPossible) {
            Coup cCourant = new Coup(id, p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();

            
            
            if (meilleurCoup == null || meilleurCoup.getMoyenne() < nCourant.getMoyenne()) {
                meilleurCoup = nCourant;
            }
        }
        return meilleurCoup.getCoup();
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        return null;
    }

}
