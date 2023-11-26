package TP2.stack;

public class EmptyStackExceptions extends Exception {

    public EmptyStackExceptions(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }

}
