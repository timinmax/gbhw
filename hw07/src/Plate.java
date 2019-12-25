public class Plate {

    private int calories;

    public Plate(int calories) {

        this.calories = calories;
    }

    public int decreaseFood(int minus) {
        int accessibleCalories = Math.min(minus, this.getCalories());
        this.calories -= accessibleCalories;
        return accessibleCalories;
    }
    public int getCalories(){
        return this.calories;
    }

    public void addCalories(int caloriesCount){
        this.calories += caloriesCount;
    }

    public void info() {
        System.out.println("Plate: " + calories);
    }

}
