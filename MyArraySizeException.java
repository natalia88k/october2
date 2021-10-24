package October2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int numOfRows) {
        super("Input array should have 4 rows, got " + numOfRows);
    }

    public MyArraySizeException(int rowIndex, int numOfColumns) {
        super("Row #" + rowIndex + " should have 4 columns, got " + numOfColumns);
    }
}
