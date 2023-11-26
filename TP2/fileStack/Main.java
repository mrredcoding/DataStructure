package TP2.fileStack;

import TP2.stack.Stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import TP2.utils.Test;
public class Main {

    public static void main(String[] args) {
        String fileName = "habibis.txt";
        Stack<String> fileStack = new FileStack<>(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(Test.titleBox(fileStack.getClass().getSimpleName()));

        fileStack.push("Alonso Cédric 21");
        fileStack.push("Jade Hatoum 20");
        fileStack.push("File Stack 1");

        Test.display(fileStack);

        Test.pop(fileStack);

        Test.display(fileStack);

        Test.top(fileStack);

        Test.pop(fileStack);

        Test.display(fileStack);

        Test.pop(fileStack);

        Test.display(fileStack);
    }
}
