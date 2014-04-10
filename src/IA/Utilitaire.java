package IA;

import java.util.Random;

/**
 * Utilitaire permet de générer 
 * une position alétatoire pour un joueurAleatoire
 * @author TD
 */
public class Utilitaire {
    
    /**
    * Retourne un entier aléatoire
    * @param min valeur minimale du plateau
    * @param max valeur maximale du plateau
    * @return valeur aléatoire
    */  
    public static int monRandom(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
