package TP5.simulation;

import TP5.queue.Queue;
import TP5.queue.QueueException;
import TP5.utils.State;

import java.util.ArrayList;

public class Simulator {

    private final Queue<Patient> patients;

    private static final int MAXELEMENTS;
    private static int time;

    static{
        MAXELEMENTS = 100;
        time = -1;
    }

    public Simulator(ArrayList<Patient> patientsList, int timeSimulation){
        this.patients = new Queue<>(MAXELEMENTS);
        this.moteur(patientsList, timeSimulation);
    }

    public void moteur(ArrayList<Patient> patientsList, int timeSimulation){
        Patient currentPatient = null;

        while(time < timeSimulation){
            time++;

            for (Patient patient : patientsList)
                if ((patient.getState() == State.VOID && patient.getArrivalTime() == time)
                        || (patient.getState() == State.TEST && patient.getTimeEndTest() == time)) {
                    try {
                        this.patients.push(patient);
                    } catch (QueueException e) {
                        throw new RuntimeException(e);
                    }
                    patient.setState(State.WAITING_ROOM);
                }

            if (currentPatient == null){
                try{
                    currentPatient = patients.pop();
                    if (!currentPatient.isTestDone())
                        currentPatient.setTimeStartConsultation(time);

                    currentPatient.setState(State.CONSULTATION);
                } catch (QueueException e){
                    System.out.println(e.getMessage());
                }
            }
            else {
                currentPatient.setRemainingTime(currentPatient.getRemainingTime() - 1);
                currentPatient.setGlobalTime(currentPatient.getGlobalTime() + 1);

                if (currentPatient.getRemainingTime() == 0) {
                    currentPatient.setState(State.END);

                    try{
                        currentPatient = patients.pop();
                        if (!currentPatient.isTestDone())
                            currentPatient.setTimeStartConsultation(time);

                        currentPatient.setState(State.CONSULTATION);
                    } catch (QueueException e){
                        currentPatient = null;
                        System.out.println(e.getMessage());
                    }
                } else {
                    if (currentPatient.getTimeStartTest() != -1 && !currentPatient.isTestDone()
                            && currentPatient.getTimeStartConsultation() + currentPatient.getTimeStartTest() == time){
                        currentPatient.setState(State.TEST);
                        currentPatient.setIsTestDone(true);
                        currentPatient.setTimeEndTest(time + currentPatient.getTestDuration());

                        try{
                            currentPatient = patients.pop();
                            if (!currentPatient.isTestDone())
                                currentPatient.setTimeStartConsultation(time);
                            currentPatient.setState(State.CONSULTATION);
                        } catch (QueueException e){
                            currentPatient = null;
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            for (Patient patient : patientsList)
                if (patient.getState() == State.WAITING_ROOM){
                    patient.setGlobalTime(patient.getGlobalTime() + 1);
                    patient.setWaitingTime(patient.getWaitingTime() + 1);
                }

            if(currentPatient != null)
                System.out.println(time + " - " + currentPatient.getId());

            for (Patient patient : patientsList)
                System.out.println(patient.getId() + " : " + patient.getGlobalTime() + " ," + patient.getWaitingTime());
        }
    }
}