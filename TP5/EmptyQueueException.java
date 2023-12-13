package TP5;

/**
 * Exception levée lorsqu'une opération est effectuée sur une file vide.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class EmptyQueueException extends Exception {

    /**
     * Construit une nouvelle exception avec le message spécifié.
     *
     * @param message Le message d'erreur associé à l'exception.
     */
    public EmptyQueueException(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }

}
