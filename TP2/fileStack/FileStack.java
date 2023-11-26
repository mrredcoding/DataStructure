package TP2.fileStack;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.FileException;
import TP2.stack.Stack;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implémentation d'une pile basée sur un fichier.
 *
 * @param <T> Le type des éléments stockés dans la pile.
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class FileStack<T> implements Stack<T> {

    private String filename;
    private int top_offset;

    /**
     * Constructeur de la classe FileStack.
     *
     * @param filename Le nom du fichier utilisé pour stocker les éléments de la pile.
     */
    public FileStack(String filename) {
        this.filename = filename;
        this.top_offset = -1;
    }

    @Override
    public void push(T value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(value.toString());
            writer.newLine();
            top_offset++;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public T pop() throws EmptyStackExceptions {
        if (top_offset < 0) {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
        List<String> lines = readFile();
        assert lines != null;
        T topElement = (T) lines.get(top_offset);
        top_offset--;
        writeFile(lines);
        return topElement;
    }

    @Override
    public T top() throws EmptyStackExceptions {
        if (top_offset < 0) {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }
        return (T) Objects.requireNonNull(readFile()).get(top_offset);
    }

    @Override
    public void display() throws EmptyStackExceptions {
        if (top_offset < 0) {
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }

        System.out.println("Nom du fichier : " + this.filename);
        List<String> lines = readFile();
        assert lines != null;

        for (int i = top_offset; i >= 0; i--) {
            System.out.println("\t- " + lines.get(i));
        }
    }

    /**
     * Lit les lignes du fichier associé à la pile.
     *
     * @return Une liste de chaînes représentant les lignes du fichier.
     *         Retourne null en cas d'erreur de lecture.
     */
    private List<String> readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Écrit les lignes fournies dans le fichier associé à la pile.
     *
     * @param lines La liste de chaînes à écrire dans le fichier.
     *              Chaque élément de la liste représente une ligne du fichier.
     */
    private void writeFile(List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    /**
     * Modifie le nom du fichier utilisé pour stocker les éléments de la pile.
     * Renomme également le fichier sur le disque.
     *
     * @param fileName Le nouveau nom du fichier.
     */
    public void setFilename(String fileName) throws FileException {
        File oldFile = new File(this.filename);
        File newFile = new File(fileName);

        if (oldFile.exists())
            if (oldFile.renameTo(newFile))
                this.filename = fileName;
            else
                throw new FileException("Impossible de renommer le fichier.");

        else
            throw new FileException("Le fichier d'origine n'existe pas.");

    }
}
