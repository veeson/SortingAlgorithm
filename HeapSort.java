package sort;

import static sort.Utility.swap;

/**
 * 堆排序
 */
public class HeapSort {

    public void solution(int[] nums) {
        buildMaxHeap(nums); // 创建最大推
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapify2(nums, 0, i); // 将剩下还没还没排好序的数据调整成最大推
        }
    }

//    private static void maxHeapify(int[] nums, int index, int heapSize) {
//        int left, right, max;
//        while (true) {
//            max = index;
//            left = index * 2 + 1;
//            right = 2 * (index + 1);
//            if (left < heapSize && nums[left] > nums[index]) {
//                max = left;
//            }
//            if (right < heapSize && nums[max] < nums[right]) {
//                max = right;
//            }
//            if (max != index) {
//                swap(nums, max, index);
//                index = max;
//            } else {
//                break;
//            }
//        }
//    }

    // 递归法
    private void maxHeapify2(int[] nums, int index, int heapSize) {
        int left, right, max;
        max = index;
        left = index * 2 + 1;
        right = 2 * (index + 1);
        // index（开始）结点树与左子树进行比较，如果比左子树小，max = left
        if (left < heapSize && nums[left] > nums[index]) {
            max = left;
        }
        // max节点与右子树进行比较，如果比右子树小，max = right
        if (right < heapSize && nums[max] < nums[right]) {
            max = right;
        }
        // 如果max != index，表示index（开始）结点树比左右子树的其中一个或者全部小
        if (max != index) {
            swap(nums, max, index); // 将max结点和index（开始）结点树交换位置
            // 递归，将max作为下一次比较的index（开始）结点树
            maxHeapify2(nums, max, heapSize);
        }
    }

    private void buildMaxHeap(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            maxHeapify2(nums, i, nums.length);
        }
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new HeapSort());
        HeapSort sort = (HeapSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
