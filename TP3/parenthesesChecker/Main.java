package TP3.parenthesesChecker;

import TP2.stack.EmptyStackExceptions;

/**
 * La classe Main contient la méthode principale pour exécuter le programme de vérification des parenthèses
 * en utilisant la classe BracketChecker.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /**
     * La méthode principale du programme.
     *
     * @param args Les arguments de ligne de commande.
     */
    public static void main(String[] args) {
        // Expression contenant des parenthèses à vérifier
        String expression = "7 - { [ x * [ ( x + y) / (j – 3) ] + y ] / (4 – 2.5) }";

        // Vérification des parenthèses dans l'expression
        BracketChecker checker = new BracketChecker(expression);

        try {
            if (checker.areBracketsNested()) {
                System.out.println("Les parentheses sont correctement imbriquees.");
            } else {
                System.out.println("Les parentheses ne sont pas correctement imbriquees.");
            }
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
