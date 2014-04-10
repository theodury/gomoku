
package Joueur;

import Plateau.Coup;
import Plateau.Plateau;
import Plateau.Position;
import java.util.Scanner;

/**
 * Joueur humain
 * @author Mario
 */
public class JoueurHumain extends Joueur{

    public JoueurHumain(int id) {
        super(id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Scanner sc = new Scanner(System.in);
        int x, y;
        do {
            System.out.print("Entrez la colonne: ");
            x = sc.nextInt();
            System.out.print("Entrez la ligne: ");
            y = sc.nextInt();
        } while (!etatJeu.isEmpty(x, y));
                
        return new Coup(this.id, new Position(x, y));
    }
    
    

}
