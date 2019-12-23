import java.util.Random;

public class Dog extends animal {
    private static final int globalRunLimit = 500;
    private static final int globalJumpLimit = 1;
    private static final int globalSwimLimit = 10;



    private static final String SPECIES_NAME = "dog";

    public Dog(String color, String name) {
        super(color, name);

        setRunLimit();
        setJumpLimit();
        setSwimLimit();

    }
    @Override
    protected void setRunLimit(){
        if (globalRunLimit == 0){
            this.runLimit = 0;
        }else {
            Random rnd = new Random();
            this.runLimit = globalRunLimit - rnd.nextInt((int) Math.round(0.1 * globalRunLimit));
        }
    }
    @Override
    protected void setJumpLimit() {
        if (globalJumpLimit == 0) {
            this.jumpLimit = 0;
        } else{
            Random rnd = new Random();
            this.jumpLimit = rnd.nextInt(globalJumpLimit);
            this.jumpLimit = Math.max(this.jumpLimit,1);
        }
    }
    @Override
    protected void setSwimLimit(){
        if(globalSwimLimit == 0){
            this.swimLimit = 0;
        }else {
            Random rnd = new Random();
            this.swimLimit = rnd.nextInt(globalSwimLimit);
        }
    }
    @Override
    public String getSpeciesName() {
        return SPECIES_NAME;
    }
    @Override
    public void run(int distance){
        System.out.println(super.action(distance, getRunLimit(),this, "run"));
    };
    @Override
    public void swim(int distance){
        System.out.println(super.action(distance, getSwimLimit(),this, "swim"));
    };
    @Override
    public void jump(int height){
        System.out.println(super.action(height, getJumpLimit(),this, "jump"));
    };
    @Override
    public void sayHello(){
        System.out.println(super.getHello(this));

    }

}
