package AdapterPackage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// adaptee class
public class JSONreader implements AdvancedFileReader {

    @Override public ArrayList<String> readJSON(String path){

        ArrayList<String> dataList = new ArrayList<>();

        try {
            // Parse the JSON file into a JSONArray object
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));

            // Iterate through the JSONArray object
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;

                // Iterate through the keys of the JSONObject object
                Iterator<String> keys = jsonObject.keySet().iterator();
                StringBuilder stringBuilder = new StringBuilder();
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object value = jsonObject.get(key);
                    stringBuilder.append(key).append(" ").append(value).append("\n");
                }
                dataList.add(stringBuilder.toString());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return dataList;

    }


    @Override public ArrayList<String> readTXT(String path){ return null;}

    @Override public ArrayList<String> readCSV(String path){ return null;}


}
