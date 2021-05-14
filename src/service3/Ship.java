package service3;

import service1.TypeOfCargo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ship implements Cloneable {
    private String nameOfUnloadedShip;
    private TypeOfCargo typeOfCargo;
    private GregorianCalendar realTimeOfArrival;
    private Integer timeOfWaiting; //in minutes
    private Date startTimeOfUnloading;
    private Integer realTimeOfUnloading;
    private Integer timeOfUnloading;// in minutes;
    private Integer estimatedTimeOfUnloading;
    public volatile Integer amountOfCargo;
    public boolean isWaiting = true;

    public Ship clone() throws CloneNotSupportedException {
        return (Ship) super.clone();
    }

    public void setTimeOfWaiting(Integer timeOfWaiting) {
        this.timeOfWaiting = timeOfWaiting;
    }

    public Integer getTimeOfWaiting(){
        return timeOfWaiting;
    }


    public void setTimeOfUnloading(Integer estimatedTimeOfUnloading) {
        this.timeOfUnloading = estimatedTimeOfUnloading + (int) (Math.random() * 1440);
    }

    public Integer getTimeOfUnloading(){
        return timeOfUnloading;
    }
    public void decTOU(){
        timeOfUnloading--;
    }

    public void setStartTimeOfUnloading(Date startTimeOfUnloading) {
        this.startTimeOfUnloading = startTimeOfUnloading;
    }

    public Date getStartTimeOfUnloading(){
        return startTimeOfUnloading;
    }

    public void setRealTimeOfUnloading(Integer realTimeOfUnloading) {
        this.realTimeOfUnloading = realTimeOfUnloading;
    }

    public Integer getRealTimeOfUnloading(){
        return realTimeOfUnloading;
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

    public void setEstimatedTimeOfUnloading(Integer estimatedTimeOfUnloading) {
        this.estimatedTimeOfUnloading = estimatedTimeOfUnloading;
    }
    public Integer getEstimatedTimeOfUnloading() {
        return estimatedTimeOfUnloading;
    }

    public void setNameOfUnloadedShip(String nameOfUnloadedShip) {
        this.nameOfUnloadedShip = nameOfUnloadedShip;
    }
    public String getNameOfUnloadedShip(){
        return nameOfUnloadedShip;
    }

}


