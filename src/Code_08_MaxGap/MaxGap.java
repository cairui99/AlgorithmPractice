package Code_08_MaxGap;

import java.util.Arrays;

public class MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (min == max) {
            return 0;
        }

        //每个桶的范围。
        float difference =  (float) (max - min) / nums.length;

        int[] barrels_min = new int[nums.length + 1];
        int[] barrels_max = new int[nums.length + 1];
        boolean[] barrels_bool = new boolean[nums.length + 1];

        barrels_min[0] = min;
        barrels_max[0] = min;
        barrels_bool[0] = true;
        barrels_min[barrels_min.length - 1] = max;
        barrels_max[barrels_max.length - 1] = max;
        barrels_bool[barrels_bool.length - 1] = true;

        for (int num : nums) {
            int index = (int) ((num - min) / difference);
            if (barrels_bool[index]) {
                barrels_min[index] = Math.min(barrels_min[index], num);
                barrels_max[index] = Math.max(barrels_max[index], num);
            } else {
                barrels_bool[index] = true;
                barrels_min[index] = num;
                barrels_max[index] = num;
            }
        }

        int maxGap = barrels_max[0] - barrels_min[0];
        int number = barrels_max[0];

        for (int i = 1; i < barrels_min.length; i++) {
            if (barrels_bool[i]) {
                maxGap = Math.max(maxGap, (barrels_min[i] - number));
                number = barrels_max[i];
            }
        }

        return maxGap;
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 5;
        int maxValue =10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
