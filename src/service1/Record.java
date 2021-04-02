package service1;

import java.util.GregorianCalendar;

public class Record {

    public void setTimeOfArrival(GregorianCalendar timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public void setNameOfShip(String nameOfShip) {
        this.nameOfShip = nameOfShip;
    }

    public void setTypeOfCargo(TypeOfCargo typeOfCargo) {
        this.typeOfCargo = typeOfCargo;
    }

    public void setAmountOfCargo(Integer amountOfCargo) {
        this.amountOfCargo = amountOfCargo;
    }

    public void setEstimatedTimeOfStaying(Integer estimatedTimeOfStaying) {
        this.estimatedTimeOfStaying = estimatedTimeOfStaying;
    }

    public GregorianCalendar getTimeOfArrival() {
        return timeOfArrival;
    }

    public String getNameOfShip() {
        return nameOfShip;
    }

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public Integer getAmountOfCargo() {
        return amountOfCargo;
    }

    public Integer getEstimatedTimeOfStaying() {
        return estimatedTimeOfStaying;
    }


    private GregorianCalendar timeOfArrival;
    private String nameOfShip;
    private TypeOfCargo typeOfCargo;
    private Integer amountOfCargo;
    private Integer estimatedTimeOfStaying; //in minutes
}
