public class hw01 {
    public static void main(String[] args) {
        byte byteVar = 0;
        short shortVar = 0;
        int intVar = 0;
        long longVar = 0L;
        float floatVar = 0f;
        double doubleVar = 0;
        char charVar = 'a';
        boolean boolVar = true;

        float a,b,c,d;
        a = b = c = d = 10f;

        floatVar = calcFormula(a, b, c, d);
        System.out.println("" + a + " * (" + b + " + (" + c + " / " + d + ")) = " + floatVar);

        int firstNum, secondNum;
        firstNum = secondNum = 17;
        System.out.println("Test result is " + testNumbers(firstNum, secondNum));
    }

    public static float calcFormula(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    public static boolean testNumbers(int firstNumber, int secondNumber){
        int sumOfNum = firstNumber + secondNumber;
        return sumOfNum>=10 && sumOfNum<=20;
    }
}
