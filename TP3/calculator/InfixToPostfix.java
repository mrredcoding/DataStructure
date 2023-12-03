package TP3.calculator;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP3.utils.*;

public class InfixToPostfix{

    private final String infixExpression;
    public InfixToPostfix(String infixExpression) {
        this.infixExpression = infixExpression;
    }

    private int priority(Character operator) {
        if (operator == OperatorType.MULTIPLY.getOperator() || operator == OperatorType.DIVIDE.getOperator())
            return 2;

        else if (operator == OperatorType.ADD.getOperator() || operator == OperatorType.SUBTRACT.getOperator())
            return 1;

        else
            return 0;
    }

    private boolean isOperand(Character character) {
        return Character.isLetterOrDigit(character);
    }

    private boolean isOpenBracket(Character character) {
        return character == BracketType.OPEN_PARENTHESIS.getSymbol()
                || character == BracketType.OPEN_SQUARE_BRACKET.getSymbol()
                || character == BracketType.OPEN_CURLY_BRACE.getSymbol();
    }

    private boolean isCloseBracket(Character character) {
        return character == BracketType.CLOSE_PARENTHESIS.getSymbol()
                || character == BracketType.CLOSE_SQUARE_BRACKET.getSymbol()
                || character == BracketType.CLOSE_CURLY_BRACE.getSymbol();
    }

    public String toPostfix() throws EmptyStackExceptions {
        StringBuilder postfix = new StringBuilder();
        DynamicStack<Character> operatorStack = new DynamicStack<>();

        for (char currentChar : infixExpression.toCharArray()) {
            if (currentChar == ' ')
                continue;

            if (isOperand(currentChar)) {
                postfix.append(currentChar);
            } else if (isOpenBracket(currentChar)) {
                operatorStack.push(currentChar);
            } else if (isCloseBracket(currentChar)) {
                while (!operatorStack.isEmpty() && !isOpenBracket(operatorStack.top())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && priority(currentChar) <= priority(operatorStack.top())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(currentChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }
}