package Aggregator;

public class OutputWriter {
    static DataAggregator aggregator;

    public OutputWriter(DataAggregator aggregator) {
        this.aggregator=aggregator;
    }

    public static void writeData() {

        for(DataObject dataObject : aggregator.getAggregatedData()){
            dataObject.getData();
        }

    }
}

