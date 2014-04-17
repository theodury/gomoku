/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku.Joueur;

import gomoku.IA.Noeud;
import gomoku.Jeu.JeuDeGomoku;
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

    /**
     * Constructeur du MontCarlo
     * @param id identifiant 
     * @param nbSimulation nbSimulation
     * @param factory JeuDePlateau
     */
    public JoueurMonteCarlo(int id, int nbSimulation, JeuDePlateauFactory factory) {
        super(id);
        this.nbSimulation = nbSimulation;
        this.factory = factory;
    }

    /**
     * Cherche le meilleur coup à jouer
     *
     * @param etatJeu Plateau du jeu
     * @return meilleur coup
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionPossible = etatJeu.etatId(0);
        for (Position p : positionPossible) {
            Coup cCourant = new Coup(id, p);
            Noeud nCourant = new Noeud(cCourant);
            nCourant.setNbSimulation(this.nbSimulation);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();

            for (int i = 0; i < nbSimulation; i++) {
                JeuDeGomoku jeu = (JeuDeGomoku) factory.CreerPartieAleatoireVSAleatoire(sit);
                Joueur JoueurGagnant = jeu.jouerPartie();
                if (JoueurGagnant.getId() == this.id) {
                    nCourant.ajouterVictoire(jeu.getPlateau().getHistorique().size());
                } else if (JoueurGagnant.getId() != 0) {
                    nCourant.ajouterDefaite(jeu.getPlateau().getHistorique().size());
                }
            }
            if (meilleurCoup == null || meilleurCoup.getMoyenne() > nCourant.getMoyenne()) {
                meilleurCoup = nCourant;
            }
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }

}
