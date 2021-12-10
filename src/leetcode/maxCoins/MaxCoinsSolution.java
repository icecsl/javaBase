package leetcode.maxCoins;

import java.util.Arrays;

/** 太难了
 * https://leetcode-cn.com/problems/burst-balloons/
 * @Author: huangbingjing
 * @DATE: 12/5/21
 */
public class MaxCoinsSolution {

    public static void main(String[] args) {
        MaxCoinsSolution solution = new MaxCoinsSolution();
        //721504
        //668524

        // [1,3,1,5,8,1]
        // 3,15,40,40

        // 1,5,8 = 5+40+8=53;  40+8+8=56;  40+5+5=50

        // 5,1,8 =5+8+8=21  40+40+8=88 8+5+5=18

        // 1,8,5 = 8+40+8=56 40+5+5=50 40+8+8
        //9, 76, 97,60 - 684, 66348, 442320, 5820

//        int[] nums = new int[]{3,1,5,8};
//        int[] nums = new int[]{1,5};
        int[] nums = new int[]{9,76,64,21,97,60};
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
        int[] leftIndexArr = new int[len]; //[1,3,1,5]
        int[] rightIndexArr = new int[len];//[1,5,8,1]
        int[] innerArr = new int[len-2];
        for (int i=0; i<len; i++) {
            if (i==0){
                leftIndexArr[i] = -1;
            }else {
                leftIndexArr[i] = i-1;
            }
            if (i==len-1) {
                rightIndexArr[i] = -1;
            }else {
                rightIndexArr[i] = i+1;
            }
            if (i>0 && i<len-1 ){
                innerArr[i-1] = nums[i];
            }
        }
        Arrays.sort(innerArr);
        int maxCoins = 0;
        // 计算中间的
        for (int innerNum:innerArr) {
            for (int i=1; i<len-1; i++) {
                if (nums[i] == innerNum) {
                    maxCoins = maxCoins + nums[leftIndexArr[i]]*nums[i]*nums[rightIndexArr[i]];
                    removeOne(i, leftIndexArr, nums, rightIndexArr);
                    break;
                }
            }
        }

        maxCoins = maxCoins+caculateHT(len, nums);

        return maxCoins;

    }

    private void removeOne(int index, int[] leftIndexArr, int[] nums, int[] rightIndexArr){
        nums[index] = -1;

        // 左边index-1的位置的右边是它的右边
        rightIndexArr[leftIndexArr[index]] = rightIndexArr[index];
        // 右边index+1的位置的左边是它的左边
        leftIndexArr[rightIndexArr[index]] = leftIndexArr[index];
    }
    private int caculateHT(int len, int[] nums){
        int end = nums[0];
        if (nums[0]<nums[len-1]) {
            end = nums[len-1];
        }
        return nums[0]*nums[len-1] +end;
    }

}
