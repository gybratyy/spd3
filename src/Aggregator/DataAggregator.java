package Aggregator;

import java.util.ArrayList;

public class DataAggregator implements DataAggregatorInterface {

    private ArrayList<DataObject> aggregatedData = new ArrayList<>();

    public DataAggregator() {
        this.aggregatedData=getAggregatedData();
    }

    @Override
    public void aggregateData(DataObject dataObject) {
        aggregatedData.add(dataObject);
    }

    public ArrayList<DataObject> getAggregatedData() {
        return aggregatedData;
    }
}