package Code_14_ZigZagPrintMatrix;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int[] a = {0, 0};
        int[] b = {0, 0};
        boolean flag = true;
        while (true) {
            printMatrixZigZag(matrix, a, b, flag);
            flag = !flag;
            if (a[1] < matrix[0].length - 1) {
                a[1]++;
            } else {
                a[0]++;
            }
            if (b[0] < (matrix.length - 1)) {
                b[0]++;
            } else {
                b[1]++;
            }
            if (a[0] == b[0] && a[1] == b[1]) {
                System.out.print(matrix[matrix.length - 1][matrix[0].length - 1]);
                break;
            }
        }

    }

    public static void printMatrixZigZag(int[][] matrix, int[] a, int[] b, boolean flag) {
        int[] index = new int[2];
        index[0] = flag ? a[0] : b[0];
        index[1] = flag ? a[1] : b[1];
        while (true) {
            System.out.print(matrix[index[0]][index[1]] + " ");
            if ((flag && index[0] == b[0]) || (!flag && index[0] == a[0])) {
                break;
            }
            index[0] = flag ? index[0] + 1 : index[0] - 1;
            index[1] = flag ? index[1] - 1 : index[1] + 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }

}
