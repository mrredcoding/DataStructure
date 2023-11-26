package TP2.utils;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

/**
 * Classe utilitaire pour afficher des informations sur les piles.
 * Fournit des méthodes statiques pour générer des boîtes de titre stylisées,
 * afficher le sommet et le contenu d'une pile, et traiter les opérations de pop.
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class Test {

    /**
     * Génère une boîte de titre stylisée pour afficher un titre.
     *
     * Utilise des caractères encodés en UTF-8 pour créer une boîte de titre stylisée.
     * Les lignes de la boîte sont constituées de caractères de ligne horizontale (─),
     * de coins (┌, └, ┐, ┘), et d'espaces entourant le titre.
     *
     * @param title Le titre à afficher dans la boîte.
     * @return Une chaîne représentant la boîte de titre stylisée.
     */
    public static String titleBox(String title) {
        String repeat = "─".repeat(Math.max(0, title.length() + 2));

        return "\u001B[34m" +
                System.lineSeparator() +
                "┌" + repeat +  "┐" +
                System.lineSeparator() +
                "│ " + title + " │" +
                System.lineSeparator() +
                "└" + repeat +  "┘" +
                "\u001B[0m";
    }


    /**
     * Affiche et retire le sommet de la pile.
     *
     * @param stack La pile à manipuler.
     */
    public static void pop(Stack<?> stack){
        try {
            System.out.println(stack.getClass().getSimpleName() + " Popped value = " + stack.pop());
            System.out.println();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Affiche le sommet de la pile sans le retirer.
     *
     * @param stack La pile à inspecter.
     */
    public static void top(Stack<?> stack){
        try {
            System.out.println(stack.getClass().getSimpleName() + " Top value = " + stack.top());
            System.out.println();
        } catch (EmptyStackExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Affiche le contenu complet de la pile.
     *
     * @param stack La pile à afficher.
     */
    public static void display(Stack<?> stack){
        try {
            System.out.println(stack.getClass().getSimpleName() + " Contents :");
            stack.display();
            System.out.println();
        } catch (EmptyStackExceptions e){
            System.out.println(e.getMessage());
        }
    }
}
