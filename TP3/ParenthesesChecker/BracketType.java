package TP3.ParenthesesChecker;

public enum BracketType {
    OPEN_PARENTHESIS('('),
    CLOSE_PARENTHESIS(')'),
    OPEN_SQUARE_BRACKET('['),
    CLOSE_SQUARE_BRACKET(']'),
    OPEN_CURLY_BRACE('{'),
    CLOSE_CURLY_BRACE('}');

    private final char symbol;

    BracketType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
