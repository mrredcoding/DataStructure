package TP1.historique;

public class HistoriqueException extends Exception {

    public HistoriqueException(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }

}
