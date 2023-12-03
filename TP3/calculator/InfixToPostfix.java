package TP3.calculator;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP3.utils.*;

/**
 * La classe InfixToPostfix est utilisée pour convertir une expression infixée en notation postfixée.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class InfixToPostfix {

    /**
     * L'expression infixée à convertir en notation postfixée.
     */
    private final String infixExpression;

    /**
     * Construit un objet InfixToPostfix avec l'expression infixée spécifiée.
     *
     * @param infixExpression L'expression infixée à convertir.
     */
    public InfixToPostfix(String infixExpression) {
        this.infixExpression = infixExpression;
    }

    /**
     * Retourne la priorité d'un opérateur donné.
     *
     * @param operator L'opérateur dont on veut connaître la priorité.
     * @return La priorité de l'opérateur.
     */
    private int priority(Character operator) {
        if (operator == OperatorType.MULTIPLY.getOperator() || operator == OperatorType.DIVIDE.getOperator())
            return 2;
        else if (operator == OperatorType.ADD.getOperator() || operator == OperatorType.SUBTRACT.getOperator())
            return 1;
        else
            return 0;
    }

    /**
     * Vérifie si un caractère donné est un opérande (chiffre ou lettre).
     *
     * @param character Le caractère à vérifier.
     * @return true si le caractère est un opérande, false sinon.
     */
    private boolean isOperand(Character character) {
        return Character.isLetterOrDigit(character);
    }

    /**
     * Vérifie si un caractère donné est une parenthèse ouvrante.
     *
     * @param character Le caractère à vérifier.
     * @return true si le caractère est une parenthèse ouvrante, false sinon.
     */
    private boolean isOpenBracket(Character character) {
        return character == BracketType.OPEN_PARENTHESIS.getSymbol()
                || character == BracketType.OPEN_SQUARE_BRACKET.getSymbol()
                || character == BracketType.OPEN_CURLY_BRACE.getSymbol();
    }

    /**
     * Vérifie si un caractère donné est une parenthèse fermante.
     *
     * @param character Le caractère à vérifier.
     * @return true si le caractère est une parenthèse fermante, false sinon.
     */
    private boolean isCloseBracket(Character character) {
        return character == BracketType.CLOSE_PARENTHESIS.getSymbol()
                || character == BracketType.CLOSE_SQUARE_BRACKET.getSymbol()
                || character == BracketType.CLOSE_CURLY_BRACE.getSymbol();
    }

    /**
     * Convertit l'expression infixée en notation postfixée.
     *
     * @return L'expression en notation postfixée.
     * @throws EmptyStackExceptions si une tentative est faite pour dépiler un élément d'une pile vide.
     */
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
