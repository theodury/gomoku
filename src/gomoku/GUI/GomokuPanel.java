package gomoku.GUI;

import gomoku.Plateau.Coup;
import gomoku.Plateau.PlateauGomoku;
import gomoku.Plateau.Position;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * Plateau de jeu du Gomoku
 *
 * @author Mario
 */
public class GomokuPanel extends JPanel implements Observer {

    private final int UNIT_SIZE = 20;
    private PlateauGomoku plateau;

    public GomokuPanel(PlateauGomoku plateau) {
        this.plateau = plateau;
        this.plateau.addObserver(this);

        Dimension d = new Dimension(plateau.getLongueur() * UNIT_SIZE + 1, plateau.getHauteur() * UNIT_SIZE + 1);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setBackground(Color.WHITE);
    }
    
    public Coup getCoup(int id, int x, int y) {
        return new Coup(id, new Position(x / UNIT_SIZE, y / UNIT_SIZE));
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessin des cellules
        for (int i = 0; i < plateau.getLongueur(); i++) {
            for (int j = 0; j < plateau.getHauteur(); j++) {
                g.drawRect(i * UNIT_SIZE, j * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                if (plateau.getId(i, j) == 1) {
                    g.drawLine(i * UNIT_SIZE, j * UNIT_SIZE, (i + 1) * UNIT_SIZE, (j + 1) * UNIT_SIZE);
                    g.drawLine((i + 1) * UNIT_SIZE, j * UNIT_SIZE, i * UNIT_SIZE, (j + 1) * UNIT_SIZE);
                } else if (plateau.getId(i, j) == 2) {
                    g.fillOval(i * UNIT_SIZE, j * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
    }

}
