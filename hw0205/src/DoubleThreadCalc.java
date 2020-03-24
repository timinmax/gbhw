import java.util.Arrays;

public class DoubleThreadCalc {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];
    float[] half1Arr = new float[HALF];
    float[] half2arr = new float[HALF];

    public float splitAndCalc(){
        Arrays.fill(arr, 1f);

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, half1Arr, 0, HALF);
        System.arraycopy(arr,HALF,half2arr,0,HALF);


        Thread Th1 = new Thread(() -> this.calcH1());
        Thread Th2 = new Thread(() -> this.calcH2());

        Th1.start();
        Th2.start();

        try{
            Th1.join();
            Th2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(half1Arr,0,arr,0,HALF);
        System.arraycopy(half2arr,0,arr,HALF,HALF);

        return System.currentTimeMillis() - a;
    }

    public void calcH1(){
        for (int i = 0; i < half1Arr.length; i++) {
            half1Arr[i] = calc(half1Arr[i] , i);
        }
    }
    public void calcH2(){
        for (int i = 0; i < half2arr.length; i++) {
            half2arr[i] = calc(half2arr[i] , i + HALF);
        }
    }

    public static float calc(float val, int i){
        return (float)(val * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
