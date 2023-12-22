package TP6;

import TP2.stack.EmptyStackExceptions;
import TP5.queue.QueueException;

public class Main {

    public static void main(String[] args) throws BSTException, EmptyStackExceptions {

        BST bst = new BST();

        bst.insert(50);
        bst.insert(45);
        bst.insert(65);
        bst.insert(55);
        bst.insert(54);
        bst.insert(56);
        bst.insert(80);
        bst.insert(70);
        bst.insert(85);
        bst.insert(30);
        bst.insert(47);

        System.out.println(bst.inOrder());


    }
}
