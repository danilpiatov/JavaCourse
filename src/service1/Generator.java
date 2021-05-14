package service1;

import service3.Port;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.io.FileReader;

public class Generator {

    public static Record generateRecord() {
        Record record = new Record();
        record.setTimeOfArrival(generateTimeOfArrival());
        record.setNameOfShip(generateNameOfShip());
        record.setTypeOfCargo(generateType());
        record.setAmountOfCargo(generateAmount());
        switch (record.getTypeOfCargo()) {
            case LOOSE -> record.setEstimatedTimeOfStaying(record.getAmountOfCargo() / Port.speedOfLooseCrane);
            case LIQUID -> record.setEstimatedTimeOfStaying(record.getAmountOfCargo() / Port.speedOfLiquidCrane);
            case CONTAINER -> record.setEstimatedTimeOfStaying(record.getAmountOfCargo() / Port.speedOfContainerCrane);
        }
        return record;
    }

    public static GregorianCalendar generateTimeOfArrival() {
        GregorianCalendar time = new GregorianCalendar();
        time.set(GregorianCalendar.YEAR, 2021);
        time.set(GregorianCalendar.MONTH, GregorianCalendar.APRIL);
        time.set(GregorianCalendar.DAY_OF_MONTH, 1 + (int) (Math.random() * 29));
        time.set(GregorianCalendar.HOUR_OF_DAY, (int) (Math.random() * 24));
        time.set(GregorianCalendar.MINUTE, (int) (Math.random() * 60));
        return time;
    }

    public static String generateNameOfShip() {
        String name = "";
        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/Names")) {
            int stringNumber = 1 + (int) (Math.random() * 2699);
            BufferedReader bufferedReader = new BufferedReader(reader);
            for (int i = 0; i < stringNumber - 1; i++) {
                bufferedReader.readLine();
            }
            name = bufferedReader.readLine();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return name;
    }

    public static TypeOfCargo generateType() {
        return TypeOfCargo.values()[(int) (Math.random() * 3)];
    }

    public static Integer generateAmount() {
        return 10000 + (int) (Math.random() * 4901);
    }

}
