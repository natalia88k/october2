package October2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int rowIndex, int columnIndex, String value) {
        super("Value on row # " + rowIndex + ", column # " + columnIndex + " is not a valid integer: " + value);
    }
}
