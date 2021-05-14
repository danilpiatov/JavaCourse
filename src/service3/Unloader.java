package service3;

import java.util.*;
import java.util.concurrent.*;

public class Unloader implements Callable {
    private Double avgQueueLength;
    private List<Ship> schedule;
    private Integer finalNumOfCranes;
    private List<Ship> unloadedShips = new ArrayList<Ship>();
    private Integer finalCost;
    private int shipArrival(Integer shipIndex, List<Ship> shipQueue, Calendar currentTime){
        Ship arrivedShip = new Ship();
        try {
            arrivedShip = schedule.get(shipIndex).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        if (arrivedShip.getRealTimeOfArrival().get(Calendar.DAY_OF_MONTH) == currentTime.get(Calendar.DAY_OF_MONTH) &&
                    arrivedShip.getRealTimeOfArrival().get(Calendar.HOUR_OF_DAY) == currentTime.get(Calendar.HOUR_OF_DAY) &&
                    arrivedShip.getRealTimeOfArrival().get(Calendar.MINUTE) == currentTime.get(Calendar.MINUTE) &&
                    arrivedShip.getRealTimeOfArrival().get(Calendar.MONTH) == currentTime.get(Calendar.MONTH)){
                shipQueue.add(arrivedShip);
                return 1;
            }
            else{
                return 0;
            }
    }
    public Unloader(List<Ship> schedule){
        this.schedule = schedule;
    }



    @Override
    public List<Ship> call() {
        List<Ship> shipQueue = new ArrayList<Ship>();
        List<Ship> currentUnloadedShipList = new ArrayList<Ship>();
        List<Integer> fineArray = new ArrayList<>();
        Integer currentAvgQueueLength = 0;
        Integer numOfCranes = 1;
        Integer currentFine = 0;
        Integer shipIndex = 0;
        Integer minFine = Integer.MAX_VALUE;
        List<Thread> craneList = new ArrayList<Thread>();
        Calendar currentTime = new GregorianCalendar();
        currentTime.set(2021, Calendar.APRIL, 1, 0, 0);
        while (schedule.get(0).getRealTimeOfArrival().get(Calendar.MONTH) < Calendar.APRIL) {
            schedule.remove(0);
        }

        while (schedule.get(schedule.size()-1).getRealTimeOfArrival().get(Calendar.MONTH) > Calendar.APRIL) {
            schedule.remove(schedule.size()-1);
        }
        while (numOfCranes * Port.CRANE_FINE < minFine) {
            currentAvgQueueLength = 0;
            unloadedShips.clear();
            currentFine=0;
            while (currentTime.get(Calendar.MONTH)==Calendar.APRIL || !shipQueue.isEmpty()) {
                if (shipIndex < schedule.size())
                    shipIndex += shipArrival(shipIndex, shipQueue, currentTime);
                for (int i = 0; i < numOfCranes; i++) {
                    if (i == shipQueue.size() * 2) {
                        break;
                    }
                    if (i < shipQueue.size()) {
                        Ship s = shipQueue.get(i);
                        if (s.isWaiting) {
                            s.isWaiting = false;
                            s.setTimeOfWaiting(Math.toIntExact((currentTime.getTime().getTime() - s.getRealTimeOfArrival().getTime().getTime()) / 60000));
                            s.setStartTimeOfUnloading(currentTime.getTime());
                        }
                        craneList.add(new Thread(new Crane(s)));
                    } else {
                        craneList.add(new Thread(new Crane(shipQueue.get(i - shipQueue.size()))));
                    }
                }
                for (Thread t : craneList) {
                    t.start();
                }
                craneList.clear();

                if (shipQueue.size() > numOfCranes) {
                    currentAvgQueueLength += shipQueue.size() - numOfCranes;
                }
                int index = 0;
                while (index != shipQueue.size()) {
                    Ship s = shipQueue.get(index);
                    if (s.getTimeOfUnloading() <= 0) {
                        s.setRealTimeOfUnloading(Math.toIntExact((currentTime.getTime().getTime() - s.getStartTimeOfUnloading().getTime()) / 60000));
                        int shipFine = (Math.toIntExact((currentTime.getTime().getTime() -
                                s.getRealTimeOfArrival().getTime().getTime()) / 60000)  - s.getEstimatedTimeOfUnloading()) / 60;
                        currentUnloadedShipList.add(s);
                        if (shipFine > 0) {
                            currentFine += shipFine * Port.WAIT_FINE;
                        }
                        shipQueue.remove(index);
                    } else {
                        index++;
                    }
                }
                currentTime.add(Calendar.MINUTE, 1);
            }
            fineArray.add(currentFine);
            if (currentFine + (numOfCranes-1) * Port.CRANE_FINE < minFine) {
                minFine = currentFine + (numOfCranes-1) * Port.CRANE_FINE;
                unloadedShips = currentUnloadedShipList;
                avgQueueLength = ((double) currentAvgQueueLength) / 43200;
                finalNumOfCranes = numOfCranes;
            }
            if (minFine > (numOfCranes) * Port.CRANE_FINE)
            {
                shipQueue.clear();
                currentTime.set(2021, Calendar.APRIL, 1, 0, 0);
                shipIndex = 0;
                numOfCranes++;
            }
        }

        finalCost = minFine;
        return unloadedShips;

    }

    Double getAvgQueueLength(){
        return avgQueueLength;
    }

    Integer getFinalCost(){
        return finalCost;
    }

    Integer getFinalNumOfCranes(){
        return finalNumOfCranes;
    }

}

