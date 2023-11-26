package TP2.fileStack;

import TP2.stack.FileException;
import TP2.stack.Stack;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import TP2.utils.Test;

/**
 * Programme de test pour la classe FileStack.
 * Crée une pile basée sur un fichier, effectue des opérations de push et pop, et affiche les résultats.
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
        // Nom du fichier utilisé pour stocker les éléments de la pile.
        String fileName = "habibis.txt";

        // Réinitialise le contenu du fichier à une chaîne vide.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        // Crée une pile basée sur un fichier avec des chaînes comme éléments.
        FileStack<String> fileStack = new FileStack<>(fileName);

        // Affiche une boîte de titre stylisée avec le nom de la classe de la pile.
        System.out.println(Test.titleBox(fileStack.getClass().getSimpleName()));

        // Effectue des opérations de push sur la pile.
        fileStack.push("Alonso Cédric 21");
        fileStack.push("Jade Hatoum 20");
        fileStack.push("File Stack 1");

        // Affiche le contenu de la pile.
        Test.display(fileStack);

        // Effectue une opération de pop et affiche le résultat.
        Test.pop(fileStack);

        // Affiche à nouveau le contenu de la pile après la première opération de pop.
        Test.display(fileStack);

        // Affiche le sommet de la pile sans le retirer.
        Test.top(fileStack);

        // Effectue une deuxième opération de pop et affiche le résultat.
        Test.pop(fileStack);

        try{
            fileStack.setFilename("bébous.txt");
        } catch (FileException e){
            System.out.println(e.getMessage());
        }

        // Affiche à nouveau le contenu de la pile après la deuxième opération de pop.
        Test.display(fileStack);

        // Effectue une troisième opération de pop (pile vide) et affiche le résultat.
        Test.pop(fileStack);

        // Affiche à nouveau le contenu de la pile après la troisième opération de pop.
        Test.display(fileStack);
    }
}
