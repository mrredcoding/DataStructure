package TP4.exercice2;

/**
 * La classe RecursivDisplayNumber fournit une méthode récursive pour afficher
 * les nombres de manière incrémentielle à partir d'un nombre initial jusqu'à un nombre final.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class RecursivDisplayNumber {

    /**
     * Affiche les nombres de manière incrémentielle de start à end de manière récursive.
     *
     * @param start Le premier nombre de la séquence.
     * @param end Le dernier nombre de la séquence.
     */
    public static void display(int start, int end) {
        // Cas de base : si start est plus grand que end, arrête la récursion
        if (start > end) {
            return;
        }

        // Affiche le nombre actuel suivi d'un espace
        System.out.print(start + " ");

        // Appel récursif pour afficher le nombre suivant
        display(start + 1, end);
    }
}

