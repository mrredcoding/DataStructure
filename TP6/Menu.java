package TP6;

import TP2.stack.EmptyStackExceptions;
import TP2.utils.Test;
import org.jetbrains.annotations.NotNull;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Menu class provides a menu-driven interface for users to perform various operations on a BST, including
 * adding, searching, and removing nodes, as well as displaying statistics about the BST.
 * The user interacts with the program through the console by choosing options from the menu.
 * The program handles user input, performs the requested operations on the BST, and displays the results.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Menu {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";

    private static final String[] OPTIONS = {
            "1. Add new nodes to the Binary Search Tree",
            "2. Search for nodes in the Binary Search Tree",
            "3. Remove nodes from the Binary Search Tree",
            "4. Display some statistics of the Binary Search Tree",
            "5. Exit the program"
    };

    /**
     * The start method handles the main interaction loop, allowing the user to choose various operations
     * on the Binary Search Tree until the program is exited.
     *
     * @param bst The Binary Search Tree instance
     */
    public static void start(@NotNull BST bst) {
        int choice = 0;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = SCANNER.nextInt();
                switch (choice) {
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
                        displayStatistics(bst);
                        break;
                    case 5:
                        exit();
                    default:
                        System.err.println("Your choice must be in the range [1;" + OPTIONS.length + "]");
                        SCANNER.nextLine();
                }
            } catch (InputMismatchException e) {
                System.err.println("Your choice must be an integer");
                SCANNER.nextLine();
            }

        } while (choice != OPTIONS.length);
    }

    /**
     * Displays the main menu with available options for the user.
     */
    private static void displayMenu() {
        System.out.println(Test.titleBox("******** MENU ********"));
        for (String option : OPTIONS)
            System.out.println(option);
    }

    /**
     * Handles the removal of nodes from the Binary Search Tree based on user input.
     *
     * @param bst The Binary Search Tree instance
     */
    private static void removing(@NotNull BST bst) {
        if (bst.isEmpty()) {
            System.err.println("BST is empty");
            return;
        }

        String choice;
        do {
            System.out.println("Enter a number to remove in the binary search tree: (type '" + STOP +"' to continue)");
            choice = SCANNER.next();
            if (!STOP.equalsIgnoreCase(choice)) {
                try {
                    int number = Integer.parseInt(choice);
                    boolean found = bst.search(number);

                    if (found) {
                        bst.remove(number);
                        System.out.println("The number '" + number + "' has been removed from the binary search tree");
                    }
                    else
                        System.out.println("The number '" + number + "' does not belong to the tree");

                } catch (NumberFormatException e) {
                    System.err.println("You need to type only numbers or '" + STOP +"'");
                    choice = CONTINUE;
                } catch (BSTException e) {
                    System.out.println(e.getMessage());
                    choice = STOP;
                }
            }

        } while (!STOP.equalsIgnoreCase(choice));
    }

    /**
     * Handles the searching of nodes in the Binary Search Tree based on user input.
     *
     * @param bst The Binary Search Tree instance
     */
    private static void searching(@NotNull BST bst) {
        if (bst.isEmpty()) {
            System.err.println("BST is empty");
            return;
        }
        String choice;
        do {
            System.out.println("Enter a number to find in the binary search tree: (type '" + STOP +"' to continue)");
            choice = SCANNER.next();
            if (!STOP.equalsIgnoreCase(choice)) {
                try {
                    int number = Integer.parseInt(choice);
                    boolean found = bst.search(number);

                    System.out.println("The number '" + number + "' is " + (!found ? "not" : "") +
                            " in the binary search tree");
                } catch (NumberFormatException e) {
                    System.err.println("You need to type only numbers or '" + STOP +"'");
                    choice = CONTINUE;
                } catch (BSTException e) {
                    System.out.println(e.getMessage());
                    choice = STOP;
                }
            }

        } while (!STOP.equalsIgnoreCase(choice));
    }

    /**
     * Handles the addition of nodes to the Binary Search Tree based on user input.
     *
     * @param bst The Binary Search Tree instance
     */
    private static void adding(BST bst) {
        String choice;
        do {
            System.out.println("Enter a number to add in the binary search tree: (type '" + STOP +"' when you are done)");
            choice = SCANNER.next();
            if (!STOP.equalsIgnoreCase(choice)) {
                try {
                    int number = Integer.parseInt(choice);
                    bst.insert(number);
                    System.out.println("The number '" + number + "' has been added to the binary search tree");
                } catch (NumberFormatException e) {
                    System.err.println("You need to type only numbers or '" + STOP +"'");
                    choice = CONTINUE;
                }
            }

        } while (!STOP.equalsIgnoreCase(choice));
    }

    /**
     * Displays various statistics of the Binary Search Tree, such as in-order, post-order, and pre-order traversals,
     * as well as minimum, maximum, and mean values, height, breadth, and the number of nodes.
     *
     * @param bst The Binary Search Tree instance
     */
    private static void displayStatistics(@NotNull BST bst) {
        try {
            System.out.println("In order: " + bst.inOrder());
            System.out.println("Post order: " + bst.postOrder());
            System.out.println("Pre order: " + bst.preOrder());

            System.out.println("Minimal value: " + bst.getMinValue());
            System.out.println("Maximal value: " + bst.getMaxValue());
            System.out.println("Mean value: " + bst.getMeanValue());

            System.out.println("Height: " + bst.height());
            System.out.println("Breadth search: " + bst.breadthFirstSearch());

            System.out.println("Number of nodes: " + bst.nbNodes());
        } catch (BSTException | EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Exits the program, displaying a farewell message.
     */
    private static void exit() {
        System.out.println("You exited the program ^w^");
        System.exit(0);
    }
}
