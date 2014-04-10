
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

    /**
     * Vérifie une ligne en fonction d'un joueur
     * @param pos Position à tester
     * @param id Id du joueur
     * @param n Nombre de cases
     * @return Vrai si gagné, faux sinon
     */
    public boolean checkLigneId(Position pos, int id, int n) {
        boolean value = true;
        for (int i = pos.x - n; i < pos.x + n; i++) {
            if (id != this.etatPlateau[i][pos.y]) {
                return false;
            }
        }
        return value;
    }

    /**
     * Vérifie une colonne en fonction d'un joueur
     * @param pos Position à tester
     * @param id Id du joueur
     * @param n Nombre de cases
     * @return Vrai si gagné, faux sinon
     */
    public boolean checkColonneId(Position pos, int id, int n) {
        boolean value = true;
        for (int j = pos.y - n; j < pos.y + n; j++) {
            if (id != this.etatPlateau[pos.x][j]) {
                return false;
            }
        }
        return value;
    }

    /**
     * Retourne le nombre de coups à aligner pour gagner
     * @return Nombre de coups à aligner pour la victoire
     */
    public int getNombreVictoire() {
        return this.longueur / 2;
    }
}
