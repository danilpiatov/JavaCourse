package service3;

import service1.TypeOfCargo;

import java.util.GregorianCalendar;

public class Ship {

    public void setTimeOfWaiting(Integer timeOfWaiting) {
        this.timeOfWaiting = timeOfWaiting;
    }

    public void setTimeOfUnloading(Integer timeOfUnloading) {
        this.timeOfUnloading = timeOfUnloading;
    }

    public void setStartTimeOfUnloading(GregorianCalendar startTimeOfUnloading) {
        this.startTimeOfUnloading = startTimeOfUnloading;
    }

    public void setRealTimeOfArrival(GregorianCalendar realTimeOfArrival) {
        this.realTimeOfArrival = realTimeOfArrival;
    }

    public GregorianCalendar getRealTimeOfArrival() {
        return realTimeOfArrival;
    }

    public void setTypeOfCargo(TypeOfCargo typeOfCargo) {
        this.typeOfCargo = typeOfCargo;
    }
    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public void setEstimatedTimeOfUnloading(Long estimatedTimeOfUnloading) {
        this.estimatedTimeOfUnloading = estimatedTimeOfUnloading;
    }
    public Long getEstimatedTimeOfUnloading() {
        return estimatedTimeOfUnloading;
    }

    public void setNameOfUnloadedShip(String nameOfUnloadedShip) {
        this.nameOfUnloadedShip = nameOfUnloadedShip;
    }
    public String getNameOfUnloadedShip(){
        return nameOfUnloadedShip;
    }

    private String nameOfUnloadedShip;
    private TypeOfCargo typeOfCargo;
    private GregorianCalendar realTimeOfArrival;
    private Integer timeOfWaiting; //in minutes
    private GregorianCalendar startTimeOfUnloading;
    private Integer timeOfUnloading;// in minutes;
    private Long estimatedTimeOfUnloading;
}


