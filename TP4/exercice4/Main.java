package TP4.exercice4;

public class Main {
    public static void main(String[] args) {

        RecursivIsValidExpression validator = new RecursivIsValidExpression();

        boolean isValid = validator.validate("1+1");

        System.out.println(isValid ? "Yes" : "No");
    }
}
