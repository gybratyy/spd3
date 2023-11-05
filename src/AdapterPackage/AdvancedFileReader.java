package AdapterPackage;

import Aggregator.DataAggregator;

import java.util.ArrayList;

// adaptee interface
interface AdvancedFileReader {
    ArrayList<String> readCSV(String path);
    ArrayList<String> readTXT(String path);
    ArrayList<String> readJSON(String path);
}
