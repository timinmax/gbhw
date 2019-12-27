import java.util.Date;
import java.util.Random;

public class Cat {

    private String name;
    private int caloriesBalance;//остаток калорий (остаток топлива)
    private int caloriesPerMinute;//расход калорий в минуту
    private int maxCaloriesVolume;//количество калорий в сытом коте (по типу "объем бензобака")

    private Date lastFeedTime;//время последней кормежки (заправки)

    private static final int MINUTES = 60 * 60 * 1000;

    public Cat(String name) {
        this.name = name;


        Random rnd = new Random();
        this.caloriesPerMinute = rnd.nextInt(100);//кот рождается с рандомным аппетитом
        this.maxCaloriesVolume = rnd.nextInt(5000);//объем "желудка" индивидуальный
        this.caloriesBalance = rnd.nextInt(this.maxCaloriesVolume);//рождается кот с некоторой сытостью, иначе он мертв
        this.lastFeedTime = new Date(); //Фиксируем время последнего кормления
    }

    public int getCaloriesBalance() {
        //сколько времени прошло после последней кормежки в минутах
        Date currentDate = new Date();
        int minutesPastFeed = (int)((currentDate.getTime() - this.lastFeedTime.getTime())/Cat.MINUTES);
        //прошедшее время умножаем на расход и отнимаем от остатка, который был на момент после кормежки
        //если остаток = 0, тогда кот голоден
        return Math.max(this.caloriesBalance - this.caloriesPerMinute * minutesPastFeed,0);
    }

    public void eat(Plate plate) {
        int appetite = this.maxCaloriesVolume - getCaloriesBalance(); //сколько кот готов съесть
        int eaten = plate.decreaseFood(appetite);//Сколько удалось съесть в зависимости от остатка в тарелке
        this.caloriesBalance = getCaloriesBalance() + eaten;
        this.lastFeedTime = new Date();
    }
    @Override
    public String toString(){
        return "Cat " + this.name
                + ";\n\t cal.bal.:" + getCaloriesBalance()
                + ";\n\t last feed time: " + this.lastFeedTime.toString()
                + ";\n\t calories per minute: " + this.caloriesPerMinute
                + ";\n\t max calories volume:" + this.maxCaloriesVolume ;
    }
}





