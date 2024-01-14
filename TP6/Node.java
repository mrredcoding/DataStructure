package TP6;

/**
 * Représentation d'un nœud dans un arbre de recherche binaire (BST).
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Node {

    private Integer value;
    private Node left;
    private Node right;

    /**
     * Constructeur d'un nœud sans valeur, gauche, ni droite.
     */
    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructeur d'un nœud avec une valeur donnée, sans nœuds gauche ni droit.
     *
     * @param valeur La valeur du nœud.
     */
    public Node(Integer valeur) {
        this.value = valeur;
        this.left = null;
        this.right = null;
    }

    /**
     * Obtient la valeur du nœud.
     *
     * @return La valeur du nœud.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Définit la valeur du nœud.
     *
     * @param valeur La nouvelle valeur du nœud.
     */
    public void setValue(Integer valeur) {
        this.value = valeur;
    }

    /**
     * Obtient le nœud gauche.
     *
     * @return Le nœud gauche.
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Définit le nœud gauche.
     *
     * @param noeud Le nœud gauche.
     */
    public void setLeft(Node noeud) {
        this.left = noeud;
    }

    /**
     * Obtient le nœud droit.
     *
     * @return Le nœud droit.
     */
    public Node getRight() {
        return right;
    }

    /**
     * Définit le nœud droit.
     *
     * @param noeud Le nœud droit.
     */
    public void setRight(Node noeud) {
        this.right = noeud;
    }

    /**
     * Obtient une représentation sous forme de chaîne de caractères du nœud.
     *
     * @return La représentation du nœud en tant que chaîne de caractères.
     */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
