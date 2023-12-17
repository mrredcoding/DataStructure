package TP5.simulation;

class Patient {
    private static int idCpt = 0;
    private final String name;
    private final int arrivalTime;
    private final int examinationDuration;

    public Patient(int arrivalTime, int examinationDuration) {
        this.name = "P" + ++idCpt;
        this.arrivalTime = arrivalTime;
        this.examinationDuration = examinationDuration;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getExaminationDuration() {
        return examinationDuration;
    }
}
