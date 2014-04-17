package gomoku.GUI;

import gomoku.Jeu.JeuDeGomoku;
import gomoku.Joueur.JoueurHumain;
import gomoku.Plateau.Coup;
import gomoku.Plateau.PlateauGomoku;
import java.awt.Component;
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

    static private boolean humainJoue;
    private MouseListener mouseListener;

    public GomokuGUI(JeuDeGomoku jeu) {
        this.jeu = jeu;
        this.jeu.getPlateau().addObserver(this);

        frame = new JFrame("Gomoku");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponents();

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setSize(370, 370);

        jeu.joueurSuivant();
        this.update(null, jeu);
    }

    private void addComponents() {
        panel = new GomokuPanel((PlateauGomoku) jeu.getPlateau());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.mouseListener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (humainJoue) {
                    Coup coup = panel.getCoup(jeu.getJoueurCourant().getId(), e.getX(), e.getY());
                    jeu.getPlateau().jouer(coup);
                }
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }
        };

        panel.addMouseListener(mouseListener);
        message = new JLabel("Bienvenue sur un super Gomoku!");
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(panel);
        frame.getContentPane().add(message);
    }

    @Override
    public void update(Observable o, Object arg) {
        // On vérifie si la partie est terminée
        if (jeu.partieTerminee()) {
            message.setText("Joueur " + jeu.getJoueurCourant().getId() + " gagne!");
            jeu.getPlateau().deleteObserver(this);
            this.panel.removeMouseListener(mouseListener);
        } else {
            // Passer au joueur suivant
            jeu.joueurSuivant();
            message.setText("Tour du joueur " + jeu.getJoueurCourant().getId());

            humainJoue = (jeu.getJoueurCourant() instanceof JoueurHumain);
            if (!humainJoue) {
                // Stop listeners
                jeu.getPlateau().deleteObserver(this);
                // Trouver le coup de l'ordinateur
                Coup c = jeu.getJoueurCourant().genererCoup(jeu.getPlateau());
                // Start listeners
                this.jeu.getPlateau().addObserver(this);
                if (jeu.coupValide(c)) {
                    jeu.getPlateau().jouer(c);
                } else {
                    // On change de joueur pour pouvoir rejouer
                    jeu.joueurSuivant();
                }
                
            }
        }
    }

}
