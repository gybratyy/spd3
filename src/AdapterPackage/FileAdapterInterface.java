package AdapterPackage;

import java.util.ArrayList;

// adapter class
public class FileAdapterInterface implements FileReaderInterface {
    AdvancedFileReader readAdapter;

    public FileAdapterInterface(String format){

        if(format.equals("txt")){
            this.readAdapter = new TXTreader();
        } else if (format.equals("csv")) {
            this.readAdapter = new CSVreader();
        } else if (format.equals("json")) {
            this.readAdapter = new JSONreader();
        }

    }
    @Override
    public ArrayList<String> read(String path, String format){
        if(format.equals("txt")){
            return readAdapter.readTXT(path);
        } else if (format.equals("csv")) {
            return readAdapter.readCSV(path);
        } else if (format.equals("json")) {
            return readAdapter.readJSON(path);
        }
        else{ return null;}
    }
}
