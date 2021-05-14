package service2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service1.Generator;
import service1.Record;

import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class JsonWriter {

    public void writeS1() throws IOException {

        Locale.setDefault(Locale.ENGLISH);
        JSONArray service1JSON = new JSONArray();
        for (int i = 0; i < 150; i++) {
            Record record = Generator.generateRecord();
            JSONObject recordJSON = new JSONObject();
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy HH:mm");
            recordJSON.put("Time of arrival", formatter.format(record.getTimeOfArrival().getTime()));
            recordJSON.put("Name of the ship", record.getNameOfShip());
            recordJSON.put("Type of cargo", record.getTypeOfCargo().toString());
            recordJSON.put("Amount of cargo", record.getAmountOfCargo());
            recordJSON.put("Estimated time of staying", record.getEstimatedTimeOfStaying());
            service1JSON.add(recordJSON);
        }
        try (FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/arrivalList.json")) {
            fileWriter.write(service1JSON.toJSONString());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
