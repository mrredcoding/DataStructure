package TP3.calculator;

import TP2.stack.EmptyStackExceptions;
import TP3.parenthesesChecker.BracketChecker;

/**
 * La classe {@code Calculator} fournit des méthodes pour évaluer des expressions mathématiques.
 * Elle utilise d'autres classes telles que {@link TP3.parenthesesChecker.BracketChecker},
 * {@link TP3.calculator.InfixToPostfix}, et {@link TP3.calculator.PostfixEvaluator}
 * pour effectuer les étapes nécessaires dans le processus d'évaluation.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Calculator {

    /**
     * Évalue une expression mathématique et renvoie le résultat.
     * Cette méthode effectue les étapes suivantes :
     * 1. Vérifie si les parenthèses dans l'expression sont correctement imbriquées à l'aide
     * de {@link TP3.parenthesesChecker.BracketChecker}.
     * 2. Convertit l'expression infixée en postfixée à l'aide de {@link TP3.calculator.InfixToPostfix}.
     * 3. Évalue l'expression postfixée à l'aide de {@link TP3.calculator.PostfixEvaluator}.
     *
     * @param expression L'expression mathématique à évaluer.
     * @return Le résultat de l'évaluation de l'expression.
     */
    public static double calculate(String expression) {
        BracketChecker bracketChecker = new BracketChecker(expression);

        try {
            // Étape 1 : Vérifier l'imbrication des parenthèses
            if (!bracketChecker.areBracketsNested())
                throw new EmptyStackExceptions("L'expression : " + expression + " n'est pas correcte.");
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }

        InfixToPostfix infixToPostfix = new InfixToPostfix(expression);

        String postfixExpression = null;
        try {
            // Étape 2 : Convertir l'infixe en postfixe
            postfixExpression = infixToPostfix.toPostfix();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }

        PostfixEvaluator postfixEvaluator = new PostfixEvaluator(postfixExpression);

        try {
            // Étape 3 : Évaluer l'expression postfixe
            return postfixEvaluator.evaluate();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }

        return 0.0;
    }
}

