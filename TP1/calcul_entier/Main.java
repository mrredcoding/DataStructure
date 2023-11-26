package TP1.calcul_entier;

public class Main {

    public static void main(String[] args) {
        Entier e1 = new Entier(10329855L, 3);

        Entier e2 = new Entier(1295483625L, 3);

        Entier e3 = e1.additionner(e2);

        System.out.println(e1 + " + " + e2 + " = " + e3);
    }
}
