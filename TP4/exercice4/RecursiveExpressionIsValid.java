package TP4.exercice4;

/**
 * La classe RecursiveExpressionIsValid fournit une méthode pour vérifier la validité
 * syntaxique d'une expression arithmétique simple composée d'additions et de multiplications,
 * ainsi que de parenthèses et de variables (lettres).
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class RecursiveExpressionIsValid {

    /**
     * La chaîne d'entrée contenant l'expression à valider.
     */
    private static String input;

    /**
     * La position courante dans la chaîne d'entrée lors de la validation.
     */
    private static int pos;

    /**
     * Valide la syntaxe d'une expression arithmétique récursivement.
     *
     * @param expression L'expression arithmétique à valider.
     * @return true si l'expression est valide, sinon false.
     */
    public static boolean validate(String expression) {
        input = expression;
        pos = 0;
        return expr() && pos == input.length();
    }

    /**
     * Valide la syntaxe d'une expression, qui peut inclure des termes et des opérations d'addition et de soustraction.
     *
     * @return true si l'expression est valide, sinon false.
     */
    private static boolean expr() {
        if (term()) {
            char symbol = getsymb();
            if ((symbol == '+' || symbol == '-') && pos < input.length()) {
                pos++;
                return term();
            }
            return true;
        }
        return false;
    }

    /**
     * Valide la syntaxe d'un terme, qui peut inclure des facteurs et des opérations de multiplication et de division.
     *
     * @return true si le terme est valide, sinon false.
     */
    private static boolean term() {
        if (factor()) {
            char symbol = getsymb();
            if ((symbol == '*' || symbol == '/') && pos < input.length()) {
                pos++;
                return factor();
            }
            return true;
        }
        return false;
    }

    /**
     * Valide la syntaxe d'un facteur, qui peut être une variable ou une expression entre parenthèses.
     *
     * @return true si le facteur est valide, sinon false.
     */
    private static boolean factor() {
        if (pos < input.length()) {
            char symbol = getsymb();
            if (Character.isLetter(symbol)) {
                pos++;
                return true;
            } else if (symbol == '(') {
                pos++;
                boolean valid = expr();
                if (valid && getsymb() == ')') {
                    pos++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Obtient le symbole actuel à la position courante dans la chaîne d'entrée.
     *
     * @return Le symbole actuel ou '\0' si la fin de la chaîne est atteinte.
     */
    private static char getsymb() {
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }
}

