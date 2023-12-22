package TP6;

/**
 * Exception levée lorsqu'une opération est effectuée sur une file.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class BSTException extends Exception {

    /**
     * Construit une nouvelle exception avec le message spécifié concernant les arbres de recherches binaires.
     *
     * @param message Le message d'erreur associé à l'exception.
     */
    public BSTException(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }

}
