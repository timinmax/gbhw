import java.util.Random;

public class hw05 {

    public static String[] names = {"Иван", "Сергей", "Алексей", "Михаил", "Максим"
                                    , "Федор", "Василий", "Кирилл", "Александр", "Виктор"};
    public static String[] patronymics = {"Иванович", "Алексеевич", "Михайлович", "Максимович",
                                        "Федорович", "Викторович", "Сергеевич"};
    public static String[] surnames = {"Иванов", "Петров", "Сидоров", "Ковальский", "Пушкин", "Толстой", "Киркоров"};
    public static String[] functions = {"Доктор", "Водитель", "Кладовщик", "Бухгалтер", "Директор", "Инженер", "Юрист"};

    private static employee[] employees;

    public static void main(String[] args) {

        populateArray(5);
        printElderThan(40);


    }

    private static void printElderThan(int age){
        for (int i = 0; i<employees.length; i++)
            if (employees[i].getAge() > age) employees[i].printMe();
    }

    private static void populateArray(int emplCount){
        Random rnd = new Random();
        employees = new employee[emplCount];
        for (int i = 0; i<emplCount; i++){
            String phone = "+7";
            for (int j = 0; j<=9; j++){
                phone = phone + rnd.nextInt(9);
            }

            employees[i] = new employee(
                    surnames[rnd.nextInt(surnames.length-1)] + " "
                            +names[rnd.nextInt(names.length-1)]+ " "
                            + patronymics[rnd.nextInt(patronymics.length-1)],
                    functions[rnd.nextInt(functions.length-1)],
                    phone,
                    rnd.nextFloat()*100000,
                    rnd.nextInt(50) + 18);
        }
    }
}
