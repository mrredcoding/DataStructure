package TP4.exercice3;

/**
 * La classe RecursiveHanoiTower fournit une méthode récursive pour résoudre le problème
 * classique des Tours de Hanoï, qui consiste à déplacer une tour de disques d'une pile
 * source vers une pile cible, en utilisant une pile auxiliaire comme support.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class RecursiveHanoiTower {

    /**
     * Résout le problème des Tours de Hanoï de manière récursive.
     *
     * @param n Le nombre de disques dans la tour.
     * @param frompeg La pile source.
     * @param topeg La pile cible.
     * @param auxpeg La pile auxiliaire.
     */
    public static void towers(int n, char frompeg, char topeg, char auxpeg) {
        // Cas de base : s'il n'y a qu'un seul disque, déplace directement vers la pile cible
        if (n == 1) {
            System.out.println("Move disk 1 from " + frompeg + " to " + topeg);
            return;
        }

        // Déplace n-1 disques de la pile source à la pile auxiliaire
        towers(n - 1, frompeg, auxpeg, topeg);

        // Déplace le disque n de la pile source à la pile cible
        System.out.println("Move disk " + n + " from " + frompeg + " to " + topeg);

        // Déplace n-1 disques de la pile auxiliaire à la pile cible
        towers(n - 1, auxpeg, topeg, frompeg);
    }
}


