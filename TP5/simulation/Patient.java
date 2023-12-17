package TP5.simulation;

/**
 * La classe Patient modélise un patient avec des attributs tels que l'heure d'arrivée et la durée de l'examen.
 * Chaque patient se voit attribuer un nom unique commençant par "P1".
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
class Patient {
    private static int idCpt = 0;
    private final String name;
    private final int arrivalTime;
    private final int examinationDuration;

    /**
     * Construit un patient avec l'heure d'arrivée et la durée d'examen spécifiées.
     *
     * @param arrivalTime          L'heure à laquelle le patient arrive.
     * @param examinationDuration La durée de l'examen pour le patient.
     */
    public Patient(int arrivalTime, int examinationDuration) {
        this.name = "P" + ++idCpt;
        this.arrivalTime = arrivalTime;
        this.examinationDuration = examinationDuration;
    }

    /**
     * Récupère le nom du patient.
     *
     * @return Le nom du patient.
     */
    public String getName() {
        return name;
    }

    /**
     * Récupère l'heure d'arrivée du patient.
     *
     * @return L'heure d'arrivée du patient.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Récupère la durée de l'examen du patient.
     *
     * @return La durée de l'examen du patient.
     */
    public int getExaminationDuration() {
        return examinationDuration;
    }
}
