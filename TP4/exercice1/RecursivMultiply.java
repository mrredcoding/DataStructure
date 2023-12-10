package TP4.exercice1;

/**
 * La classe RecursivMultiply fournit une méthode récursive pour le calcul de la multiplication
 * de deux nombres entiers en utilisant des additions répétées.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class RecursivMultiply {

    /**
     * Calcule le produit de deux nombres entiers de manière récursive.
     *
     * @param a Le premier nombre à multiplier.
     * @param b Le deuxième nombre à multiplier.
     * @return Le produit de a et b.
     */
    public static int calculate(int a, int b) {
        // Cas de base : si l'un des deux nombres est zéro, le produit est zéro
        if (a == 0 || b == 0) {
            return 0;
        }

        // Étape récursive : ajoute a au produit de a et b - 1
        return a + calculate(a, b - 1);
    }
}

