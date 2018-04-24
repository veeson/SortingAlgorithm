package sort;

import static sort.Utility.swap;

/**
 * 简单选择排序
 */
public class SelectionSort {
    public void solution(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) { // 找到更小的数时，暂时不交换两个数，而是将更小的数的下表赋值给min
                    min = j;
                }
            }
            if (min != i) { // 如果min != i成立，说明有比nums[i]更小的数，交换之，让数组在位置i的数小于位置大于i的所有数
                swap(nums, i, min);
            }
        }
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new SelectionSort());
        SelectionSort sort = (SelectionSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
