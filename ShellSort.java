package sort;

/**
 * 希尔排序
 */
public class ShellSort {
    public void solution(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) { // 将数据进行平均分组，确定每个组的数据大小，当每组都不能再分，即gap=0时表示数组已经是有序的了
            for (int i = 0; i < gap; i++) { // 遍历每个分组
                int temp, j;
                for (int k = gap; k < nums.length; k += gap) { // 对每个分组里面的数据进行插入排序
                    temp = nums[k];
                    for (j = k; j > 0; j -= gap) {
                        if (temp < nums[j - gap]) {
                            nums[j] = nums[j - gap];
                        } else {
                            break;
                        }
                    }
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new ShellSort());
        ShellSort sort = (ShellSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
