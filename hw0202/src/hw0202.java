public class hw0202 {
    public static void main(String[] args) {
        String[][] array2Sum = {
                {"2","1","2","3"},
                {"1","3","1","4"},
                {"2","3","1","3"},
                {"2","3","1","1"}
        };

        try {
            int sum = calcArraySum(array2Sum);
            System.out.println(sum);
        }catch (MyArrayDataException e){
            System.out.println(e.getMessage());
            System.out.println("Расчет не произведен из-за некорректных данных массива.");
        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());
            System.out.println("Расчет не произведен из-за некорректного размера массива.");
        }

    }

    public static int calcArraySum(String[][] array2Sum) throws MyArrayDataException, MyArraySizeException{
        int sum = 0;
        if (array2Sum.length != 4){
            throw new MyArraySizeException();
        }

        for (int i = 0; i<array2Sum.length; i++){
            if (array2Sum[i].length != 4){
                throw new MyArraySizeException();
            }
            for (int j = 0; j<array2Sum[i].length; j++){
                int arrDigit = 0;
                try{
                    arrDigit = Integer.parseInt(array2Sum[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(array2Sum[i][j], i, j);
                }
                sum+=arrDigit;
            }
        }

        return sum;
    }
}
