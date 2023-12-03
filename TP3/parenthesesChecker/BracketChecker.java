package TP3.parenthesesChecker;
import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP3.utils.BracketType;

/**
 * La classe BracketChecker est utilisée pour vérifier si les parenthèses dans une expression donnée
 * sont correctement imbriquées.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class BracketChecker {

    /**
     * L'expression à vérifier pour les parenthèses correctement imbriquées.
     */
    private final String expression;

    /**
     * Construit un BracketChecker avec l'expression spécifiée.
     *
     * @param expression L'expression à vérifier.
     */
    public BracketChecker(String expression){
        this.expression = expression;
    }

    /**
     * Vérifie si les parenthèses dans l'expression sont correctement imbriquées.
     *
     * @return true si les parenthèses sont correctement imbriquées, false sinon.
     * @throws EmptyStackExceptions si une tentative est faite pour dépiler un élément d'une pile vide.
     */
    public boolean areBracketsNested() throws EmptyStackExceptions {
        DynamicStack<Character> stack = new DynamicStack<>();

        for (Character currentChar : this.expression.toCharArray()) {
            if (currentChar == BracketType.OPEN_PARENTHESIS.getSymbol()
                    || currentChar == BracketType.OPEN_SQUARE_BRACKET.getSymbol()
                    || currentChar == BracketType.OPEN_CURLY_BRACE.getSymbol()) {
                stack.push(currentChar);
            } else if (currentChar == BracketType.CLOSE_PARENTHESIS.getSymbol()
                    || currentChar == BracketType.CLOSE_SQUARE_BRACKET.getSymbol()
                    || currentChar == BracketType.CLOSE_CURLY_BRACE.getSymbol()) {
                if (stack.isEmpty())
                    return false;

                Character poppedChar = stack.pop();

                if ((currentChar == BracketType.CLOSE_PARENTHESIS.getSymbol()
                                && poppedChar != BracketType.OPEN_PARENTHESIS.getSymbol())
                        || (currentChar == BracketType.CLOSE_SQUARE_BRACKET.getSymbol()
                                && poppedChar != BracketType.OPEN_SQUARE_BRACKET.getSymbol())
                        || (currentChar == BracketType.CLOSE_CURLY_BRACE.getSymbol()
                                && poppedChar != BracketType.OPEN_CURLY_BRACE.getSymbol())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
