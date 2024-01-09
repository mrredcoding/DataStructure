package TP5.simulation;

import TP5.queue.QueueException;

public class Main {

    public static void main(String[] args) throws QueueException {
        WaitingRoom waitingRoom = new WaitingRoom();

        waitingRoom.addPatient(new Patient(3, 10));
        waitingRoom.addPatient(new Patient(0, 6));
        waitingRoom.addPatient(new Patient(2, 8));
        waitingRoom.addPatient(new Patient(4, 9));
        waitingRoom.addPatient(new Patient(6, 4));

        waitingRoom.simulate();
    }
}
