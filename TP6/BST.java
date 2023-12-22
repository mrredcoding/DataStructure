package TP6;

import TP2.dynamicStack.DynamicStack;
import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;
import TP5.queue.Queue;
import TP5.queue.QueueException;

import java.util.ArrayList;
import java.util.List;

public class BST {

    private Node root;

    public BST() {
        this.root = new Node();
    }

    public void insert(Integer value) {
        this.root = insert(value, this.root);
    }

    private Node insert(Integer value, Node source) {
        if (source.getValue() == null)
            return new Node(value);
        else if (value > source.getValue())
            source.setRight(insert(value, source.getRight()));
        else if (value <= source.getValue())
            source.setLeft(insert(value, source.getLeft()));

        return source;
    }

    public List<Integer> inOrder() throws BSTException, EmptyStackExceptions {
        if (this.isEmpty())
            throw new BSTException("Binary Search Tree is empty");

        Stack<Integer> nodes = new DynamicStack<>();

        ArrayList<Integer> inOrderTraversal = new ArrayList<>();

        Node current = this.root;
        while (current.getLeft() != null) {
            nodes.push(current.getValue());
            current = current.getLeft();
        }

        while(!nodes.isEmpty())
            inOrderTraversal.add(nodes.pop());

        return inOrderTraversal;
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> preOrderTraversal = new ArrayList<>();
        return preOrderTraversal;
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> postOrderTraversal = new ArrayList<>();
        return postOrderTraversal;
    }

    public int breadth() {
        return breadth(root);
    }

    private int breadth(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) * 2;
    }



    public Integer getMaxValue() throws BSTException {
        if (isEmpty())
            throw new BSTException("BST is empty");

        Node current = this.root;
        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getValue();
    }

    public Integer getMinValue() throws BSTException {
        if (isEmpty())
            throw new BSTException("BST is empty");

        Node current = this.root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current.getValue();
    }


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

    public Node search(Integer value) {
        return search(value, root);
    }

    private Node search(Integer value, Node node) {
        if (node == null || node.getValue().equals(value))
            return node;

        if (value < node.getValue())
            return search(value, node.getLeft());
        else
            return search(value, node.getRight());
    }

    public Node remove(Integer value) {
        return remove(value);
    }

    private boolean isEmpty() {
        return this.root == null || this.root.getValue() == null;
    }

    @Override
    public String toString(){
        if (this.isEmpty())
            return "Binary Search Tree is empty";

        return null;
    }
}
