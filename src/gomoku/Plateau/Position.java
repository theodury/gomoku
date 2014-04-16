
package gomoku.Plateau;

/**
 * Position en fonction de la hauteur et la longueur du plateau
 * @author TD
 */
public class Position {
    
    public int x;
    public int y;

    /**
     * Construteur de position
     * @param x valeur de la longueur
     * @param y valeur de la hauteur
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
 
    
    /**
     * Affiche la position de x et y
     * @return Retourne une chaine de caratere avec la position de x et y 
     */
    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }

  
    
}
