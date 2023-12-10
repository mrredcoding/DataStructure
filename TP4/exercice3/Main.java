package TP4.exercice3;

public class Main {
    public static void main(String[] args) {
        int n = 4;

        System.out.println("To resolve the hanoi towers problem with " + n + " disks," +
                " you should consider the following steps : ");
        RecursiveHanoiTower.towers(n, 'A', 'C', 'B');
    }
}
