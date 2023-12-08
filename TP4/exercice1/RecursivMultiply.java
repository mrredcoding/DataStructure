package TP4.exercice1;

public class RecursivMultiply {

    public RecursivMultiply(){
    }


    public static int calculate(int a, int b){
        if (a == 0 || b == 0)
            return 0;

        return a + calculate(a, b -1);
    }
}
