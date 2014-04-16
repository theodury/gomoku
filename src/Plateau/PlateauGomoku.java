package Plateau;

/**
 * Plateau Gomoku
 *
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
     *
     * @param coup Coup joué
     * @param n Nombre de cases
     * @return Vrai si gagné, faux sinon
     */
    public boolean checkLigneId(Coup coup, int n) {
        if (coup != null) {
            int x = coup.pos.x;
            int y = coup.pos.y;
            int _x = x;
            int id = coup.id;
            int i = 0;
            int x_end = x + n;
            while (x <= longueur && y < x_end && etatPlateau[x - 1][y - 1] == id) {
                i = i + 1;
                x++;
            }
            x_end = _x - n;
            i = i - 1;
            while (_x > 0 && _x > x_end && etatPlateau[_x - 1][y - 1] == id) {
                i = i + 1;
                _x--;
            }
            return i >= n;
        }
        return false;
    }

    /**
     * Vérifie une colonne en fonction d'un joueur
     *
     * @param coup Coup joué
     * @param n Nombre de cases
     * @return Vrai si gagné, faux sinon
     */
    public boolean checkColonneId(Coup coup, int n) {
        if (coup != null) {
            int x = coup.pos.x;
            int y = coup.pos.y;
            int _y = y;
            int id = coup.id;
            int i = 0;
            int y_end = y + n;
            while (y <= hauteur && y < y_end && etatPlateau[x - 1][y - 1] == id) {
                i = i + 1;
                y++;
            }
            y_end = _y - n;
            i = i - 1;
            while (_y > 0 && _y > y_end && etatPlateau[x - 1][_y - 1] == id) {
                i = i + 1;
                _y--;
            }
            return i >= n;
        }
        return false;
    }

    /**
     * Retourne le nombre de coups à aligner pour gagner
     *
     * @return Nombre de coups à aligner pour la victoire
     */
    public int getNombreVictoire() {
        return this.longueur / 2;
    }
}
