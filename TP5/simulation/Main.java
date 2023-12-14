package TP5.simulation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Patient> patientsList = new ArrayList<>();

        patientsList.add(new Patient(8, 10, 2, 1, 10));
        patientsList.add(new Patient(10, 3, 1, 2, 3));
        patientsList.add(new Patient( 1, 4, 3, 2, 4));
        patientsList.add(new Patient( 3, 4, -1, 2, 4));
        patientsList.add(new Patient( 6, 7, 3, 2, 7));

        new Simulator(patientsList, 40);
    }
}
