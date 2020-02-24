public class hw0201 {
    public static void main(String[] args) {
        jumpRunAble[] participantsArray = new jumpRunAble[3];
        obstacle[] obstaclesArray = new obstacle[5];

        participantsArray[0] = new Human("Max",20);
        participantsArray[1] = new Robo("Bender","SM22");
        participantsArray[2] = new Cat("Barsik",2);

        obstaclesArray[0] = new Wall(1);
        obstaclesArray[1] = new Wall(2);
        obstaclesArray[2] = new RunTrack(10);
        obstaclesArray[3] = new RunTrack(100);
        obstaclesArray[4] = new Wall(4);

        for (jumpRunAble participant:participantsArray){
            System.out.println(participant);

            for (obstacle obst:obstaclesArray){
                if (!participant.passObstacle(obst)){
                    break;
                }
            }
        }

    }
}
