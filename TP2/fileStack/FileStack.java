package TP2.fileStack;

import TP2.stack.EmptyStackExceptions;
import TP2.stack.Stack;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileStack<T> implements Stack<T> {
    private String filename;
    private int top_offset;

    public FileStack(String filename){
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
    public void display() throws EmptyStackExceptions{
        if (top_offset < 0){
            throw new EmptyStackExceptions(this.getClass().getSimpleName() + " is empty !");
        }

        List<String> lines = readFile();
        assert lines != null;

        for (int i = top_offset; i >=0 ; i--){
            System.out.println("- " + lines.get(i));
        }
    }

    private List<String> readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

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

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
