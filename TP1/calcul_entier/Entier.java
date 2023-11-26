package TP1.calcul_entier;

import TP1.liste_chainees.Cellule;
import TP1.liste_chainees.ListeChainees;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un nombre entier de grande taille basé sur une liste chaînée {@link ListeChainees}.
 *
 * @version 1.0
 * @author Alonso Cédric
 * @author Hatoum Jade
 */
public class Entier {

    /**
     * La liste chaînée utilisée pour représenter l'entier.
     */
    private final ListeChainees<Long> entier;

    /**
     * Le nombre de chiffres par cellule dans l'entier.
     */
    private final int nbChiffresParCellule;

    /**
     * Constructeur de la classe Entier.
     *
     * @param nbChiffresParCellule Le nombre de chiffres par cellule.
     */
    public Entier(int nbChiffresParCellule){
        this.entier = new ListeChainees<>();
        this.nbChiffresParCellule = nbChiffresParCellule;
    }

    /**
     * Constructeur de la classe Entier initialisé avec une valeur initiale.
     *
     * @param value La valeur initiale de l'entier.
     * @param nbChiffresParCellule Le nombre de chiffres par cellule.
     */
    public Entier(Long value, int nbChiffresParCellule){
        this.entier = new ListeChainees<>();
        this.nbChiffresParCellule = nbChiffresParCellule;

        this.init(value);
    }

    /**
     * Initialise l'entier en découpant la valeur en chiffres d'une longueur donnée.
     *
     * @param value La valeur initiale de l'entier.
     */
    private void init(long value){
        String sEntier = String.valueOf(value);
        int i;
        List<String> nbs = new ArrayList<>();
        for (i = 0; i+nbChiffresParCellule-1 < sEntier.length(); i+=nbChiffresParCellule)
            nbs.add(sEntier.substring(i, i+nbChiffresParCellule));

        if (sEntier.length() % nbChiffresParCellule != 0)
            nbs.add(sEntier.substring(i));

        for (String nb : nbs)
            if (!nb.isEmpty())
                this.entier.ajouter_fin(Long.valueOf(nb));
    }

    /**
     * Additionne cet entier avec un autre entier donné.
     *
     * @param entierToAdd L'entier à ajouter.
     * @return Un nouvel {@link Entier} représentant la somme des deux entiers.
     */
    public Entier additionner(Entier entierToAdd) {
        Entier result = new Entier(nbChiffresParCellule);

        Cellule<Long> currentThis = this.entier.getLast();
        Cellule<Long> currentOther = entierToAdd.getEntier().getLast();

        int carry = 0;

        while (currentThis != null || currentOther != null || carry > 0) {
            long sum = carry;

            if (currentThis != null) {
                sum += currentThis.getValue();
                currentThis = currentThis.getPrecedent();
            }

            if (currentOther != null) {
                sum += currentOther.getValue();
                currentOther = currentOther.getPrecedent();
            }

            carry = (int) (sum / Math.pow(10, nbChiffresParCellule)); // Calculate the carry for the next iteration

            long cellValue = sum % (long) Math.pow(10, nbChiffresParCellule);

            result.getEntier().ajouter_debut(cellValue);
        }

        return result;
    }

    public ListeChainees<Long> getEntier() {
        return entier;
    }

    /**
     * Renvoie la liste chaînée représentant cet entier.
     *
     * @return La liste chaînée représentant l'entier.
     */
    public String toString(){
        return this.entier.toString();
    }
}
