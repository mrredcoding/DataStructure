package TP4.exercice4;

public class RecursiveExpressionIsValid {
    private static String input;

    public static boolean validate(String expression) {
        input = expression;
        return expr() && input.isEmpty();
    }

    private static boolean expr() {
        if (term()) {
            if (input.startsWith("+")) {
                input = input.substring(1);
                return term();
            }
            return true;
        }
        return false;
    }

    private static boolean term() {
        if (factor()) {
            if (input.startsWith("*")) {
                input = input.substring(1);
                return factor();
            }
            return true;
        }
        return false;
    }

    private static boolean factor() {
        if (!input.isEmpty()) {
            if (Character.isLetter(input.charAt(0))) {
                input = input.substring(1);
                return true;
            } else if (input.startsWith("(")) {
                input = input.substring(1);
                boolean valid = expr();
                if (valid && input.startsWith(")")) {
                    input = input.substring(1);
                    return true;
                }
            }
        }
        return false;
    }
}
