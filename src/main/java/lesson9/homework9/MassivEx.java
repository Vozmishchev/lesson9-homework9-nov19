package lesson9.homework9;

public class MassivEx {
    public static void main(String[] args) {


        String[][] arr = new String[][]{{"0", "1", "1", "0"}, {"0", "1", "0", "1"}, {"1", "1", "1", "1"}, {"0", "0", "1", "1"}};
        try {
            try {
                int sum = massiveExc(arr);
                System.out.println(sum);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен.");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива.");
            System.out.println("Ошибка в ячейке: " + e.i + "*" + e.j);
        }
    }


    public static int massiveExc(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
}
