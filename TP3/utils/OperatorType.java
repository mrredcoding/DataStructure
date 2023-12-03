package TP3.utils;

public enum OperatorType {

    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final Character operator;

    OperatorType(Character operator) {
        this.operator = operator;
    }

    public Character getOperator() {
        return operator;
    }
}
