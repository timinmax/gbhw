public class hw02 {
    public static void main(String[] args) {
        System.out.println("Домашнее задание 02 задача 01");
        int[] testArr = {0,1,0,1,1,1,1,0,1,1};
        print_r(testArr);
        int[] invertedArr = inverter(testArr);
        print_r(invertedArr);

        System.out.println("\nДомашнее задание 02 задача 02");
        int[] arrayStep3 = getArrayIncrStep(3, 8);
        print_r(arrayStep3);

        System.out.println("\nДомашнее задание 02 задача 03");
        int[] anotherTestArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        print_r(anotherTestArr);
        processArray(anotherTestArr);
        print_r(anotherTestArr);

        System.out.println("\nДомашнее задание 02 задача 04");
        int[][] table = getQuadTable(8);
        for (int i = 0; i<table.length; i++){
            print_r(table[i]);
        }

        System.out.println("\nДомашнее задание 02 задача 05");
        print_r(anotherTestArr);
        System.out.println("\nMax = " + getMax(anotherTestArr) + "; Min = " + getMin(anotherTestArr));
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

    private static void processArray(int[] array2Process){
        for (int i = 0; i<array2Process.length; i++){
            array2Process[i] = array2Process[i] * ((array2Process[i]<6)?2:1);
        }
    }

    private static int[][] getQuadTable(int size){
        int[][] returnTable = new int[size][size];
        for (int i = 0; i<size; i++){
            returnTable[i][i] = 1;
        }
        return returnTable;
    }
    private static int getMax(int[] numbersArray){
        //если передали пустой массив
        if (numbersArray.length == 0) return 0;
        //если в массиве всего 1 элемент, то просто возвращаем его
        if (numbersArray.length == 1) return numbersArray[0];
        //в остальных случаях надо перебрать массив
        int number2return = numbersArray[0];

        for (int i = 1; i<numbersArray.length; i++){
            number2return = (numbersArray[i]>number2return)?numbersArray[i]:number2return;
        }
        return number2return;
    }

    private static int getMin(int[] numbersArray){
        //если передали пустой массив
        if (numbersArray.length == 0) return 0;
        //если в массиве всего 1 элемент, то просто возвращаем его
        if (numbersArray.length == 1) return numbersArray[0];
        //в остальных случаях надо перебрать массив
        int number2return = numbersArray[0];

        for (int i = 1; i<numbersArray.length; i++){
            number2return = (numbersArray[i]<number2return)?numbersArray[i]:number2return;
        }
        return number2return;
    }

    private static void print_r(int[] arrayToPrint){
        System.out.print("\n");
        for (int i = 0; i<arrayToPrint.length;i++){
            System.out.print("\t" + arrayToPrint[i]);
        }
    }
}
