package TP3.parenthesesChecker;
import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP3.utils.BracketType;

public class BracketChecker {

    private final String expression;
    public BracketChecker(String expression){
        this.expression = expression;
    }
    public boolean areBracketsNested() throws EmptyStackExceptions {
        DynamicStack<Character> stack = new DynamicStack<>();

        for (Character currentChar : this.expression.toCharArray()) {
            if (currentChar == BracketType.OPEN_PARENTHESIS.getSymbol()
                    || currentChar == BracketType.OPEN_SQUARE_BRACKET.getSymbol()
                    || currentChar == BracketType.OPEN_CURLY_BRACE.getSymbol()) {
                stack.push(currentChar);
            }

            else if (currentChar == BracketType.CLOSE_PARENTHESIS.getSymbol()
                    || currentChar == BracketType.CLOSE_SQUARE_BRACKET.getSymbol()
                    || currentChar == BracketType.CLOSE_CURLY_BRACE.getSymbol()) {
                if (stack.isEmpty())
                    return false;

                Character poppedChar = stack.pop();

                if ((currentChar == BracketType.CLOSE_PARENTHESIS.getSymbol() && poppedChar != BracketType.OPEN_PARENTHESIS.getSymbol())
                        || (currentChar == BracketType.CLOSE_SQUARE_BRACKET.getSymbol() && poppedChar != BracketType.OPEN_SQUARE_BRACKET.getSymbol())
                        || (currentChar == BracketType.CLOSE_CURLY_BRACE.getSymbol() && poppedChar != BracketType.OPEN_CURLY_BRACE.getSymbol())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}