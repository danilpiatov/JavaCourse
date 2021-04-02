package service1;

import service2.JsonWriter;
import service3.Port;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Record record = Generator.generateRecord();
        System.out.println(record.getTimeOfArrival().getTime() + "\n" + record.getNameOfShip()
        + "\n" + record.getTypeOfCargo().toString() + "\n" + record.getAmountOfCargo() + "\n" +
                record.getEstimatedTimeOfStaying());
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.writeS1();
        Port port = new Port();
        port.sortShips();
    }
}
