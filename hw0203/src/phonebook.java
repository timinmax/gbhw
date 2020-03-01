import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class phonebook {
    private HashMap<String, Set> phoneBookRecords = new HashMap<>();

    public void add(String secondName, String phoneNumber){
        Set<String> phBookRecord = get(secondName);
        phBookRecord.add(phoneNumber);
        phoneBookRecords.put(secondName, phBookRecord);
    }

    public Set get(String secondName){
        Set<String> phBookRecord = phoneBookRecords.get(secondName);
        if (phBookRecord == null){
            phBookRecord = new HashSet<>();
        }

        return phBookRecord;
    }
}
