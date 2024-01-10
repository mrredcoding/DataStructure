package TP6;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'un Arbre de recherche binaire (BST).
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class BST {

    public static final int NBMAXNODES = 2;
    private Node root;

    /**
     * Constructeur d'un Arbre de recherche binaire vide.
     */
    public BST() {
        this.root = new Node();
    }

    /**
     * Insère une valeur dans l'Arbre de recherche binaire.
     *
     * @param value La valeur à insérer.
     */
    public void insert(Integer value) {
        this.root = insert(value, this.root);
    }

    private Node insert(Integer value, Node source) {
        if (source == null || source.getValue() == null)
            return new Node(value);
        else if (value > source.getValue())
            source.setRight(insert(value, source.getRight()));
        else if (value <= source.getValue())
            source.setLeft(insert(value, source.getLeft()));

        return source;
    }

    /**
     * Effectue un parcours en ordre de l'Arbre de Recherche Binaire.
     *
     * @return Liste d'entiers représentant le parcours en ordre.
     * @throws BSTException si l'Arbre de Recherche Binaire est vide.
     * @throws EmptyStackExceptions s'il y a un problème avec la pile pendant le parcours.
     */
    public List<Integer> inOrder() throws BSTException, EmptyStackExceptions {
        if (this.isEmpty())
            throw new BSTException("BST is empty");

        Stack<Node> nodes = new DynamicStack<>();
        ArrayList<Integer> inOrderTraversal = new ArrayList<>();
        Node current = this.root;

        //je comprends pas pk ça push les null dans la stack alors que j'ai mon if current != null :=(
        while (current != null || !nodes.isEmpty()) {
            if (current != null) {
                nodes.push(current);
                current = current.getLeft();
            } else {
                Node poppedNode = nodes.pop();
                inOrderTraversal.add(poppedNode.getValue());
                current = poppedNode.getRight();
            }
        }

        return inOrderTraversal;
    }


    /**
     * Effectue un parcours pré-ordonné de l'Arbre de recherche binaire.
     *
     * @return Liste d'entiers représentant le parcours pré-ordonné.
     */
    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> preOrderTraversal = new ArrayList<>();
        preOrder(root, preOrderTraversal);
        return preOrderTraversal;
    }

    private void preOrder(Node node, ArrayList<Integer> traversal) {
        if (node != null) {
            traversal.add(node.getValue());
            preOrder(node.getLeft(), traversal);
            preOrder(node.getRight(), traversal);
        }
    }

    /**
     * Effectue un parcours post-ordonné de l'Arbre de recherche binaire.
     *
     * @return Liste d'entiers représentant le parcours post-ordonné.
     */
    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> postOrderTraversal = new ArrayList<>();
        postOrder(root, postOrderTraversal);
        return postOrderTraversal;
    }

    private void postOrder(Node node, ArrayList<Integer> traversal) {
        if (node != null) {
            postOrder(node.getLeft(), traversal);
            postOrder(node.getRight(), traversal);
            traversal.add(node.getValue());
        }
    }

    /**
     * Calcule la largeur de l'Arbre de recherche binaire.
     *
     * @return La largeur de l'Arbre de recherche binaire.
     */
    public int breadth() {
        return breadth(root);
    }

    private int breadth(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) * NBMAXNODES;
    }

    /**
     * Obtient la valeur maximale dans l'Arbre de recherche binaire.
     *
     * @return La valeur maximale dans l'Arbre de recherche binaire.
     * @throws BSTException si l'Arbre de recherche binaire est vide.
     */
    public Integer getMaxValue() throws BSTException {
        if (isEmpty())
            throw new BSTException("BST is empty");

       return maxValue(this.root);
    }

    public Integer maxValue(Node node){
        Integer maxValue = node.getValue();
        while (node.getRight() != null) {
            if (node.getRight().getValue() != null)
                maxValue = node.getRight().getValue();
            node = node.getRight();
        }
        return maxValue;
    }

    /**
     * Obtient la valeur minimale dans l'Arbre de recherche binaire.
     *
     * @return La valeur minimale dans l'Arbre de recherche binaire.
     * @throws BSTException si l'Arbre de recherche binaire est vide.
     */
    public Integer getMinValue() throws BSTException {
        if (isEmpty())
            throw new BSTException("BST is empty");

        return minValue(this.root);
    }

    private Integer minValue(Node node) {
        Integer minValue = node.getValue();
        while (node.getLeft() != null) {
            if (node.getLeft().getValue() != null)
                minValue = node.getLeft().getValue();
            node = node.getLeft();
        }
        return minValue;
    }

    /**
     * Calcule la hauteur de l'Arbre de recherche binaire.
     *
     * @return La hauteur de l'Arbre de recherche binaire.
     */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Compte le nombre de nœuds non-nuls dans l'Arbre de recherche binaire.
     *
     * @return Le nombre de nœuds non-nuls dans l'Arbre de recherche binaire.
     */
    public int nbNodes() {
        return nbNodes(root);
    }

    private int nbNodes(Node node) {
        if (node == null)
            return 0;

        int leftNodes = nbNodes(node.getLeft());
        int rightNodes = nbNodes(node.getRight());

        return leftNodes + rightNodes + 1;
    }


    /**
     * Recherche un nœud avec la valeur spécifiée dans l'Arbre de recherche binaire.
     *
     * @param value La valeur à rechercher.
     * @throws BSTException si l'Arbre de recherche binaire est vide
     * @return Vrai si la valeur à rechercher est présente dans l'Arbre de recherche binaire, faux sinon.
     */
    public boolean search(Integer value) throws BSTException{
        if (this.isEmpty()){
            throw new BSTException("BST is empty");
        }
        return search(value, root);
    }

    private boolean search(Integer value, Node node) {
        if (node == null)
            return false;
        if (value.equals(node.getValue()))
            return true;

        if (value < node.getValue())
            return search(value, node.getLeft());
        else
            return search(value, node.getRight());
    }


    /**
     * Supprime un nœud avec la valeur spécifiée de l'Arbre de recherche binaire si elle existe.
     *
     * @param value La valeur à supprimer.
     * @throws BSTException si la valeur à supprimer n'appartient pas à l'arbre.
     */
    public void remove(Integer value) throws BSTException {
        if (!this.search(value))
            throw new BSTException("The value '" + value + "' can't be removed because it doesn't belong to the tree");

        root = remove(value, root);
    }

    private Node remove(Integer value, Node node) {
        if (node == null)
            return null;

        if (value < node.getValue()) {
            node.setLeft(remove(value, node.getLeft()));
        } else if (value > node.getValue()) {
            node.setRight(remove(value, node.getRight()));
        } else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            node.setValue(minValue(node.getRight()));

            node.setRight(remove(node.getValue(), node.getRight()));
        }

        return node;
    }


    public boolean isEmpty() {
        return this.root == null || this.root.getValue() == null;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'Arbre de recherche binaire.
     *
     * @return La représentation sous forme de chaîne de caractères de l'Arbre de recherche binaire.
     */
    @Override
    public String toString() {
        if (this.isEmpty())
            return "BST is empty";

        try {
            return "BST : " + inOrder();
        } catch (BSTException | EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Integer getMeanValue() throws BSTException, EmptyStackExceptions {
        List<Integer> allValues = inOrder();
        int sum = 0;
        for (Integer value : allValues)
                sum += value;

        return sum / allValues.size();
    }
}
