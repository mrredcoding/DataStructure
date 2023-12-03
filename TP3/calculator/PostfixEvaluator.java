package TP3.calculator;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP3.utils.*;

/**
 * La classe PostfixEvaluator est utilisée pour évaluer une expression en notation postfixée.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class PostfixEvaluator {

    /**
     * L'expression en notation postfixée à évaluer.
     */
    private final String postfixExpression;

    /**
     * Construit un objet PostfixEvaluator avec l'expression postfixée spécifiée.
     *
     * @param postfixExpression L'expression en notation postfixée à évaluer.
     */
    public PostfixEvaluator(String postfixExpression){
        this.postfixExpression = postfixExpression;
    }

    /**
     * Évalue l'expression en notation postfixée et retourne le résultat.
     *
     * @return Le résultat de l'évaluation de l'expression postfixée.
     * @throws EmptyStackExceptions si une tentative est faite pour dépiler un élément d'une pile vide.
     */
    public double evaluate() throws EmptyStackExceptions {
        DynamicStack<Double> operandStack = new DynamicStack<>();

        for (char currentChar : postfixExpression.toCharArray()) {
            if (currentChar == ' ')
                continue;

            if (Character.isDigit(currentChar)) {
                operandStack.push((double) Character.getNumericValue(currentChar));
            } else {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();

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
