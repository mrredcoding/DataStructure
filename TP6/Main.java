package TP6;

import TP2.stack.EmptyStackExceptions;
import TP2.utils.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws BSTException, EmptyStackExceptions {

        BST bst = new BST();
        
       menu(bst);

    }

    private static void menu(BST bst){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            displayMenu();
            System.out.print("Enter your choice :");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.err.println("Your choice must be an integer ");
            }
            switch(choice){
                case 1:
                    adding(bst);
                    break;
                case 2:
                    searching(bst);
                    break;
                case 3:
                    removing(bst);
                    break;
                case 4:
                    try {
                        displayStatistics(bst);
                    } catch (BSTException | EmptyStackExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    choice = 0;
                default:
                    System.err.println("Your choice must be in [1;5]");
            }
        } while (choice!=0);

        exit();
    }
    private static void displayMenu(){
        System.out.println(Test.titleBox("******** MENU ********"));
        System.out.println("1. Add new nodes to the Binary Search Tree");
        System.out.println("2. Search for nodes in the Binary Search Tree");
        System.out.println("3. Remove nodes from the Binary Search Tree");
        System.out.println("4. Display some statistics of the Binary Search Tree");
        System.out.println("5. Exit the program");
    }

    private static void removing(BST bst) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter a number to remove in the binary search tree : (type 'stop' to continue)");
            choice = scanner.next();
            if (!"stop".equalsIgnoreCase(choice))
                try{
                    int number = Integer.parseInt(choice);
                    boolean found = bst.search(number);

                    System.out.println("The number '" + number + "' has " + (!found ? "not":"") + " been removed" +
                            " from the binary search tree ");
                } catch (NumberFormatException e){
                    System.out.println("You need to type only numbers or 'stop'");
                    choice = "continue";
                } catch (BSTException e){
                    System.out.println(e.getMessage());
                    choice = "stop";
                }

        } while (!"stop".equalsIgnoreCase(choice));

        scanner.close();
    }

    private static void searching(BST bst) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter a number to find in the binary search tree : (type 'stop' to continue)");
            choice = scanner.next();
            if (!"stop".equalsIgnoreCase(choice))
                try{
                    int number = Integer.parseInt(choice);
                    boolean found = bst.search(number);

                    System.out.println("The number '" + number + "' is " + (!found ? "not":"") + " in the binary search tree ");
                } catch (NumberFormatException e){
                    System.out.println("You need to type only numbers or 'stop'");
                    choice = "continue";
                } catch (BSTException e){
                    System.out.println(e.getMessage());
                    choice = "stop";
                }

        } while (!"stop".equalsIgnoreCase(choice));
        scanner.close();
    }

    private static void adding(BST bst){
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter a number to add in the binary search tree : (type 'stop' when you are done)");
            choice = scanner.next();
            if (!"stop".equalsIgnoreCase(choice))
                try{
                    int number = Integer.parseInt(choice);
                    bst.insert(number);
                    System.out.println("The number '" + number + "' has been added" +
                            " to the binary search tree ");
                } catch (NumberFormatException e){
                    System.out.println("You need to type only numbers or 'stop'");
                    choice = "continue";
                }

        } while (!"stop".equalsIgnoreCase(choice));
        scanner.close();
    }

    private static void displayStatistics(BST bst) throws BSTException, EmptyStackExceptions {
        System.out.println("In order : " + bst.inOrder());
        System.out.println("Post order : " + bst.postOrder());
        System.out.println("Pre order : " + bst.preOrder());

        System.out.println("Minimal value : " + bst.getMinValue());
        System.out.println("Maximal value : " + bst.getMaxValue());
        System.out.println("Mean value : " + bst.getMeanValue());

        System.out.println("Height : " + bst.height());
        System.out.println("Breadth : " + bst.breadth());

        System.out.println("Number of nodes : " + bst.nbNodes());
    }

    private static void exit(){
        System.out.println("You exited the program ^w^");
        System.exit(0);
    }
}
