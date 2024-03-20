import java.util.Arrays;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        int maximumLength = 0;
        int[] emptyArray = new int[0];
        if(array2d == null){
            return emptyArray;
        }
        /*
        for(int i = 0; i < array2d.length; i++){
            if(array2d[i].length > maximumLength){
                maximumLength = array2d[i].length;
            }
        }*/
        for(int i = 0; i < array2d.length; i++){
            if(array2d[i].length != array2d[0].length) return emptyArray;
        }
        if(array2d.length != array2d[0].length) return emptyArray;
        int[] flattenArray = new int[array2d.length * array2d[0].length];
        int index = 0;
        int n = array2d.length;
        int rowStart = 0;
        int rowEnd = n-1;
        int columnStart = 0;
        int columnEnd = n-1;
        while(rowStart <= rowEnd && columnStart <= columnEnd){
            for(int i = columnStart; i <= columnEnd; i++){
                flattenArray[index] = array2d[rowStart][i];
                index = index + 1;
            }
            rowStart = rowStart + 1;
            for(int i = rowStart; i <= rowEnd; i++){
                flattenArray[index] = array2d[i][columnEnd];
                index = index + 1;
            }
            columnEnd = columnEnd-1;
            for(int i = columnEnd; i >= columnStart; i--){
                flattenArray[index] = array2d[rowEnd][i];
                index = index + 1;
            }
            rowEnd = rowEnd - 1;
            for(int i = rowEnd; i >= rowStart; i--){
                flattenArray[index] = array2d[i][columnStart];
                index = index + 1;
            }
            columnStart = columnStart + 1;
        }
        print1dArray(flattenArray);
        return flattenArray;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        int[][] emptyArray = new int[0][0];
        if(array1d == null){
            return emptyArray;
        }
        int n = (int) Math.sqrt(array1d.length);
        if(n*n != array1d.length){
            return emptyArray;
        }
        int[][] array2d = new int[n][n];
        int index = 0;
        int rowStart = 0;
        int rowEnd = n-1;
        int columnStart = 0;
        int columnEnd = n-1;
        while(index < array1d.length && rowStart <= rowEnd && columnStart <= columnEnd){
            for(int i = columnStart; i <= columnEnd; i++){
                array2d[rowStart][i] = array1d[index];
                index = index + 1;
            }
            rowStart = rowStart + 1;
            for(int i = rowStart; i <= rowEnd; i++){
                array2d[i][columnEnd] = array1d[index];
                index = index + 1;
            }
            columnEnd = columnEnd - 1;
            for(int i = columnEnd; i >= columnStart; i--){
                array2d[rowEnd][i] = array1d[index];
                index = index + 1;
            }
            rowEnd = rowEnd - 1;
            for(int i = rowEnd; i >= rowStart; i--){
                array2d[i][columnStart] = array1d[index];
                index = index + 1;
            }
            columnStart = columnStart + 1;
        }
        print2dArray(array2d);
        return array2d;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        System.out.println(Arrays.toString(array1d));
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        System.out.println(Arrays.deepToString(array2d));
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        int sqrt = (int) Math.sqrt(array1d.length);
        return sqrt * sqrt == length;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int rows = array2d.length;
        int columns = array2d[0].length;
        return rows == columns;
    }


}
