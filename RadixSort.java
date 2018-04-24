package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 基数排序
 * Created by Wilson on 2018/3/12.
 */
public class RadixSort {
    public void solution(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        // 获取int数组中的最大数
        for (int i = 1; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] temp = new int[length];
        /*
          根据exp的值确定对哪个原数组元素的位数排序
          exp = 1表示对个位排序
          exp = 10表示对十位排序
          exp = 100表示对白位排序
          ...
         */
        int exp = 1;
        while (max / exp > 0) {// 为true表示还没超过原数组元素中的最大位数
            /*
              创建包括10个桶的数组，每个桶的数值表示原数组元素的位数落在该桶的个数
              下标为0表示该桶容纳原数组中位数为0的个数
              下标为1表示该桶容纳原数组中位数为1的个数
              ...
              下标为9表示该桶容纳原数组中位数为9的个数
             */
            int[] buckets = new int[10];
            //将原数组元素的位数个数分别计算进各个桶中
            for (int i = 0; i < length; i++) {
                buckets[(nums[i] / exp) % 10]++;
            }
            // 更改buckets[i]，让更改后的buckets[i]的值，是该数据在output[]中的位置。
            for (int i = 1; i < buckets.length; i++) {
                buckets[i] += buckets[i - 1];
            }
            // 将数据存储到临时数组output[]中，这一步我的理解就是完成了根据位数的排序，比如根据各位、十位、百位等等的排序
            for (int i = length - 1; i >= 0; i--) {
                temp[--buckets[(nums[i] / exp) % 10]] = nums[i];
            }
            // 将根据位数排好序的临时数组赋值给元素组
            for (int i = 0; i < length; i++) {
                nums[i] = temp[i];
            }
            exp *= 10; // 往更高的位数移动
        }
    }

    public static void main(String[] args) {
        TestProxy proxy = new TestProxy(new RadixSort());
        RadixSort sort = (RadixSort) proxy.newInstance();
        sort.solution(Utility.randomArr());
    }
}
