package TP4.exercice2;

public class RecursivDisplayNumber {

    public static void display(int start, int end){
        if (start > end)
            return;

        System.out.print(start + " ");

        display(start + 1, end);
    }
}
