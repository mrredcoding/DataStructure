package TP6;

public class Node{

    private Integer value;

    private Node left;

    private Node right;

    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public Node(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    @Override
    public String toString(){
        return String.valueOf(this.value);
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
