package TP4.exercice5;

import TP2.stack.EmptyStackExceptions;

import java.util.Scanner;

/**
 * La classe Main est la classe principale qui contient la méthode main
 * pour exécuter le programme de transformation d'expressions préfixes en postfixes.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /**
     * La méthode main est la méthode d'entrée principale du programme.
     * Elle permet à l'utilisateur de saisir une expression préfixe,
     * puis utilise la classe PrefixToPostfix pour transformer cette expression
     * en une expression postfixe et l'affiche à l'écran.
     *
     * @param args Les arguments de ligne de commande (non utilisés dans cet exemple).
     * @throws EmptyStackExceptions Si la pile est vide lors de la transformation.
     */
    public static void main(String[] args) throws EmptyStackExceptions {
        // Créer un objet Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir une expression préfixe
        System.out.println("Veuillez entrer une expression préfixe :");
        String prefix = scanner.nextLine();

        // Transformer l'expression préfixe en expression postfixe
        String postfix = PrefixToPostfix.transform(prefix);

        // Afficher l'expression postfixe résultante
        System.out.println("Expression postfixe : " + postfix);
    }
}

