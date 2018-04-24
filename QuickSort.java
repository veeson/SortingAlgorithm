package sort;

import static sort.Utility.swap;

/**
 * 快速排序
 */
public class QuickSort {
    public void solution(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private void qSort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = getPartition(nums, low, high);
            qSort(nums, low, partition - 1);
            qSort(nums, partition + 1, high);
        }
    }

    private int getPartition(int[] nums, int low, int high) {
        int partition = nums[low]; // 关键字
        while (low < high) {
            while (low < high && nums[high] >= partition) {
                high--;
            }
            swap(nums, low, high);
            while (low < high && nums[low] <= partition) {
                low++;
            }
            swap(nums, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new QuickSort());
        QuickSort sort = (QuickSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
