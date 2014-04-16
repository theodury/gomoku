
package Plateau;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Plateau de jeu
 * @author Theo Dury
 */
public class Plateau extends Observable {

    /**
     * Longueur du plateau de jeu
     */
    int longueur;
    
    /**
     * Hauteur du plateau de jeu
     */
    int hauteur;
    
    /**
     * Valeurs internes du plateau de jeu
     */
    int[][] etatPlateau;
    
    /**
     * Historique des coups joués sur le plateau
     */
    ArrayList<Coup> historique;

    public Plateau(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.etatPlateau = new int[longueur][hauteur];
        this.historique = new ArrayList<>();
        this.initialiser();
    }

    /**
     * Retourne la longueur du plateau
     * @return Longueur du plateau
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * Retourne la hauteur du plateau
     * @return Hauteur du plateau
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Retourne le dernier coup joué
     * @return Dernier coup joué ou Coup(0) si aucun coup joué
     */
    public Coup getDernierCoup() {
        if (historique.size() > 0) {
            return historique.get(historique.size()-1);
        }
        
        return new Coup(0, new Position(0, 0));
    }
    
    /**
     * Retourne l'id du joueur pour une certaine position
     * @param x Position en x
     * @param y Position en y
     * @return L'id du joueur
     */
    public int getId(int x, int y) {
        return this.etatPlateau[x][y];
    }
    
    /**
     * Teste si une case du plateau est vide
     * @param x Position en x 
     * @param y Position en y
     * @return Vrai si la case est vide, sinon faux
     */
    public boolean isEmpty(int x, int y) {
        return this.etatPlateau[x][y] == 0;
    }

    /**
     * Permet d'initialiser le plateau
     */
    public final void initialiser() {
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.hauteur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
    }
    
    /**
     * Permet d'initialiser le plateau avec des coups déjà existants
     * @param coups Coups précédents 
     */
    public void initialiser(ArrayList<Coup> coups) {
        if (coups == null) {
            return;
        }
        
        for (int i = 0; i < coups.size(); i++) {
            this.jouer(coups.get(i));
        }
    }

    /**
     * Annule le coup précédent
     * @return Le coup annulé
     */
    public Coup annuler() {
        Coup coupPrecedent = this.historique.get(this.historique.size() - 1);
        this.etatPlateau[coupPrecedent.pos.x][coupPrecedent.pos.y] = 0;
        this.historique.remove(this.historique.size() - 1);
        return coupPrecedent;
    }

    /**
     * Joue un coup
     * @param coup Le coup à jouer
     * @return Vrai si coup bien joué, faux sinon
     */
    public boolean jouer(Coup coup) {
        if (this.isEmpty(coup.pos.x, coup.pos.y)) {
            this.etatPlateau[coup.pos.x][coup.pos.y] = coup.id;
            this.historique.add(coup);
            
            return true;
        }
        
        return false;
    }

    /**
     * Retourne les positions joués par un joueur
     * @param id L'id du joueur
     * @return Liste des position du joueur
     */
    public ArrayList<Position> etatId(int id) {
        ArrayList<Position> ListPos = new ArrayList<>();
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.hauteur; j++) {
                if (this.etatPlateau[i][j] == id) {
                    Position pos = new Position(i, j);
                    ListPos.add(pos);
                }
            }

        }
        return ListPos;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(" _ _ _ _ _ _\n");
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.hauteur; j++) {
                builder.append('|');
                builder.append("_");
                builder.append(this.etatPlateau[i][j]);
                builder.append("_");
            }
            builder.append('|');
            builder.append('\n');
        }

        return builder.toString();
    }
}
