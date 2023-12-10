package TP4.exercice3;
/**
 * La classe Main est la classe principale qui contient la méthode main
 * pour exécuter le programme de résolution récursive du problème des Tours de Hanoï.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {
    /**
     * La méthode main est la méthode d'entrée principale du programme.
     * Elle démontre l'utilisation de la classe RecursiveHanoiTower pour
     * résoudre le problème des Tours de Hanoï de manière récursive.
     *
     * @param args Les arguments de ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {
        int n = 3;

        System.out.println("To resolve the hanoi towers problem with " + n + " disks," +
                " you should consider the following steps : ");
        RecursiveHanoiTower.towers(n, 'A', 'C', 'B');
    }
}
