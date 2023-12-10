package TP4.exercice5;
import TP2.stack.EmptyStackExceptions;
import TP2.staticStack.StaticStack;

public class PrefixToPostfix {

    private static StaticStack<String> stack;

    public static String transform(String prefix) throws EmptyStackExceptions {
        stack = new StaticStack<>(prefix.length());
        recursiveTransform(prefix);
        return stack.pop();
    }

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

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}