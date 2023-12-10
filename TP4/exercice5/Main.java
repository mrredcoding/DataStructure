package TP4.exercice5;

import TP2.stack.EmptyStackExceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyStackExceptions {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a prefix expression:");
        String prefix = scanner.nextLine();

        String postfix = PrefixToPostfix.transform(prefix);
        System.out.println("Postfix expression : " + postfix);
    }
}
