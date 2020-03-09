package JavaFXWay;

import java.util.HashMap;
import java.util.HashSet;

public class contactList {


    private HashMap<String, HashSet> phoneBookRecords = new HashMap<>();

    public HashMap<String, HashSet> getPhoneBookRecords() {
        return phoneBookRecords;
    }

    public void fillDemo(){
        this.add("Ivanov", "89032489416");
        this.add("Ivanov", "84534526526");
        this.add("Petrov", "2342352394231");
        this.add("Petrov", "5245235235252");
    }

    public HashSet get(String secondName){
        HashSet<String> phBookRecord = phoneBookRecords.get(secondName);
        return phBookRecord == null ? new HashSet<String>():phBookRecord;
    }

    public void add(String secondName, String phoneNumber){
        HashSet<String> phBookRecord = this.get(secondName);
        phBookRecord.add(phoneNumber);
        phoneBookRecords.put(secondName, phBookRecord);
    }



}
