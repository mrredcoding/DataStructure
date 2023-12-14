package TP5.queue;

/**
 * Exception levée lorsqu'une opération est effectuée sur une file.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class QueueException extends Exception {

    /**
     * Construit une nouvelle exception avec le message spécifié.
     *
     * @param message Le message d'erreur associé à l'exception.
     */
    public QueueException(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }

}
