package TP3.ParenthesesChecker;

import TP2.stack.EmptyStackExceptions;

public class Main {
    public static void main(String[] args) {
        String expression = "7 - { [ x * [ ( x + y) / (j – 3) ] + y ] / (4 – 2.5) }";

        ParenthesesChecker checker = new ParenthesesChecker(expression);

        try {
            if (checker.areParenthesesNested()) {
                System.out.println("C'est bon");
            } else {
                System.out.println("C'est pas bon");
            }
        } catch (EmptyStackExceptions e) {
            System.err.println(e.getMessage());
        }
    }
}
