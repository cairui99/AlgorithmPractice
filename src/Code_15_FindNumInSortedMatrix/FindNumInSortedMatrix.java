package Code_15_FindNumInSortedMatrix;

public class FindNumInSortedMatrix {

    public static boolean isContains(int[][] matrix, int K) {
        int[] index = {0, matrix[0].length - 1}; //从右上角开始找
        while (index[0] < matrix.length && index[1] >= 0) {
            if (matrix[index[0]][index[1]] == K) {
                return true;
            } else if (matrix[index[0]][index[1]] > K) {
                index[1]--;
            } else if (matrix[index[0]][index[1]] < K) {
                index[0]++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }

}
