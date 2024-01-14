package TP6;

import TP2.stack.EmptyStackExceptions;
import TP2.utils.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BSTException, EmptyStackExceptions {
        BST bst = new BST();
        Menu.start(bst);
    }

}