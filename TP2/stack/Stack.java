package TP2.stack;

/**
 * L'interface Stack<T> définit les opérations de base d'une pile (stack).
 *
 * @param <T> Le type des éléments stockés dans la pile.
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public interface Stack<T> {

    /**
     * Ajoute un élément au sommet de la pile.
     *
     * @param value L'élément à ajouter à la pile.
     */
    void push(T value);

    /**
     * Retire et renvoie l'élément situé au sommet de la pile.
     *
     * @return L'élément retiré de la pile.
     * @throws EmptyStackExceptions Si la pile est vide au moment de l'appel.
     */
    T pop() throws EmptyStackExceptions;

    /**
     * Renvoie l'élément situé au sommet de la pile sans le retirer.
     *
     * @return L'élément au sommet de la pile.
     * @throws EmptyStackExceptions Si la pile est vide au moment de l'appel.
     */
    T top() throws EmptyStackExceptions;

    /**
     * Affiche les éléments de la pile. L'ordre d'affichage dépend de l'implémentation
     * spécifique de la pile.
     *
     * @throws EmptyStackExceptions Si la pile est vide au moment de l'appel.
     */
    void display() throws EmptyStackExceptions;
}
