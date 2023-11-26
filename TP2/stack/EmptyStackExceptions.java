package TP2.stack;

/**
 * Exception levée lorsqu'une opération est effectuée sur une pile vide.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class EmptyStackExceptions extends Exception {

    /**
     * Construit une nouvelle exception avec le message spécifié.
     *
     * @param message Le message d'erreur associé à l'exception.
     */
    public EmptyStackExceptions(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }

}
