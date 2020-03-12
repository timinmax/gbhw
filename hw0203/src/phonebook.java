import java.util.HashMap;
import java.util.HashSet;

public class phonebook {
    private HashMap<String, HashSet> phoneBookRecords = new HashMap<>();

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
