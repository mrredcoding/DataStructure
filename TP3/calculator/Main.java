package TP3.calculator;

import TP2.stack.EmptyStackExceptions;

/**
 * La classe Main contient la méthode principale pour exécuter le programme de calculatrice en utilisant les classes
 * InfixToPostfix et PostfixEvaluator.
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
        // Expression infixée à évaluer
        String infixExpression = "( 2 + 3 ) * ( 6 - 2 )";
        InfixToPostfix infixToPostfix = new InfixToPostfix(infixExpression);

        // Conversion de l'expression infixée en notation postfixée
        String postfixExpression = null;
        try {
            postfixExpression = infixToPostfix.toPostfix();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }

        // Affichage des expressions
        System.out.println("Expression infixée : " + infixExpression);
        System.out.println("Expression postfixée : " + postfixExpression);

        // Évaluation de l'expression postfixée
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator(postfixExpression);

        double result = 0;
        try {
            result = postfixEvaluator.evaluate();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Résultat: " + result);

        System.out.println("Résultat calculé avec le calculator : " + Calculator.calculate(infixExpression));
    }
}
