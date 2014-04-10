/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etape1;

/**
 *
 * @author TD
 */
public class PlateauGomoKu extends Plateau {

    public PlateauGomoKu() {
        super(9, 9);
    }

    public PlateauGomoKu(int longueur, int largeur) {
        super(longueur, largeur);
    }

    public boolean verifierLineId(Position pos, int id, int n) {
        boolean value = true;
        for (int i = pos.x - n; i < pos.x + n; i++) {
            if (id != this.etatPlateau[i][pos.y]) {
                return false;
            }
        }
        return value;
    }

    public boolean verifierColoneId(Position pos, int id, int n) {
        boolean value = true;
        for (int j = pos.y - n; j < pos.y + n; j++) {
            if (id != this.etatPlateau[pos.x][j]) {
                return false;
            }
        }
        return value;
    }
}
