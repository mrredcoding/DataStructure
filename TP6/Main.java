package TP6;

import TP2.stack.EmptyStackExceptions;

public class Main {

    public static void main(String[] args) throws BSTException, EmptyStackExceptions {
        BST bst = new BST();
        Menu.start(bst);
    }

}