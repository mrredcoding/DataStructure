package TP3.utils;

public enum BracketType {
    OPEN_PARENTHESIS('('),
    CLOSE_PARENTHESIS(')'),
    OPEN_SQUARE_BRACKET('['),
    CLOSE_SQUARE_BRACKET(']'),
    OPEN_CURLY_BRACE('{'),
    CLOSE_CURLY_BRACE('}');

    private final Character symbol;

    BracketType(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}
