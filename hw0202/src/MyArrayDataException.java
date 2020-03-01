public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String val, int i, int j) {
        super("Ячейка ["+i+"]["+j+"] = " + val + " не может быть преобразована к числу");
    }
}
