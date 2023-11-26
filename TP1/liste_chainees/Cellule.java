package TP1.liste_chainees;

/**
 * Classe représentant une Cellule d'une liste chaînée.
 * @param <T> Le type de valeur stockée dans la cellule.
 * @version 1.0
 * @author Alonso Cédric
 * @author Hatoum Jade
 */
public class Cellule<T>{
    /**
     * La valeur stockée dans la cellule.
     */
    private T value;

    /**
     * Le pointeur de la cellule suivante pour la cellule actuelle.
     */
    private Cellule<T> suivant;

    /**
     * Le pointeur de la cellule précédente pour la cellule actuelle.
     */
    private Cellule<T> precedent;


    /**
     * Constructeur de la Cellule.
     * @param value La valeur à stocker dans la cellule.
     */
    public Cellule(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Cellule<T> getSuivant() {
        return suivant;
    }

    public void setSuivant(Cellule<T> suivant) {
        this.suivant = suivant;
    }

    public Cellule<T> getPrecedent() {
        return precedent;
    }

    public void setPrecedent(Cellule<T> precedent) {
        this.precedent = precedent;
    }

    /**
     * Compare cette cellule avec un autre objet pour vérifier si les deux Cellules sont égales.
     * @param o L'objet à comparer.
     * @return true si les cellules sont égales, sinon false.
     */
    @Override
    public boolean equals(Object o){
        if (!this.getClass().equals(o.getClass()))
            return false;

        return this.value == ((Cellule<?>) o).getValue();
    }

    /**
     * Retourne une représentation en chaîne de caractères de la cellule.
     * @return La représentation de la cellule.
     */
    @Override
    public String toString(){
        return this.value.toString();
    }
}
