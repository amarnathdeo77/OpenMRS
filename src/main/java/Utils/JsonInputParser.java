package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

//Class to parse the test data and config json
public class JsonInputParser {

    private static JSONObject data;
    private static JSONObject config;
    public static String baseFilePath = "src/test/resources/";

    public JsonInputParser() {

    }

    public static JSONObject inputDataInit() {
        if (data == null) {
            JSONParser parser = new JSONParser();
            try {
                data = (JSONObject) parser.parse(
                        new FileReader(baseFilePath + "input.json"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return data;
    }

    public static JSONObject configDataInit() {
        if (config == null) {
            JSONParser parser = new JSONParser();
            try {
                config = (JSONObject) parser.parse(
                        new FileReader(baseFilePath + "config.json"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return config;
    }
}
