package TP2.dynamicStack;

import TP2.stack.Stack;
import TP2.utils.Test;

/**
 * Programme de test pour la classe DynamicStack.
 * Crée une pile dynamique, effectue des opérations de push et pop, et affiche les résultats.
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
        // Crée une pile dynamique de chaînes.
        Stack<String> dynamicStack = new DynamicStack<>();

        // Affiche une boîte de titre stylisée avec le nom de la classe de la pile.
        System.out.println(Test.titleBox(dynamicStack.getClass().getSimpleName()));

        // Effectue des opérations de push sur la pile.
        dynamicStack.push("Alonso");
        dynamicStack.push("Hatoum");
        dynamicStack.push("Piles");

        // Affiche le contenu de la pile.
        Test.display(dynamicStack);

        // Effectue une opération de pop et affiche le résultat.
        Test.pop(dynamicStack);

        // Affiche à nouveau le contenu de la pile après la première opération de pop.
        Test.display(dynamicStack);

        // Affiche le sommet de la pile sans le retirer.
        Test.top(dynamicStack);

        // Effectue une deuxième opération de pop et affiche le résultat.
        Test.pop(dynamicStack);

        // Affiche à nouveau le contenu de la pile après la deuxième opération de pop.
        Test.display(dynamicStack);

        // Effectue une troisième opération de pop (pile vide) et affiche le résultat.
        Test.pop(dynamicStack);

        // Affiche à nouveau le contenu de la pile après la troisième opération de pop.
        Test.display(dynamicStack);
    }
}
