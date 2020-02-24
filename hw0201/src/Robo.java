import java.util.Random;

public class Robo implements jumpRunAble{
    private static final int MAX_JUMP = 5;
    private static final int MAX_RUN = 10000;

    private String name;
    private String model;
    private int this_max_run;
    private int this_max_jump;

    public Robo() {
        Random rnd = new Random();
        this.name = "Terminator";
        this.model = "T1000";
        this.this_max_jump = rnd.nextInt(MAX_JUMP);
        this.this_max_run = rnd.nextInt(MAX_RUN);
    }

    public Robo(String name, String model) {
        this.name = name;
        this.model = model;
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
            System.out.println("Робот " + this.name + " (" + this.model + ") не может пробежать " + track.getSize()
                    + " (максимум = " + this.this_max_run + ")");
            return false;
        }
        System.out.println("Робот " + this.name + " (" + this.model + ") пробежал " + track.getSize());
        return true;
    }


    public boolean jump(obstacle wall){
        if (wall.getSize()>this.this_max_jump){
            System.out.println("Робот " + this.name + " (" + this.model + ") не может подпрыгнуть на высоту " + wall.getSize()
                    + " (максимум = " + this.this_max_jump + ")");
            return false;
        }
        System.out.println("Робот " + this.name + " (" + this.model + ") подпрыгнул на " + wall.getSize());
        return true;
    }

    @Override
    public String toString() {
        return "Робот по имени " + name +
                ", модель: " + model +
                ", может пробежать: " + this_max_run +
                ", может перепрыгнуть: " + this_max_jump;
    }
}
