import java.util.HashSet;
import java.util.Set;

public class hw0203 {
    public static void main(String[] args) {
        String[] demoArr = {"hello", "London", "is", "the", "capital", "of", "GB",
                            "my", "name", "is", "Max", "he", "is", "the", "capital"};
        Set<String> set = new HashSet<>();

        for (int i = 0; i < demoArr.length; i++){
            set.add(demoArr[i]);
        }

        System.out.println(set);

    }
}
