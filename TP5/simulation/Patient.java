package TP5.simulation;

import TP5.utils.State;

public class Patient {

    private static int cpt = 1;
    private final String id;

    private final int arrivalTime;
    private final int timeStartTest;
    private final int testDuration;

    private final int consultationTime;

    private int timeStartConsultation;

    private int remainingTime;

    private int globalTime;
    private int waitingTime;

    private boolean testDone;

    private int timeEndTest;

    private State state;

    public Patient(int arrivalTime, int consultationTime, int timeStartTest, int testDuration, int remainingTime){
        this.id = "P" + cpt;
        this.arrivalTime = arrivalTime;
        this.consultationTime = consultationTime;
        this.timeStartTest = timeStartTest;
        this.testDuration = testDuration;
        this.timeStartConsultation = 0;
        this.remainingTime = remainingTime;
        this.globalTime = 0;
        this.waitingTime = 0;
        this.state = State.VOID;
        this.testDone = false;
        this.timeEndTest = 0;

        cpt++;
    }


    
    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTimeStartTest() {
        return timeStartTest;
    }

    public int getTestDuration() {
        return testDuration;
    }

    public int getTimeStartConsultation() {
        return timeStartConsultation;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getGlobalTime() {
        return globalTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public boolean isTestDone() {
        return testDone;
    }

    public int getTimeEndTest() {
        return timeEndTest;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setTimeStartConsultation(int time) {
        this.timeStartConsultation = time;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setWaitingTime(int waitingTime){
        this.waitingTime = waitingTime;
    }

    public void setGlobalTime(int globalTime){
        this.globalTime = globalTime;
    }

    public void setIsTestDone(boolean testDone) {
        this.testDone = testDone;
    }

    public void setTimeEndTest(int timeEndTest) {
        this.timeEndTest = timeEndTest;
    }

    public final String getId() {
        return this.id;
    }
}
