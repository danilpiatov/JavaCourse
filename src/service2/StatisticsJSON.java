package service2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service3.IntToTime;
import service3.Ship;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class StatisticsJSON {

    public void writeS3(List<Ship> unloadedShips) throws IOException {

        Locale.setDefault(Locale.ENGLISH);
        JSONArray service1JSON = new JSONArray();
        for (Ship s: unloadedShips) {
            JSONObject recordJSON = new JSONObject();
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy HH:mm");
            recordJSON.put("Name of the ship", s.getNameOfUnloadedShip());
            recordJSON.put("Time of arrival", formatter.format(s.getRealTimeOfArrival().getTime()));
            recordJSON.put("Time of waiting", IntToTime.convert(s.getTimeOfWaiting()));
            recordJSON.put("Time of the start of unloading", formatter.format(s.getStartTimeOfUnloading().getTime()));
            recordJSON.put("Time of unloading", s.getRealTimeOfUnloading());
            service1JSON.add(recordJSON);
        }
        try (FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/statistics.json")) {
            fileWriter.write(service1JSON.toJSONString());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
