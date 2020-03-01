import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class phonebook {
    private HashMap<String, Set> phoneBookRecords = new HashMap<>();

    public Set get(String secondName){
        Set<String> phBookRecord = phoneBookRecords.get(secondName);
        return phBookRecord == null ? new HashSet<String>():phBookRecord;
    }

    public void add(String secondName, String phoneNumber){
        Set<String> phBookRecord = this.get(secondName);
        phBookRecord.add(phoneNumber);
        phoneBookRecords.put(secondName, phBookRecord);
    }


}
