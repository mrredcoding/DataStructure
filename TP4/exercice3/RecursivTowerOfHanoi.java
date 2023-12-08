package TP4.exercice3;

public class RecursivTowerOfHanoi {

    public RecursivTowerOfHanoi(){

    }

    public static void towers(int n, char frompeg, char topeg, char auxpeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + frompeg + " to " + topeg);
            return;
        }

        towers(n - 1, frompeg, auxpeg, topeg);

        System.out.println("Move disk " + n + " from " + frompeg + " to " + topeg);

        towers(n - 1, auxpeg, topeg, frompeg);
    }
}

