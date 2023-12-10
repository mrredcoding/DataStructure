package TP4.exercice2;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        int stop = 30;

        System.out.println("Voici la liste des " + stop + " premiers nombres :");
        RecursivDisplayNumber.display(start, stop);
    }
}
