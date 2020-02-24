//1232
public class Wall implements obstacle{


    private int height;

    public Wall(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public int getSize(){
        return this.getHeight();
    }
    public TypeOfObstacle getType(){
        return TypeOfObstacle.WALL;
    }

}
