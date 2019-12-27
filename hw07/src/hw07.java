public class hw07 {
    public static void main(String[] args) {
        Cat[] Cats = new Cat[2];
        Cats[0] = new Cat("Tom");
        Cats[1] = new Cat("Leo");

        Plate plate = new Plate(10000);
        System.out.println("Инфо перед едой:");
        plate.info();
        for (int i = 0; i<Cats.length; i++){
            System.out.println(Cats[i].toString());
        }

        for (int i = 0; i<Cats.length; i++){
            Cats[i].eat(plate);
        }

        System.out.println("После еды");
        plate.info();
        for (int i = 0; i<Cats.length; i++){
            System.out.println(Cats[i].toString());
        }
    }
}
