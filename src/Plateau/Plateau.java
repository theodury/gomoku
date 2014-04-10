
package Plateau;

import java.util.ArrayList;

/**
 *
 * @author Theo Dury
 */
public class Plateau{

    int longueur;
    int hauteur;
    int[][] etatPlateau;
    ArrayList<Coup> historique;

    public Plateau(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.etatPlateau = new int[longueur][hauteur];
        this.historique = new ArrayList<>();
        this.initialiser();
    }

    public int getLongueur() {
        return longueur;
    }

    public int getHauteur() {
        return hauteur;
    }
    
    public boolean isEmpty(int x, int y) {
        return this.etatPlateau[x][y] == 0;
    }

    public final void initialiser() {
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.hauteur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
    }

    public void initialiser(ArrayList<Coup> coup) {
        for (int i = 0; i < coup.size(); i++) {
            this.jouer(coup.get(i));
        }
    }

    public Coup annuler() {
        Coup coupPrecedent = this.historique.get(this.historique.size() - 1);
        this.etatPlateau[coupPrecedent.pos.x][coupPrecedent.pos.y] = 0;
        this.historique.remove(this.historique.size() - 1);
        return coupPrecedent;
    }

    public boolean jouer(Coup coup) {
        if (this.isEmpty(coup.pos.x, coup.pos.y)) {
            this.etatPlateau[coup.pos.x][coup.pos.y] = coup.id;
            this.historique.add(coup);
            
            return true;
        }
        
        return false;
    }

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
