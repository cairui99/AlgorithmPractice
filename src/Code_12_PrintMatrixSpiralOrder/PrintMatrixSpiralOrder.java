package Code_12_PrintMatrixSpiralOrder;

public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);
        }
    }

    public static void printEdge(int[][] m, int a, int b, int c, int d) {
        if (a != c && b != d) {
            int print = a;
            while (print < c) {
                System.out.print(m[print++][b] + " ");
            }
            print = b;
            while (print < d) {
                System.out.print(m[c][print++] + " ");
            }
            print = c;
            while (print > a) {
                System.out.print(m[print--][d] + " ");
            }
            print = d;
            while (print > b) {
                System.out.print(m[a][print--] + " ");
            }
        } else if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(m[a][i] + " ");
            }
        } else {
            for (int i = a; i <= c; i++) {
                System.out.print(m[i][b] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }

}
