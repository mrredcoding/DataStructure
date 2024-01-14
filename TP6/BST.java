package TP6;

import TP2.stack.EmptyStackExceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Binary Search Tree (BST).
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class BST {

    /**
     * Maximum number of nodes for each level in the BST.
     */
    public static final int MAX_NODES_PER_LEVEL = 2;

    private Node root;

    /**
     * Constructs an empty Binary Search Tree.
     */
    public BST() {
        this.root = new Node();
    }

    /**
     * Inserts a value into the Binary Search Tree.
     *
     * @param value The value to insert.
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
     * Performs an in-order traversal of the Binary Search Tree.
     *
     * @return List of integers representing the in-order traversal.
     */
    public List<Integer> inOrder() {
        List<Integer> inOrderTraversal = new ArrayList<>();
        inOrder(root, inOrderTraversal);
        return inOrderTraversal;
    }

    private void inOrder(Node node, List<Integer> traversal) {
        if (node != null) {
            inOrder(node.getLeft(), traversal);
            traversal.add(node.getValue());
            inOrder(node.getRight(), traversal);
        }
    }

    /**
     * Performs a pre-order traversal of the Binary Search Tree.
     *
     * @return List of integers representing the pre-order traversal.
     */
    public List<Integer> preOrder() {
        List<Integer> preOrderTraversal = new ArrayList<>();
        preOrder(root, preOrderTraversal);
        return preOrderTraversal;
    }

    private void preOrder(Node node, List<Integer> traversal) {
        if (node != null) {
            traversal.add(node.getValue());
            preOrder(node.getLeft(), traversal);
            preOrder(node.getRight(), traversal);
        }
    }

    /**
     * Performs a post-order traversal of the Binary Search Tree.
     *
     * @return List of integers representing the post-order traversal.
     */
    public List<Integer> postOrder() {
        List<Integer> postOrderTraversal = new ArrayList<>();
        postOrder(root, postOrderTraversal);
        return postOrderTraversal;
    }

    private void postOrder(Node node, List<Integer> traversal) {
        if (node != null) {
            postOrder(node.getLeft(), traversal);
            postOrder(node.getRight(), traversal);
            traversal.add(node.getValue());
        }
    }

    /**
     * Calculates the width of the Binary Search Tree.
     *
     * @return The width of the Binary Search Tree.
     */
    public int breadth() {
        return breadth(root);
    }

    private int breadth(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) * MAX_NODES_PER_LEVEL;
    }

    /**
     * Gets the maximum value in the Binary Search Tree.
     *
     * @return The maximum value in the Binary Search Tree.
     * @throws BSTException if the Binary Search Tree is empty.
     */
    public Integer getMaxValue() throws BSTException {
        if (isEmpty())
            throw new BSTException("BST is empty");

        return maxValue(this.root);
    }

    private Integer maxValue(Node node) {
        Integer maxValue = node.getValue();
        while (node.getRight() != null) {
            if (node.getRight().getValue() != null)
                maxValue = node.getRight().getValue();
            node = node.getRight();
        }
        return maxValue;
    }

    /**
     * Gets the minimum value in the Binary Search Tree.
     *
     * @return The minimum value in the Binary Search Tree.
     * @throws BSTException if the Binary Search Tree is empty.
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
     * Gets the mean value of the Binary Search Tree.
     *
     * @return The mean value of the Binary Search Tree.
     * @throws BSTException          if the Binary Search Tree is empty.
     * @throws EmptyStackExceptions if there is an empty stack while calculating the mean value.
     */
    public Integer getMeanValue() throws BSTException, EmptyStackExceptions {
        List<Integer> allValues = inOrder();
        int sum = 0;
        for (Integer value : allValues)
            sum += value;

        return sum / allValues.size();
    }

    /**
     * Calculates the height of the Binary Search Tree.
     *
     * @return The height of the Binary Search Tree.
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
     * Counts the number of non-null nodes in the Binary Search Tree.
     *
     * @return The number of non-null nodes in the Binary Search Tree.
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
     * Searches for a node with the specified value in the Binary Search Tree.
     *
     * @param value The value to search for.
     * @throws BSTException if the Binary Search Tree is empty.
     * @return True if the value to search for is present in the Binary Search Tree, false otherwise.
     */
    public boolean search(Integer value) throws BSTException {
        if (this.isEmpty()) {
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
     * Removes a node with the specified value from the Binary Search Tree if it exists.
     *
     * @param value The value to remove.
     * @throws BSTException if the value to remove does not belong to the tree.
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

    /**
     * Checks if the Binary Search Tree is empty.
     *
     * @return True if the Binary Search Tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.root == null || this.root.getValue() == null;
    }

    /**
     * Returns a string representation of the Binary Search Tree.
     *
     * @return The string representation of the Binary Search Tree.
     */
    @Override
    public String toString() {
        if (this.isEmpty())
            return "BST is empty";

        return "BST : " + inOrder();
    }
}
