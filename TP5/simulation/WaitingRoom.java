package TP5.simulation;

import TP5.queue.Queue;
import TP5.queue.QueueException;

/**
 * La classe WaitingRoom modélise une salle d'attente où les patients sont traités dans l'ordre d'arrivée.
 * Elle permet d'ajouter des patients à la salle d'attente et de simuler le traitement de ceux-ci.
 *
 * @version 1.0
 * @author Cédric Alonso
 * @author Jade Hatoum
 */
class WaitingRoom {
    public static final int MAX_PATIENTS = 100;
    private final Queue<Patient> waitingRoom;

    /**
     * Constructeur de la salle d'attente.
     */
    public WaitingRoom() {
        waitingRoom = new Queue<>(MAX_PATIENTS);
    }

    /**
     * Ajoute un patient à la salle d'attente.
     *
     * @param patient Le patient à ajouter.
     * @throws QueueException Si la file est pleine.
     */
    public void addPatient(Patient patient) throws QueueException {
        waitingRoom.push(patient);
    }

    /**
     * Récupère et retourne le patient arrivant le plus tôt dans la salle d'attente.
     *
     * @return Le patient arrivant le plus tôt dans la salle d'attente.
     * @throws QueueException Si la salle d'attente est vide.
     */
    public Patient getNextEearliestPatient() throws QueueException {
        Patient currentEarliestPatient = waitingRoom.pop();
        for(int i = 0; i < waitingRoom.getNbElements(); i++){
            Patient currentPatient = waitingRoom.pop();
            if(currentPatient.getArrivalTime() < currentEarliestPatient.getArrivalTime()) {
                waitingRoom.push(currentEarliestPatient);
                currentEarliestPatient = currentPatient;
            } else {
                waitingRoom.push(currentPatient);
            }
        }
        return currentEarliestPatient;
    }

    /**
     * Simule le déroulement du traitement des patients en fonction de leur heure d'arrivée
     * et de la durée de leur examen.
     *
     * @throws QueueException Si la salle d'attente est vide.
     */
    public void simulate() throws QueueException {
        int totalWaitTime = 0;
        int totalGlobalTime = 0;
        int nbPatients = waitingRoom.getNbElements();
        int currentTime = 0;

        while (!waitingRoom.isEmpty()) {
            Patient currentPatient = getNextEearliestPatient();
            int arrivalTime = currentPatient.getArrivalTime();

            currentTime = Math.max(currentTime, arrivalTime);

            int waitTime = currentTime - arrivalTime;
            int globalTime = waitTime + currentPatient.getExaminationDuration();

            int startExaminationTime = currentTime;
            int endExaminationTime = startExaminationTime + currentPatient.getExaminationDuration();

            System.out.println(startExaminationTime + " - " + endExaminationTime + " min : " + currentPatient.getName() + " is being examined.");
            currentTime = endExaminationTime;

            totalWaitTime += waitTime;
            totalGlobalTime += globalTime;
        }

        double averageGlobalTime = (double) totalGlobalTime / nbPatients;
        double averageWaitTime = (double) totalWaitTime / nbPatients;

        System.out.println("\nTotal Simulation Time: " + currentTime + " minutes.");
        System.out.println("\nAverage Global Time: " + averageGlobalTime + " minutes.");
        System.out.println("Average Waiting Time: " + averageWaitTime + " minutes.");
    }
}
