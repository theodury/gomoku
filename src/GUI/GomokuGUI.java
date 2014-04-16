package GUI;

import Jeu.JeuDeGomoku;
import Plateau.Coup;
import Plateau.PlateauGomoku;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Interface graphique du Gomoku
 *
 * @author Mario
 */
public class GomokuGUI implements Observer {

    private JFrame frame;
    private GomokuPanel panel;
    private JeuDeGomoku jeu;
    private JLabel message;

    public GomokuGUI(JeuDeGomoku jeu) {
        this.jeu = jeu;
        this.jeu.addObserver(this);

        frame = new JFrame("Gomoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setSize(370, 370);
        
        jeu.jouerPartie();
    }

    private void addComponents() {
        panel = new GomokuPanel((PlateauGomoku) jeu.getPlateau());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Coup coup = panel.getCoup(jeu.getJoueurCourant().getId(), e.getX(), e.getY());
                jeu.getPlateau().jouer(coup);
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }
        });

        message = new JLabel("Bonjour et bienvenue!");
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(panel);
        frame.getContentPane().add(message);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
