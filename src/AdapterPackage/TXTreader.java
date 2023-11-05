package AdapterPackage;

import Aggregator.DataAggregator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// adaptee class
public class TXTreader implements AdvancedFileReader {

    @Override
    public ArrayList<String> readTXT(String path){
        ArrayList<String> dataList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataList.add(line);
              /*  System.out.println(line);*/
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }


    @Override public ArrayList<String> readCSV(String path){ return null;}
    @Override public ArrayList<String> readJSON(String path){ return null;}
}
