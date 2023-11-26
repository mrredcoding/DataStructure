package TP2.staticStack;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

public class StaticStack<T> implements Stack<T> {
    private int max;
    private T[] tab;
    private int top = -1;

    public StaticStack(int max){
        this.max = max;
        this.tab = (T[]) new Object[this.max];
    }

    @Override
    public void push(T value) {
        if (top == max - 1) {
            // If the stack is full, create a new array with double the size
            T[] newTab = (T[]) new Object[max * 2];
            System.arraycopy(tab, 0, newTab, 0, max);
            tab = newTab;
            max *=2 ;
        }
        tab[++top] = value;
    }

    @Override
    public T pop() throws EmptyStackExceptions {
        if (top >= 0) {
            return tab[top--];
        } else {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
    }

    @Override
    public T top() throws EmptyStackExceptions {
        if (top >= 0) {
            return tab[top];
        } else {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
    }

    @Override
    public void display() throws EmptyStackExceptions{
        if (top >= 0) {
            for (int i = 0; i <= top; i++) {
                System.out.print(tab[i] + " ");
            }
        } else {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
        System.out.println();
    }
}
