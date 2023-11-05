import AdapterPackage.FileAdapterInterface;
import AdapterPackage.FileReaderInterface;
import Aggregator.DataAggregator;
import Aggregator.DataAggregatorInterface;
import Aggregator.DataObject;
import Aggregator.OutputWriter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        DataAggregator aggregator = new DataAggregator();



        FileReaderInterface reader = new FileAdapterInterface("txt");
        DataObject txtobject = new DataObject(reader.read("src/Data/test.txt", "txt"));
        txtobject.encrypt();
        aggregator.aggregateData(txtobject);


        reader = new FileAdapterInterface("json");
        DataObject jsonobject = new DataObject(reader.read("src/Data/phones.json", "json"));

        aggregator.aggregateData(jsonobject);

        reader = new FileAdapterInterface("csv");
        DataObject csvobject = new DataObject(reader.read("src/Data/table.csv", "csv"));
        aggregator.aggregateData(csvobject);

        OutputWriter writer = new OutputWriter(aggregator);
        writer.writeData();






    }
}