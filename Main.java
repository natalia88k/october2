package October2;

public class Main {
    public static void main(String[] args) {
        testCorrectValues();
        testIncorrectNumOfRows();
        testIncorrectNumOfColumns();
        testTextInsteadOfIntegerValues();
        testSymbolsInsteadOfIntegerValues();
    }

    public static void testCorrectValues() {
        String[][] values = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        int result = 0;

        try {
            result = calculateSum(values);
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
        }

        if (result == 136) {
            System.out.println("Test is correct! Calculated value is equal to expected!");
        }
    }

    public static void testIncorrectNumOfRows() {
        String[][] values = {
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        int result = 0;

        try {
            result = calculateSum(values);
        } catch (MyArraySizeException e) {
            System.out.println("Test is correct! Got exception: " + e.toString());
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
        }
    }

    public static void testIncorrectNumOfColumns() {
        String[][] values = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11"},
                {"13", "14", "15", "16"}
        };

        int result = 0;

        try {
            result = calculateSum(values);
        } catch (MyArraySizeException e) {
            System.out.println("Test is correct! Got exception: " + e.toString());
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
        }
    }

    public static void testTextInsteadOfIntegerValues() {
        String[][] values = {
                {"1", "a", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        int result = 0;

        try {
            result = calculateSum(values);
        } catch (MyArrayDataException e) {
            System.out.println("Test is correct! Got exception: " + e.toString());
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
        }
    }

    public static void testSymbolsInsteadOfIntegerValues() {
        String[][] values = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "1!", "12"},
                {"13", "14", "15", "16"}
        };

        int result = 0;

        try {
            result = calculateSum(values);
        } catch (MyArrayDataException e) {
            System.out.println("Test is correct! Got exception: " + e.toString());
        } catch (Exception e) {
            System.out.println("Test failed: " + e.toString());
        }
    }

    public static int calculateSum(String[][] values) throws MyArraySizeException, MyArrayDataException {
        if (values.length != 4) {
            throw new MyArraySizeException(values.length);
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i].length != 4) {
                throw new MyArraySizeException(i + 1, values[i].length);
            }
        }

        int result = 0;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                try {
                    result += Integer.parseInt(values[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1, values[i][j]);
                }
            }
        }

        return result;
    }
}
