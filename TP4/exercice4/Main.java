package TP4.exercice4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an algebraic expression:");
        String expression = scanner.nextLine();

        boolean isValid = RecursiveExpressionIsValid.validate(expression);
        System.out.print(expression + " is ");
        System.out.println(isValid ? "valid" : "not valid");
    }
}
