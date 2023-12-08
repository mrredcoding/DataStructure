package TP4.exercice4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RecursivIsValidExpression validator = new RecursivIsValidExpression();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an algebraic expression :");
        String expression = scanner.nextLine();

        boolean isValid = validator.validate(expression);

        System.out.print(expression + " is ");
        System.out.println(isValid ? "valid" : "not valid");
    }
}
