package TP2.dynamicStack;

import TP2.stack.Stack;
import TP2.utils.Test;
public class Main {

    public static void main(String[] args) {

        Stack<String> dynamicStack = new DynamicStack<>();

        System.out.println(Test.titleBox(dynamicStack.getClass().getSimpleName()));

        dynamicStack.push("Alonso");
        dynamicStack.push("Hatoum");
        dynamicStack.push("Piles");

        Test.display(dynamicStack);

        Test.pop(dynamicStack);

        Test.display(dynamicStack);

        Test.top(dynamicStack);

        Test.pop(dynamicStack);

        Test.display(dynamicStack);

        Test.pop(dynamicStack);

        Test.display(dynamicStack);
    }
}
