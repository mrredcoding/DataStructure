package TP1.liste_chainees;

/**
 * Classe représentant une liste doublement chaînée générique.
 * @param <T> Le type de valeur stockée dans la liste.
 * @version 1.0
 * @author Alonso Cédric
 * @author Hatoum Jade
 */
public class ListeChainees<T> {

    private Cellule<T> first;

    private Cellule<T> last;
    private int taille;

    /**
     * Constructeur par défaut de la liste chaînée initialisant une liste chaînée vide.
     */
    public ListeChainees(){
        this.first = null;
        this.last = null;
        this.taille = 0;
    }

    /**
     * Constructeur de la liste chaînée avec des paramètres initiaux.
     * @param first La première cellule de la liste.
     * @param last La dernière cellule de la liste.
     * @param taille La taille initiale de la liste.
     */
    public ListeChainees(Cellule<T> first, Cellule<T> last, int taille){
        this.first = first;
        this.last = last;
        this.taille = taille;
    }

    /**
     * Ajoute une nouvelle cellule contenant une valeur spécifique au début de la liste.
     * @param value La valeur à ajouter.
     */
    public void ajouter_debut(T value){
        Cellule<T> toAdd;
        if (this.first != null) {
            toAdd = new Cellule<>(value);
            toAdd.setSuivant(this.first);
            this.first.setPrecedent(toAdd);
        }
        else {
            toAdd = new Cellule<>(value);
            toAdd.setSuivant(null);
            toAdd.setPrecedent(null);
            this.last = toAdd;
        }
        this.first = toAdd;
        this.taille++;
    }

    /**
     * Ajoute une nouvelle cellule contenant une valeur spécifique à la fin de la liste.
     * @param value La valeur à ajouter.
     */
    public void ajouter_fin(T value){
        Cellule<T> toAdd;
        if (this.last != null) {
            toAdd = new Cellule<>(value);
            toAdd.setPrecedent(this.last);
            this.last.setSuivant(toAdd);
        }
        else {
            toAdd = new Cellule<>(value);
            toAdd.setSuivant(null);
            toAdd.setPrecedent(null);
            this.first = toAdd;
        }
        this.last = toAdd;
        this.taille++;
    }

    /**
     * Recherche une cellule contenant une valeur spécifique dans la liste.
     * @param value La valeur à rechercher.
     * @return La cellule trouvée, ou null si la valeur n'est pas présente.
     */
    public Cellule<T> rechercher(T value){
        Cellule<T> currentStart = first;
        Cellule<T> currentEnd = last;
        int index = 0;

        while(taille/2 > index){
            if(currentStart.getValue() == value)
                return currentStart;

            if(currentEnd.getValue() == value)
                return currentEnd;

            currentStart = currentStart.getSuivant();
            currentEnd = currentEnd.getPrecedent();

            index++;
        }
        //if middle value
        if(currentStart.getValue() == value)
            return currentStart;

        return null;
    }

    /**
     * Supprime la première cellule de la liste.
     */
    public void supprimer_debut(){
        if (first != null) {
            this.first = this.first.getSuivant();
            this.first.setPrecedent(null);
            taille--;
        }
    }

    /**
     * Supprime la dernière cellule de la liste.
     */
    public void supprimer_fin(){
        if (last != null) {
            this.last = this.last.getPrecedent();
            this.last.setSuivant(null);
            taille--;
        }
    }

    /**
     * Supprime une cellule contenant une valeur spécifique de la liste.
     * @param value La valeur à supprimer.
     */
    public void supprimer_val(T value) {
        Cellule<T> toDelete = rechercher(value);

        if (toDelete != null) {

            if (toDelete.equals(first))
                supprimer_debut();

            if (toDelete.equals(last))
                supprimer_fin();

            else {
                if (toDelete.getSuivant() != null) {
                    toDelete.getSuivant().setPrecedent(toDelete.getPrecedent());
                }
                if (toDelete.getPrecedent() != null) {
                    toDelete.getPrecedent().setSuivant(toDelete.getSuivant());
                }
            }

            toDelete.setPrecedent(null);
            toDelete.setSuivant(null);
            taille--;
        }
    }

    /**
     * Retourne une représentation en chaîne de caractères de la liste.
     * @return La représentation en chaîne de la liste.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Cellule<T> current = this.first;
        do{
            sb.append(current);
            if (current.getSuivant() != null)
                sb.append("->");

            current = current.getSuivant();
        }while(current != null);

        return sb.toString();
    }

    public Cellule<T> getFirst() {
        return first;
    }

    public Cellule<T> getLast() {
        return last;
    }

    public int getTaille() {
        return taille;
    }

}
