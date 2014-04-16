package gomoku.Plateau;

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
        int nombre = 0;
        int y = coup.pos.y;
        int xStart = Math.max(0, coup.pos.x - n);
        int xEnd = Math.min(longueur - 1, coup.pos.x + n);
        for (int i = xStart; (i < xEnd) && nombre < n; i++) {
            nombre = etatPlateau[i][y] == coup.getId() ? nombre + 1 : 0;
        }
        return nombre == this.getNombreVictoire();
    }

    /**
     * Vérifie une colonne en fonction d'un joueur
     *
     * @param coup Coup joué
     * @param n Nombre de cases
     * @return Vrai si gagné, faux sinon
     */
    public boolean checkColonneId(Coup coup, int n) {
       
        int nombre = 0;
        int x = coup.pos.x;
        int yStart = Math.max(0, coup.pos.y - n);
        int yEnd = Math.min(hauteur - 1, coup.pos.y + n);

        for (int i = yStart; (i < yEnd) && nombre < n; i++) {
            nombre = etatPlateau[x][i] == coup.getId() ? nombre + 1 : 0;
        }
        return nombre == this.getNombreVictoire();
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
