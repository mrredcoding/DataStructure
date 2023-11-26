package TP2.staticStack;

import TP2.stack.Stack;
import TP2.utils.Test;

/**
 * Programme de test pour la classe StaticStack.
 * Crée une pile statique, effectue des opérations de push et pop, et affiche les résultats.
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Main {

    /**
     * Méthode principale du programme de test.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans ce programme).
     */
    public static void main(String[] args) {
        // Crée une pile statique d'entiers avec une capacité initiale de 100.
        Stack<Integer> staticStack = new StaticStack<>(100);

        // Affiche une boîte de titre stylisée avec le nom de la classe de la pile.
        System.out.println(Test.titleBox(staticStack.getClass().getSimpleName()));

        // Effectue des opérations de push sur la pile.
        staticStack.push(5);
        staticStack.push(6);
        staticStack.push(7);

        // Affiche le contenu de la pile.
        Test.display(staticStack);

        // Effectue une opération de pop et affiche le résultat.
        Test.pop(staticStack);

        // Affiche à nouveau le contenu de la pile après la première opération de pop.
        Test.display(staticStack);

        // Affiche le sommet de la pile sans le retirer.
        Test.top(staticStack);

        // Effectue une deuxième opération de pop et affiche le résultat.
        Test.pop(staticStack);

        // Affiche à nouveau le contenu de la pile après la deuxième opération de pop.
        Test.display(staticStack);

        // Effectue une troisième opération de pop (pile vide) et affiche le résultat.
        Test.pop(staticStack);

        // Affiche à nouveau le contenu de la pile après la troisième opération de pop.
        Test.display(staticStack);
    }
}

