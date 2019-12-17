public class employee {
    private String fio;
    private String function;
    private String phone;
    private float salary;
    private int age;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getFio() {
        return fio;
    }

    public String getFunction() {
        return function;
    }

    public String getPhone() {
        return phone;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public employee(String fio, String function, String phone, float salary, int age) {
        this.fio = fio;
        this.function = function;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printMe(){
        System.out.println("Карточка сотрудника:");
        System.out.println("ФИО:\t" + getFio());
        System.out.println("Должность:\t" + getFunction());
        System.out.println("Номер тел.:\t" + getPhone());
        System.out.println("Зарплата:\t" + getSalary());
        System.out.println("Возраст:\t" + getAge());
    }
}
