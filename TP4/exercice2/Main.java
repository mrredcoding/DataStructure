package TP4.exercice2;

/**
 * La classe Main est la classe principale qui contient la méthode main
 * pour exécuter le programme d'affichage récursif de nombres.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /**
     * La méthode main est la méthode d'entrée principale du programme.
     * Elle démontre l'utilisation de la classe RecursivDisplayNumber pour
     * afficher les nombres de manière incrémentielle de start à stop.
     *
     * @param args Les arguments de ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {
        // Définir les valeurs de début et de fin pour l'affichage
        int start = 1;
        int stop = 30;

        // Afficher la liste des nombres à l'aide de la classe RecursivDisplayNumber
        System.out.println("Voici la liste des " + stop + " premiers nombres :");
        RecursivDisplayNumber.display(start, stop);
    }
}

