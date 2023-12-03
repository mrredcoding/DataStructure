package TP3.calculator;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP3.utils.*;

public class PostfixEvaluator {

    private final String postfixExpression;

    public PostfixEvaluator(String postfixExpression){
        this.postfixExpression = postfixExpression;
    }
    public double evaluate() throws EmptyStackExceptions {
        DynamicStack<Integer> operandStack = new DynamicStack<>();

        for (char currentChar : postfixExpression.toCharArray()) {
            if (currentChar == ' ' )
                continue;

            if (Character.isDigit(currentChar)) {
                operandStack.push(Character.getNumericValue(currentChar));
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();

                if (currentChar == OperatorType.ADD.getOperator())
                    operandStack.push(operand1 + operand2);

                else if (currentChar == OperatorType.SUBTRACT.getOperator())
                    operandStack.push(operand1 - operand2);

                else if (currentChar == OperatorType.MULTIPLY.getOperator())
                    operandStack.push(operand1 * operand2);

                else if (currentChar == OperatorType.DIVIDE.getOperator())
                    operandStack.push(operand1 / operand2);
            }
        }

        return operandStack.pop();
    }
}
