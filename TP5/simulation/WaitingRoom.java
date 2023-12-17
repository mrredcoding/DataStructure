package TP5.simulation;

import TP5.queue.Queue;
import TP5.queue.QueueException;


class WaitingRoom {
    public static final int MAX_PATIENTS = 100;
    private final Queue<Patient> waitingRoom;

    public WaitingRoom() {
        waitingRoom = new Queue<>(MAX_PATIENTS);
    }

    public void addPatient(Patient patient) throws QueueException {
        waitingRoom.push(patient);
    }

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

    public void simulate() throws QueueException {
        int totalWaitTime = 0;
        int totalGlobalTime = 0;
        int totalPatients = waitingRoom.getNbElements();
        int currentTime = 0;

        while (!waitingRoom.isEmpty()) {
            Patient currentPatient = getNextEearliestPatient();
            int minArrivalTime = currentPatient.getArrivalTime();

            currentTime = Math.max(currentTime, minArrivalTime);

            int waitTime = currentTime - minArrivalTime;
            int globalTime = waitTime + currentPatient.getExaminationDuration();

            int startExaminationTime = currentTime;
            int endExaminationTime = startExaminationTime + currentPatient.getExaminationDuration();

            System.out.println(startExaminationTime + " - " + endExaminationTime + " min : " + currentPatient.getName() + " is being examined.");
            currentTime = endExaminationTime;

            totalWaitTime += waitTime;
            totalGlobalTime += globalTime;
        }

        double averageGlobalTime = (double) totalGlobalTime / totalPatients;
        double averageWaitTime = (double) totalWaitTime / totalPatients;

        System.out.println("\nTotal Simulation Time: " + totalGlobalTime + " minutes.");
        System.out.println("\nAverage Global Time: " + averageGlobalTime + " minutes.");
        System.out.println("Average Waiting Time: " + averageWaitTime + " minutes.");
    }



}
