
package Etape1;

/**
 * Coup
 * @author Théo Dury
 */
public class Coup {
    
    int id;
    Position pos;

    public Coup(int id, Position pos) {
        this.id=id;
        this.pos=pos;
    }

    @Override
    public String toString() {
        return "Coup{" + "id=" + id + '}';
    }
    
    
}
