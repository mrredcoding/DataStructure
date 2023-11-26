package TP2.staticStack;

import TP2.stack.Stack;
import TP2.utils.Test;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> staticStack = new StaticStack<>(100);

        System.out.println(Test.titleBox(staticStack.getClass().getSimpleName()));

        staticStack.push(5);
        staticStack.push(6);
        staticStack.push(7);

        Test.display(staticStack);

        Test.pop(staticStack);

        Test.display(staticStack);

        Test.top(staticStack);

        Test.pop(staticStack);

        Test.display(staticStack);

        Test.pop(staticStack);

        Test.display(staticStack);
    }
}
