package TP2.utils;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

public class Test {
    public static String titleBox(String title){
        String repeat = "═".repeat(Math.max(0, title.length() + 2));

        return "\u001B[34m" +
                System.lineSeparator() +
                "╔" + repeat +  "╗" +
                System.lineSeparator() +
                "║ " + title + " ║" +
                System.lineSeparator() +
                "╚" + repeat +  "╝" +
                "\u001B[0m";

    }

    public static void pop(Stack<?> stack){
        try {
            System.out.println(stack.getClass().getSimpleName() + " Popped value = " + stack.pop());
            System.out.println();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public static void top(Stack<?> stack){
        try {
            System.out.println(stack.getClass().getSimpleName() + " Top value = " + stack.top());
            System.out.println();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public static void display(Stack<?> stack){
        try {
            System.out.println(stack.getClass().getSimpleName() + " Contents :");
            stack.display();
            System.out.println();
        } catch (EmptyStackExceptions e){
            System.out.println(e.getMessage());
        }
    }
}
