package gomoku.Plateau;

/**
 * Coup
 *
 * @author Théo Dury
 */
public class Coup implements Cloneable {

    /**
     * L'id du joueur qui a placé le coup
     */
    int id;

    /**
     * Position à laquelle le coup est joué
     */
    public Position pos;

    public Coup(int id, Position pos) {
        this.id = id;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Coup{" + "id=" + id + '}';
    }

    /**
     * Permet de cloner un coup
     */
    public Object clone() {
        Coup coup = new Coup(this.id, (Position) pos.clone());
        return coup;
    }
}
