package TP4.exercice4;

import java.util.Scanner;

/**
 * La classe Main est la classe principale qui contient la méthode main
 * pour exécuter le programme de validation d'expressions algébriques.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /**
     * La méthode main est la méthode d'entrée principale du programme.
     * Elle permet à l'utilisateur de saisir une expression algébrique,
     * puis utilise la classe RecursiveExpressionIsValid pour valider
     * la syntaxe de cette expression.
     *
     * @param args Les arguments de ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir une expression algébrique
        System.out.println("Veuillez entrer une expression algébrique :");
        String expression = scanner.nextLine();

        // Valider l'expression à l'aide de la classe RecursiveExpressionIsValid
        boolean isValid = RecursiveExpressionIsValid.validate(expression);

        // Afficher le résultat de la validation
        System.out.print(expression + " est ");
        System.out.println(isValid ? "valide" : "non valide");
    }
}
