public class hw02 {
    public static void main(String[] args) {
        //Домашнее задание 02 задача 01
        int[] testArr = {0,1,0,1,1,1,1,0,1,1};
        print_r(testArr);
        int[] invertedArr = inverter(testArr);
        print_r(invertedArr);

        //Домашнее задание 02 задача 01
        int[] arrayStep3 = getArrayIncrStep(3, 8);
        print_r(arrayStep3);
    }


    private static int[] inverter(int[] arrayToInvert){
        for (int i = 0; i<arrayToInvert.length; i++){
            arrayToInvert[i] = arrayToInvert[i]==0?1:0;
        }
        return arrayToInvert;
    }

    private static int[] getArrayIncrStep(int step, int arrLength){
        int[] returnArr = new int[arrLength];
        returnArr[0] = 0;
        for (int i = 1; i<arrLength; i++){
            returnArr[i] = returnArr[i-1] + step;
        }
        return returnArr;
    }

    private static void print_r(int[] arrayToPrint){
        System.out.print("\n");
        for (int i = 0; i<arrayToPrint.length;i++){
            System.out.print("\t" + arrayToPrint[i]);
        }
    }
}
