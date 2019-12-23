public abstract class animal
{
    private String color;
    private String name;

    //ограничения для вида животных в целом.
    protected static int globalRunLimit;
    protected static int globalJumpLimit;
    protected static int globalSwimLimit;



    private static String SPECIES_NAME;


    //Ограничения конкретного животного
    protected int runLimit;
    protected int jumpLimit;
    protected int swimLimit;



    public animal(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getRunLimit() {
        return runLimit;
    }



    public int getJumpLimit() {
        return jumpLimit;
    }



    public int getSwimLimit() {
        return swimLimit;
    }


    public abstract String getSpeciesName();
    public abstract void sayHello();
    public abstract void run(int distance);
    public abstract void swim(int distance);
    public abstract void jump(int height);
    protected abstract void setRunLimit();
    protected abstract void setJumpLimit();
    protected abstract void setSwimLimit();
    protected static String action(int distance, int actionLimit, animal Animal, String actionName){
        String response = Animal.getColor() + " " + Animal.getSpeciesName() + " " + Animal.getName();
        if (actionLimit == 0){
            response = " can't " + actionName;
        }else if (distance>actionLimit){
            response = response + " can't " + actionName + " the distance of " + distance + "."
                                + " It can " + actionName + " only " + actionLimit;
        }else {
            response = response + " " + actionName + "s " + distance;
        }
        return response;
    };

    protected static String getHello(animal beast){
        return  "Hello. I'm a "
                + beast.getColor() + " "
                + beast.getSpeciesName() + " "
                + beast.getName()
                + "\nI can:"
                + "\nRun: " + beast.getRunLimit()
                + "\nSwim: " + beast.getSwimLimit()
                + "\nJump: " + beast.getJumpLimit();

    }
}
