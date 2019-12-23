public class hw06 {
    public static void main(String[] args) {
        Cat catMartin = new Cat("brown", "Martin");
        catMartin.sayHello();
        catMartin.run(300);
        catMartin.run(140);
        catMartin.jump(1);
        catMartin.swim(10);

        Dog dogLucky = new Dog("white", "Lucky");
        dogLucky.sayHello();
        dogLucky.run(1000);
        dogLucky.run(400);
        dogLucky.swim(4);
    }
}
