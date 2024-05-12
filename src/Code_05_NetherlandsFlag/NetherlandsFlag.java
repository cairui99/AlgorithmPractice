package Code_05_NetherlandsFlag;

public class NetherlandsFlag {

    public static void partition(int[] arr, int num) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int less = -1;
        int more = arr.length;
        int index = 0;
        while (index < more) {
            if (arr[index] < num) {
                swap(arr, less + 1, index);
                less++;
                index++;
            } else if (arr[index] == num) {
                index++;
            } else {
                swap(arr, index, more - 1);
                index++;
                more--;
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }


}
