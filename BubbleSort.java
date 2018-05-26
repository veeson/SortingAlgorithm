package sort;

import static sort.Utility.swap;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public void solution1(int[] nums) {
        // 简单粗暴的冒泡算法
        // 便利和交换次数较多，而且可能会将较小的数交换到更后面的位置，效率低下
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public void solution2(int[] nums) {
        // 改进的冒泡算法（一）
        // 从后面开始往前便利比较相邻连个数，将较小的数往前挪，能较少后面便利的时候数据交换的次数。
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = nums.length - 2; j >= i; j--) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                }
//            }
//        }
//        return nums;

        // 鸡尾酒排序
        // 先对数组从左到右进行冒泡排序（升序），则最大的元素去到最右端
        // 再对数组从右到左进行冒泡排序（降序），则最小的元素去到最左端
        // 以此类推，依次改变冒泡的方向，并不断缩小未排序元素的范围，直到最后一个元素结束
        int i, left = 0, right = nums.length - 1;
        while (left < right) {
            for (i = left; i < right; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            right--;
            for (i = right; i > left; i--) {
                if (nums[i] < nums[i-1]) {
                    swap(nums, i, i - 1);
                }
            }
            left++;
        }
    }

    public void solution3(int[] nums) {
		// 改进的冒泡算法（二）
        // 设置一个标志为，当某次遍历出现不需要交换数据的情况时，表示此时数组已经是有序的了，这时候就可以退出循环了，能大大减少无意义的循环遍历
        boolean flag = true;
        for (int i = 0; i < nums.length - 1 && flag; i++) {
            flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {9, 1, 5, 8, 3, 7, 4, 6, 2};
//        System.out.println(Arrays.toString(solution1(nums)));
//        int[] nums2 = {9, 1, 5, 8, 3, 7, 4, 6, 2};
//        System.out.println(Arrays.toString(solution2(nums2)));
//        int[] nums3 = {9, 1, 5, 8, 3, 7, 4, 6, 2};
//        System.out.println(Arrays.toString(solution3(nums3)));

        TestProxy proxy = new TestProxy(new BubbleSort());
        BubbleSort sort = (BubbleSort) proxy.newInstance();
        sort.solution3(Utility.randomArr());
    }
}
