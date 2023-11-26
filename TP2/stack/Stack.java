package TP2.stack;

public interface Stack<T> {
    void push(T value);
    T pop() throws EmptyStackExceptions;
    T top() throws EmptyStackExceptions;
    void display() throws EmptyStackExceptions;
}
