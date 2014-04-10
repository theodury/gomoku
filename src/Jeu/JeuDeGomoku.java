package Jeu;

/**
 *
 * @author Mario
 */
public class JeuDeGomoku {

    public JeuDeGomoku(TypePartie type) {
        switch (type) {
            case HumainVsHumain:
                break;
            case HumainVsAleatoire:
                break;
            case AleatoireVsAleatoire:
                break;
            default:
                throw new AssertionError(type.name());
        }

    }
}
