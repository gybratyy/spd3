package AdapterPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// adaptee class
public class CSVreader implements AdvancedFileReader {

    @Override
    public ArrayList<String> readCSV(String path){

        ArrayList<String> dataArray = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(",");
                dataArray.add(String.format("%-15s%-5s%-15s%-25s", data[0], data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }





    @Override public ArrayList<String> readJSON(String path){return null;}
    @Override public ArrayList<String> readTXT(String path){ return null;}
}
