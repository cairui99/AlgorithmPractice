package Code_13_RotateMatrix;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix.length - 1;
        while (a < c) {
            rotate(matrix, a++, b++, c--, d--);
        }
    }

    public static void rotate(int[][] matrix, int a, int b, int c, int d) {
        int w = a;
        int x = b;
        int y = c;
        int z = d;
        while (w < c) {
            int tmp = matrix[a][x];
            matrix[a][x] = matrix[y][a];
            matrix[y][a] = matrix[c][z];
            matrix[c][z] = matrix[x][d];
            matrix[x][d] = tmp;
            w++;
            x++;
            y--;
            z--;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}
