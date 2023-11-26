package TP2.dynamicStack;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

/**
 * Implémentation d'une pile dynamique basée sur une liste chaînée.
 *
 * @param <T> Le type des éléments stockés dans la pile.
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class DynamicStack<T> implements Stack<T> {

    /**
     * Représente un nœud dans la liste chaînée utilisée pour implémenter la pile.
     */
    private class Node {
        private final T val;
        private Node next;

        /**
         * Construit un nouveau nœud avec la valeur spécifiée.
         *
         * @param value La valeur du nœud.
         */
        Node(T value) {
            val = value;
            next = null;
        }
    }

    private Node top;

    /**
     * Constructeur de la classe DynamicStack.
     * Initialise une nouvelle pile dynamique vide.
     */
    public DynamicStack() {
        this.top = null;
    }

    @Override
    public void push(T value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public T pop() throws EmptyStackExceptions {
        if (top != null) {
            T value = top.val;
            top = top.next;
            return value;
        } else {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
    }

    @Override
    public T top() throws EmptyStackExceptions {
        if (top != null) {
            return top.val;
        } else {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
    }

    @Override
    public void display() throws EmptyStackExceptions {
        Node current = top;
        if (current == null) {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println();
    }
}
