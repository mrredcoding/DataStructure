package TP4.exercice4;

public class RecursivIsValidExpression {

    private int pos;
    public RecursivIsValidExpression(){
        this.pos = 0;
    }

    public boolean validate(String expression) {
        return expr(expression, expression.length()) && this.pos == expression.length();
    }

    private char getsymb(String str, int length) {
        if (this.pos < length) {
            return str.charAt(this.pos++);
        }
        return '\0';
    }

    private boolean expr(String str, int length) {
        if (term(str, length)) {
            char symbol = getsymb(str, length);
            if (symbol == '+') {
                return term(str, length) && expr(str, length);
            } else {
                this.pos--;
                return true;
            }
        }
        return false;
    }

    private boolean term(String str, int length) {
        return factor(str, length) && termContinuation(str, length);
    }

    private boolean termContinuation(String str, int length) {
        char symbol = getsymb(str, length);
        if (symbol == '*') {
            return factor(str, length) && termContinuation(str, length);
        } else {
            this.pos--;
            return true;
        }
    }

    private boolean factor(String str, int length) {
        char symbol = getsymb(str, length);
        if (Character.isLetter(symbol)) {
            return true;
        } else if (symbol == '(') {
            boolean result = expr(str, length);
            symbol = getsymb(str, length);
            return result && symbol == ')';
        }
        return false;
    }
}
