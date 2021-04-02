package service3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service1.TypeOfCargo;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Port {
    public static Integer speedOfLiquidCrane = 20; //Tons per minute
    public static Integer speedOfLooseCrane = 15; //Tons per minute
    public static Integer speedOfContainerCrane = 10; //containers per minute

    private final List<Ship> liquidShipList = new ArrayList<>();
    private final List<Ship> looseShipList = new ArrayList<>();
    private final List<Ship> containerShipList = new ArrayList<>();

    private void readFromJSON() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray schedule = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir") + "/arrivalList.json"));

            for (Object o : schedule)
            {
                JSONObject record = (JSONObject) o;
                Ship ship = new Ship();
                ship.setNameOfUnloadedShip((String) record.get("Name of the ship"));
                String type = record.get("Type of cargo").toString();
                switch (type) {
                    case "LIQUID" -> ship.setTypeOfCargo(TypeOfCargo.LIQUID);
                    case "LOOSE" -> ship.setTypeOfCargo(TypeOfCargo.LOOSE);
                    case "CONTAINER" -> ship.setTypeOfCargo(TypeOfCargo.CONTAINER);
                }
                GregorianCalendar timeOfArrival =  StringToCalendar.convert(record.get("Time of arrival").toString());
                timeOfArrival.add(Calendar.MINUTE, -10080 + (int) (Math.random() * 20160));
                ship.setRealTimeOfArrival(timeOfArrival);
                ship.setEstimatedTimeOfUnloading((Long) record.get("Estimated time of staying"));
                switch (ship.getTypeOfCargo()) {
                    case LIQUID -> liquidShipList.add(ship);
                    case LOOSE -> looseShipList.add(ship);
                    case CONTAINER -> containerShipList.add(ship);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void sortShips() {
        readFromJSON();
        liquidShipList.sort(Comparator.comparing(Ship::getRealTimeOfArrival));
        looseShipList.sort(Comparator.comparing(Ship::getRealTimeOfArrival));
        containerShipList.sort(Comparator.comparing(Ship::getRealTimeOfArrival));
    }
    
}
