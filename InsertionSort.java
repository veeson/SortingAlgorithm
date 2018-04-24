package sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public void solution(int[] nums) {
        // 直接插入排序(如-aight Insertion Sort) 的基本操作是将一个记录插入到已经排
        //好序的有序表中，从而得到一个新的、记录数增 1 的有序袭。
        int temp, j;
        for (int i = 1; i < nums.length; i++) { // i从1开始，因为i=0时只有一位数据，认为是有序的序列。
            temp = nums[i]; // 获取i位置的数据用于后面插入到前面的有序序列中
            // 遍历i前面的有序序列
            for (j = i - 1; j >= 0; j--) {
                // 如果temp < nums[j]，说明i前面的有序序列的j位置大于i位置的数据，需要将j位置的数据向后移动
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                } else { // 如果temp >= nums[j]，说明j位置的数据小于或者等于该位置或者该位置前面的所有数据，应该将数据插入到j+1的位置
                    break;
                }
            }
            nums[j+1] = temp; // 将数据插人到j+1的位置
        }
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new InsertionSort());
        InsertionSort sort = (InsertionSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
