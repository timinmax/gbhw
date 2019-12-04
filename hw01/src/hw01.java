public class hw01 {
    public static void main(String[] args) {
        //task 2
        byte byteVar = 0;
        short shortVar = 0;
        int intVar = 0;
        long longVar = 0L;
        float floatVar = 0f;
        double doubleVar = 0;
        char charVar = 'a';
        boolean boolVar = true;

        //task 3
        float a,b,c,d;
        a = b = c = d = 10f;

        floatVar = calcFormula(a, b, c, d);
        System.out.println("" + a + " * (" + b + " + (" + c + " / " + d + ")) = " + floatVar);

        //task 4
        int firstNum, secondNum;
        firstNum = secondNum = 17;
        System.out.println("Test result is " + testNumbers(firstNum, secondNum));

        //task 5
        checkSign(9);
        checkSign(0);
        checkSign(-8);

        //task 6
        System.out.println("isNegative(6) = " + isNegative(6));
        System.out.println("isNegative(-6) = " + isNegative(-6));

        //Task 7
        sayHello("Max");

        //task 8
        for (int i = 0; i<=2300; i++){
            if (isLeapYear(i))
                System.out.println("The " + i + " year is leap");
        }
    }

    public static float calcFormula(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    public static boolean testNumbers(int firstNumber, int secondNumber){
        int sumOfNum = firstNumber + secondNumber;
        return sumOfNum>=10 && sumOfNum<=20;
    }

    public static void checkSign(int number2Check){
        System.out.println("The number " + number2Check + " is " + ((number2Check>=0)?"positive.":"negative"));
    }

    public static boolean isNegative(int number2Check){
        return number2Check<0;
    }

    public static void sayHello(String name){
        System.out.println("Hello, " + name);
    }

    public static boolean isLeapYear(int year){
        boolean is4 = year%4 == 0;
        boolean is100 = year%100 == 0;
        boolean is400 = year%400 == 0;

        return (is4&&!is100)||is400;

    }
}
