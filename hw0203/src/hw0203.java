import java.util.HashMap;

public class hw0203 {
    public static void main(String[] args) {
        String[] demoArr = {"hello", "London", "is", "the", "capital", "of", "GB",
                            "my", "name", "is", "Max", "he", "is", "the", "capital"};

        /*HashSet<String> set = new HashSet<>();
        for (int i = 0; i < demoArr.length; i++){
            set.add(demoArr[i]);
        }
        System.out.println(set);
        */
        HashMap<String,Integer> counter = new HashMap<>();
        for (int i = 0; i < demoArr.length; i++){
            counter.compute(demoArr[i], (word,count)->(count == null)? 1: count + 1);
        }
        System.out.println(counter);

        phonebook pb = new phonebook();
        pb.add("Ivanov", "89032489416");
        pb.add("Ivanov", "84534526526");
        pb.add("Petrov", "2342352394231");
        pb.add("Petrov", "5245235235252");

        System.out.println("Ivanov's numbers:");
        System.out.println(pb.get("Ivanov"));

        System.out.println("Petrov's numbers:");
        System.out.println(pb.get("Petrov"));

        System.out.println("Kovalski's numbers:");
        System.out.println(pb.get("Kovalski"));

    }
}
