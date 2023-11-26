package TP1.liste_chainees;

/**
 * Classe principale contenant la méthode main pour tester la classe {@link ListeChainees}.
 */
public class Main {
    public static void main(String[] args) {
        ListeChainees<Integer> liste = new ListeChainees<>();

        liste.ajouter_debut(4);
        liste.ajouter_debut(2);
        liste.ajouter_debut(3);

        System.out.println("Liste apres ajout au debut : " + liste);

        liste.ajouter_fin(5);
        liste.ajouter_fin(1);

        System.out.println("Liste apres ajout a la fin : " + liste);

        int valeurRechercheeExist = 3;
        Cellule<Integer> maillonRecherche = liste.rechercher(valeurRechercheeExist);
        if (maillonRecherche != null) {
            System.out.println("Valeur " + valeurRechercheeExist + " trouvee dans la liste.");
        } else {
            System.out.println("Valeur " + valeurRechercheeExist + " non trouvee dans la liste.");
        }

        int valeurRechercheeNotExist = 7;
        maillonRecherche = liste.rechercher(valeurRechercheeNotExist);
        if (maillonRecherche != null) {
            System.out.println("Valeur " + valeurRechercheeNotExist + " trouvee dans la liste.");
        } else {
            System.out.println("Valeur " + valeurRechercheeNotExist + " non trouvee dans la liste.");
        }

        liste.supprimer_debut();
        System.out.println("Liste apres suppression au debut : " + liste);

        liste.supprimer_fin();
        System.out.println("Liste apres suppression a la fin : " + liste);

        int valeurSuppression = 2;
        liste.supprimer_val(valeurSuppression);
        System.out.println("Liste apres suppression de la valeur " + valeurSuppression + " : " + liste);
    }
}


