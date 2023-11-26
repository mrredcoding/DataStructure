package TP2.staticStack;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

/**
 * Implémentation d'une pile statique avec redimensionnement automatique.
 *
 * @param <T> Le type des éléments stockés dans la pile.
 * @version 1.0
 * @author Votre Nom
 */
public class StaticStack<T> implements Stack<T> {

    private int max;
    private T[] tab;
    private int top;

    /**
     * Constructeur de la classe StaticStack.
     *
     * @param max La capacité initiale de la pile.
     */
    public StaticStack(int max) {
        this.top = -1;
        this.max = max;
        this.tab = (T[]) new Object[this.max];
    }

    @Override
    public void push(T value) {
        if (top == max - 1) {
            // Si la pile est pleine, crée un nouveau tableau avec le double de la taille
            T[] newTab = (T[]) new Object[max * 2];
            System.arraycopy(tab, 0, newTab, 0, max);
            tab = newTab;
            max *= 2;
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
    public void display() throws EmptyStackExceptions {
        if (top >= 0) {
            for (int i = top; i >= 0; i--) {
                System.out.println(tab[i]);
            }
        } else {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
        System.out.println();
    }
}
