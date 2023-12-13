package TP5;

import javax.swing.plaf.metal.DefaultMetalTheme;

public class Patient {

    private final String id;

    private int travelTime;
    private int consultationTime;
    private int timeStartTest;
    private int testDuration;

    private int timeStartConsultation;

    private int remainingTime;

    private int globalTime;
    private int waitingTime;

    boolean testFait;

    private int timeEndTest;

    private Etat etat;

    public Patient(){
        this.id = "TODO";
    }
}
