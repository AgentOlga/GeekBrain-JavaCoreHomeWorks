package ru.geekbrains.JavaCore;


public class Cyber {
    public static void main(String[] args) {
        Cyber main = new Cyber();
        String[][] correct = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "30", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect3 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "b", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            main.stringExceptionTest(correct);
            //main.stringExceptionTest(incorrect);
            //main.stringExceptionTest(incorrect2);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        int sum = sumup(correct);
        //int sum = sumup(incorrect3);

        System.out.println("sum = " + sum);
    }

    private static int sumup(String[][] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[i].length; j++)
                    sum += convert(arr, i, j);
        }
        catch (MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
        return sum;
    }

    private static int convert(String[][] arr, int i, int j) throws MyArrayDataException {
        int result;
        try{
            result = Integer.valueOf(arr[i][j]);
        }
        catch (NumberFormatException ex){
            throw new MyArrayDataException(i, j);
        }
        return result;
    }

    public void stringExceptionTest(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4)
            throw new MyArraySizeException("Wrong number of lines");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException(String.format("Wrong number of columns in %s line", i));
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}










