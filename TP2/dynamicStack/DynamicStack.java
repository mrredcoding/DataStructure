package TP2.dynamicStack;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

public class DynamicStack<T> implements Stack<T> {
    private class Node {
        T val;
        Node next;

        Node(T value) {
            val = value;
            next = null;
        }
    }

    private Node top;

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
    public void display() throws EmptyStackExceptions{
        Node current = top;
        if (current == null){
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}