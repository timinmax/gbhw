public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int minus) {
        food -= minus;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

}
