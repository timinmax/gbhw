import java.util.Random;
//12321
public class Human implements jumpRunAble{

    private static final int MAX_JUMP = 3;
    private static final int MAX_RUN = 100;

    private String name;
    private int age;
    private int this_max_run;
    private int this_max_jump;



    public Human() {
        Random rnd = new Random();
        this.name = "unknown";
        this.age = 1;
        this.this_max_jump = rnd.nextInt(MAX_JUMP);
        this.this_max_run = rnd.nextInt(MAX_RUN);
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        Random rnd = new Random();
        this.this_max_jump = rnd.nextInt(MAX_JUMP);
        this.this_max_run = rnd.nextInt(MAX_RUN);
    }

    @Override
    public boolean passObstacle(obstacle Obstacle2Pass) {
        if (Obstacle2Pass.getType() == TypeOfObstacle.RUN_TRACK){
            return run(Obstacle2Pass);
        }else if (Obstacle2Pass.getType() == TypeOfObstacle.WALL){
            return jump(Obstacle2Pass);
        }else {
            System.out.println("Неизвестное препятствие");
            return false;
        }
    }

    public boolean run(obstacle track){
        if (track.getSize() > this.this_max_run){
            System.out.println("Человек " + this.name + " не может пробежать " + track.getSize()
                                            + " (максимум = " + this.this_max_run + ")");
            return false;
        }
        System.out.println("Человек " + this.name + " пробежал " + track.getSize());
        return true;
    }

    public boolean jump(obstacle wall){
        if (wall.getSize() > this.this_max_jump){
            System.out.println("Человек " + this.name + " не может подпрыгнуть на высоту " + wall.getSize()
                    + " (максимум = " + this.this_max_jump + ")");
            return false;
        }
        System.out.println("Человек " + this.name + " подпрыгнул на " + wall.getSize());
        return true;
    }

    @Override
    public String toString() {
        return "Человек по имени " + name +
                ", возраст: " + age +
                ", может пробежать: " + this_max_run +
                ", может перепрыгнуть: " + this_max_jump;
    }
}
