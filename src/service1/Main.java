package service1;

import service2.JsonWriter;
import service3.Port;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Record record = Generator.generateRecord();
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.writeS1();
        Port port = new Port();
        port.sortShips();
        port.simulate();

    }
}
