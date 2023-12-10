package TP4.exercice5;
import TP2.stack.EmptyStackExceptions;
import TP2.staticStack.StaticStack;

/**
 * La classe PrefixToPostfix fournit une méthode pour transformer une expression préfixe
 * en une expression postfixe à l'aide d'une pile statique.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class PrefixToPostfix {

    /**
     * La pile statique utilisée pour stocker les opérandes lors de la transformation.
     */
    private static StaticStack<String> stack;

    /**
     * Transforme une expression préfixe en une expression postfixe.
     *
     * @param prefix L'expression préfixe à transformer.
     * @return L'expression postfixe résultante.
     * @throws EmptyStackExceptions Si la pile est vide lors de la transformation.
     */
    public static String transform(String prefix) throws EmptyStackExceptions {
        stack = new StaticStack<>(prefix.length());
        recursiveTransform(prefix);
        return stack.pop();
    }

    /**
     * Méthode récursive pour transformer une expression préfixe en une expression postfixe.
     *
     * @param prefix L'expression préfixe à transformer.
     * @return La sous-expression préfixe résultante.
     * @throws EmptyStackExceptions Si la pile est vide lors de la transformation.
     */
    private static String recursiveTransform(String prefix) throws EmptyStackExceptions {
        if (prefix.isEmpty()) {
            return "";
        }

        char c = prefix.charAt(0);

        if (isOperator(c)) {
            String op1 = recursiveTransform(prefix.substring(1));
            String op2 = recursiveTransform(op1);
            String operand1 = stack.pop();
            String operand2 = stack.pop();
            String newOperand = operand2 + operand1 + c;
            stack.push(newOperand);
            return op2;
        } else {
            stack.push(Character.toString(c));
            return prefix.substring(1);
        }
    }

    /**
     * Vérifie si un caractère est un opérateur.
     *
     * @param c Le caractère à vérifier.
     * @return true si c'est un opérateur, sinon false.
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
