public class hw07 {
    public static void main(String[] args) {
        Cat cat = new Cat("Pixel", 200);
        Plate plate = new Plate(1000);
        plate.info();
        cat.eat(plate);
        plate.info();
    }
}
