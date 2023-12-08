package TP4.exercice2;

public class RecursivDisplayNumber {


    public RecursivDisplayNumber(){

    }

    public static void display(int start, int stop){
        if (start > stop)
            return;

        if (start == stop + 1)
            return;

        System.out.println(start);

        display(start + 1, stop);
    }
}
