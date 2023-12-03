package TP3.calculator;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;
import TP2.staticStack.StaticStack;

public class Main {

    public static void main(String[] args) {
        String infixExpression = "( 2 + 3 ) * ( 6 - ( 7 - 8 ) ) / ( 6 + 1 )";
        InfixToPostfix infixToPostfix = new InfixToPostfix(infixExpression);

        String postfixExpression = null;
        try {
            postfixExpression = infixToPostfix.toPostfix();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        PostfixEvaluator postfixEvaluator = new PostfixEvaluator(postfixExpression);

        double result = 0;
        try {
            result = postfixEvaluator.evaluate();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Result: " + result);
    }
}
