package TP1.historique;

public class Main {
    public static void main(String[] args) {
        Historique historique = new Historique();

        historique.ajouter_url("Google.com");
        historique.ajouter_url("Netflix&Chiiiiiiiiiiilll.com");
        historique.ajouter_url("Wikipedia.org");
        historique.ajouter_url("MyEfrei.yes");

        System.out.println(historique);

        System.out.println(historique.whereAmI());

        try {
            historique.reculer();
        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }

        try {
            historique.avancer();

        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(historique.whereAmI());

        try {
            historique.avancer();
        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(historique.whereAmI());

        try {
            historique.reculer();
        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(historique.whereAmI());

        try {
            historique.avancer();
        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(historique.whereAmI());

        try {
            historique.avancer();
        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(historique.whereAmI());

        try {
            historique.avancer();
        } catch (HistoriqueException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(historique.whereAmI());

        historique.supprimer_dernier_url();

        System.out.println(historique);

        System.out.println(historique.whereAmI());
    }
}