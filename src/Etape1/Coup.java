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
public class Coup {
    
    int id;
    Position pos;

    public Coup(int id) {
        this.id=id;
        this.pos=pos;
    }

    @Override
    public String toString() {
        return "Coup{" + "id=" + id + '}';
    }
    
    
}
