import java.util.Arrays;

public class hw0205 {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        System.out.println("1 thread calc: " + oneThreadCalc() + " ms.");

        DoubleThreadCalc DCC = new DoubleThreadCalc();
        System.out.println("2 thread calc: " + DCC.splitAndCalc());
    }

    public static long oneThreadCalc(){

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return System.currentTimeMillis() - a;
    }
}
