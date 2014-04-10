
package Plateau;

/**
 * Plateau Gomoku
 * @author Théo Dury
 */
public class PlateauGomoku extends Plateau {

    public PlateauGomoku() {
        super(9, 9);
    }

    public PlateauGomoku(int longueur, int largeur) {
        super(longueur, largeur);
    }

    public boolean checkLineId(Position pos, int id, int n) {
        boolean value = true;
        for (int i = pos.x - n; i < pos.x + n; i++) {
            if (id != this.etatPlateau[i][pos.y]) {
                return false;
            }
        }
        return value;
    }

    public boolean checkColonneId(Position pos, int id, int n) {
        boolean value = true;
        for (int j = pos.y - n; j < pos.y + n; j++) {
            if (id != this.etatPlateau[pos.x][j]) {
                return false;
            }
        }
        return value;
    }
}
