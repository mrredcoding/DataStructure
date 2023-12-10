package TP4.exercice4;

public class RecursiveExpressionIsValid {
    private static String input;
    private static int pos;

    public static boolean validate(String expression) {
        input = expression;
        pos = 0;
        return expr() && pos == input.length();
    }

    private static boolean expr() {
        if (term()) {
            char symbol = getsymb();
            if (symbol == '+' && pos < input.length()) {
                pos++;
                return term();
            }
            return true;
        }
        return false;
    }

    private static boolean term() {
        if (factor()) {
            char symbol = getsymb();
            if (symbol == '*' && pos < input.length()) {
                pos++;
                return factor();
            }
            return true;
        }
        return false;
    }

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

    private static char getsymb() {
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }
}
