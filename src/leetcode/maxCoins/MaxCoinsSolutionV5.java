package leetcode.maxCoins;

import java.util.ArrayList;
import java.util.List;

/**
 * 每次挑最大的是不是最大的？
 * @Author: huangbingjing
 * @DATE: 12/29/21
 */
public class MaxCoinsSolutionV5 {
    public static void main(String[] args) {
        MaxCoinsSolutionV5 solution = new MaxCoinsSolutionV5();
        int[] nums = new int[]{35,16,83,87,84,59,48,41,20,54,11};
//        int[] nums = new int[]{2,3,7,9,1};
//        int[] nums = new int[]{9,76,64,21,97,60,5};
//        int[] nums = new int[]{1,5};
//        int[] nums = new int[]{9,76,64,21,97,60};
        int result = solution.maxCoins(nums);
        System.out.println(result);
    }

    public int maxCoins(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return caculateHT(len, nums);
        }

        List<Integer> list = new ArrayList<>(len+2);
        list.add(1);
        for (int i:nums) {
            list.add(i);
        }
        list.add(1);

        return eachArrV2(list,  0);

    }

    /**
     * 遍历
     */
    private int eachArr(List<Integer> list, int sum){
        int max = 0;
        int maxIndex = 0;
        for (int i=1; i<list.size()-2; i++) {
            int mul = list.get(i-1) * list.get(i) * list.get(i+1);
            if (mul==max && list.get(i) <list.get(maxIndex)) {
                maxIndex = i;
            }
            if (mul>max) {
                max = mul;
                maxIndex = i;
            }
        }
        list.remove(maxIndex);
        if (list.size()>2) {
            return eachArr(list, sum+max);
        }
        return sum+max;
    }

    /**
     * 每次选择比周围小的数
     */
    private int eachArrV2(List<Integer> list, int sum){
        int max = 0;
        int maxIndex = 0;
        for (int i=1; i<list.size()-2; i++) {
            int mul = list.get(i-1) * list.get(i) * list.get(i+1);
            if (list.get(i)<list.get(i-1)&& list.get(i)<list.get(i+1)){
                max = mul;
                maxIndex = i;
                break;
            }
            if (mul==max && list.get(i) <list.get(maxIndex)) {
                maxIndex = i;
            }
            if (mul>max) {
                max = mul;
                maxIndex = i;
            }
        }
        list.remove(maxIndex);
        if (list.size()>2) {
            return eachArrV2(list, sum+max);
        }
        return sum+max;
    }

    private int caculateHT(int len, int[] nums){
        int end = nums[0];
        if (nums[0]<nums[len-1]) {
            end = nums[len-1];
        }
        return nums[0]*nums[len-1] +end;
    }
}
