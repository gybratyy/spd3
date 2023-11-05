package Aggregator;

import java.util.ArrayList;
import java.util.Random;

public class DataObject {

    private ArrayList<String> data;
    private boolean encrypted;
    private String encoding;
    private int key;

    public DataObject(ArrayList<String> data) {
        this.data = data;
        this.encrypted = false;
        this.encoding = "UTF-8";
    }

    public void encrypt() {
        // Generate a random key
        Random random = new Random();
        this.key = random.nextInt(10); // You can adjust the range of the key as needed

        // Implement encryption logic
        for (int i = 0; i < this.data.size(); i++) {
            String currentString = this.data.get(i);
            StringBuilder encryptedString = new StringBuilder();
            for (int j = 0; j < currentString.length(); j++) {
                encryptedString.append((char) (currentString.charAt(j) + this.key)); // Move each character by the key value
            }
            this.data.set(i, encryptedString.toString());
        }
        this.encrypted = true;
    }

    public void decrypt() {
        if (!this.encrypted) {
            System.out.println("Data is not encrypted.");
            return;
        }

        // Implement decryption logic
        for (int i = 0; i < this.data.size(); i++) {
            String currentString = this.data.get(i);
            StringBuilder decryptedString = new StringBuilder();
            for (int j = 0; j < currentString.length(); j++) {
                decryptedString.append((char) (currentString.charAt(j) - this.key)); // Move each character back by the key value
            }
            this.data.set(i, decryptedString.toString());
        }
        this.encrypted = false;
        this.key = 0; // Reset the key to 0 after decryption
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void getData() {
        System.out.println("ENCRYPTION: "+isEncrypted());
        System.out.println("ENCODING: "+this.encoding);
        System.out.println("KEY: "+this.key);
        for(String s: data){
            System.out.println(s);
        }

    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public String getEncoding() {
        return encoding;
    }

    public int getKey() {
        return key;
    }
}
