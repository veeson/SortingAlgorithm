package sort;

/**
 * 归并排序
 */
public class MergeSort {
    public void solution(int[] nums) {
        int[] temp = new int[nums.length];
        mSort(nums, temp, 0, nums.length - 1);
    }

    private void mSort(int[] nums, int[] temp, int first, int last) {
        if (first < last) { // 判断大小下标的大小关系
            int mid = (first + last) / 2; // 获取大小下标的中点下标
            // 先排好左右序列
            // 递归调用mSort函数，直到每个序列都只包含一个元素，这时候认为这个单个元素的序列有序
            mSort(nums, temp, first, mid); // 左边有序
            mSort(nums, temp, mid + 1, last); // 右边有序
            // 然后将左右有序的数据合并
            merge(nums, temp, first, mid, last);
        }
    }

    /**
     * 将nums[first...mid]和nums[mid+1...last]这两个有序的的序列合并
     *
     * @param nums
     * @param temp
     * @param first
     * @param mid
     * @param last
     */
    private void merge(int[] nums, int[] temp, int first, int mid, int last) {
        int i, j, k;
        // 将两个有序序列合并成一个有序序列
        for (i = first, j = mid + 1, k = 0; i <= mid && j <= last; k++) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
        }

        // 如果左序列还有没完全添加入temp数组的数据，添加之
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 如果右序列还有没完全添加入temp数组的数据，添加之
        while (j <= last) {
            temp[k++] = nums[j++];
        }

        // 将temp有序序列覆盖原序列的无序数据，此时nums[first...last]是有序的
        for (int l = 0; l < k; l++) {
            nums[first + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new MergeSort());
        MergeSort sort = (MergeSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
