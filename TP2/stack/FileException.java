package TP2.stack;

/**
 * Exception spécifique pour les erreurs liées aux opérations sur les fichiers dans le contexte de la pile.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
public class FileException extends Exception {

    /**
     * Construit une nouvelle exception avec le message spécifié.
     *
     * @param message Le message d'erreur associé à l'exception.
     */
    public FileException(String message){
        super("\u001B[31m" + message + "\u001B[0m");
    }
}
