package TP4.exercice1;

/**
 * La classe Main est la classe principale qui contient la méthode main
 * pour exécuter le programme de multiplication récursive.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /**
     * La méthode main est la méthode d'entrée principale du programme.
     * Elle démontre l'utilisation de la classe RecursivMultiply pour
     * calculer le produit de deux nombres entiers de manière récursive.
     *
     * @param args Les arguments de ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {
        // Définir les valeurs des nombres à multiplier
        int a = 4;
        int b = 7;

        // Calculer le produit à l'aide de la classe RecursivMultiply
        int res = RecursivMultiply.calculate(a, b);

        // Afficher le résultat
        System.out.println("La multiplication de " + a + " par " + b + " est " + res);
    }
}
