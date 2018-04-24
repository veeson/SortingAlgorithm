package sort;

import java.util.Random;

public class Utility {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] randomArr() {
        Random r = new Random(1024);
        int[] nums = new int[1024 * 10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(1024);
        }
        return nums;
    }
}
