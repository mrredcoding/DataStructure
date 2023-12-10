package TP4.exercice5;
import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;
import TP2.staticStack.StaticStack;

public class PrefixToPostfix {
    static boolean isOperator(char c) { return c == '+' || c == '-' || c == '*' || c == '/'; }

    static String transform(String prefix) throws EmptyStackExceptions {
        Stack<String> stack = new StaticStack<>(prefix.length());
        int length = prefix.length();

        for (int i = length - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (isOperator(c)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(operand1 + operand2 + c);
            } else
                stack.push(Character.toString(c));
        }

        return stack.top();
    }
}
