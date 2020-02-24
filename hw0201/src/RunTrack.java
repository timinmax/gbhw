public class RunTrack implements obstacle{


    private int length;

    public RunTrack(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public int getSize(){
        return this.getLength();
    }
    public TypeOfObstacle getType(){
        return TypeOfObstacle.RUN_TRACK;
    }

}
