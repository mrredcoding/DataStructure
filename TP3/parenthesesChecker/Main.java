package TP3.parenthesesChecker;

import TP2.stack.EmptyStackExceptions;

public class Main {
    public static void main(String[] args) {
        String expression = "7 - { [ x * [ ( x + y) / (j – 3) ] + y ] / (4 – 2.5) }";

        BracketChecker checker = new BracketChecker(expression);

        try {
            if (checker.areBracketsNested()) {
                System.out.println("C'est bon");
            } else {
                System.out.println("C'est pas bon");
            }
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
