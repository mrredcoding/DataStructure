package TP3.ParenthesesChecker;
import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;

public class ParenthesesChecker {

    private final String expression;
    public ParenthesesChecker(String expression){
        this.expression = expression;
    }
    public boolean areParenthesesNested() throws EmptyStackExceptions {
        DynamicStack<Character> stack = new DynamicStack<>();

        for (char currentChar : this.expression.toCharArray()) {
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

                char poppedChar = stack.pop();

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