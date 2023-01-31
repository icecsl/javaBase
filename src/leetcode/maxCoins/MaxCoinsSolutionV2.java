package leetcode.maxCoins;

import java.util.Arrays;

/**
 * @Author: huangbingjing
 * @DATE: 12/28/21
 */
public class MaxCoinsSolutionV2 {

    public static void main(String[] args) {
        MaxCoinsSolutionV2 solution = new MaxCoinsSolutionV2();
        //721504
        //668524

        // [1,3,1,5,8,1]
        // 3,15,40,40

        // 1,5,8 = 5+40+8=53;  40+8+8=56;  40+5+5=50

        // 5,1,8 =5+8+8=21  40+40+8=88 8+5+5=18

        // 1,8,5 = 8+40+8=56 40+5+5=50 40+8+8
        //9, 76, 97,60 - 684, 66348, 442320, 5820

//        int[] nums = new int[]{3,1,5,8};
        int[] nums = new int[]{9,76,64,21,97,60,5};
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
        int[] leftIndexArr = new int[len]; //[1,3,1,5]
        int[] rightIndexArr = new int[len];//[1,5,8,1]
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
        }

        return eachArr(nums, leftIndexArr, rightIndexArr, 0);

    }

    /**
     * 遍历
     */
    private int eachArr(int[] nums, int[] leftIndexArr, int[] rightIndexArr, int sum){

        int maxSum = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (num==-1) {
                continue;
            }

            if (i == nums.length-1) {
                // 选
                int left = leftIndexArr[i]<0? 1: nums[leftIndexArr[i]];
                int right = rightIndexArr[i] <0? 1: nums[rightIndexArr[i]];
                removeOne(i, leftIndexArr, nums, rightIndexArr);
//                int select = left*num*right;
                int select = eachArr(nums, leftIndexArr, rightIndexArr, left*num*right);
                System.out.println(left+" "+num+" "+right +" "+ Arrays.toString(nums));
                if (select > maxSum) {
                    maxSum = select;
                }
                break;
            }

            int[] copyNums = Arrays.copyOf(nums, nums.length);
            int[] copyLeft = Arrays.copyOf(leftIndexArr, leftIndexArr.length);
            int[] copyRight = Arrays.copyOf(rightIndexArr, rightIndexArr.length);

            // 选
            int left = leftIndexArr[i]<0? 1: nums[leftIndexArr[i]];
            int right = rightIndexArr[i] <0? 1: nums[rightIndexArr[i]];
            removeOne(i, leftIndexArr, nums, rightIndexArr);
            System.out.println(left+" "+num+" "+right+" "+ Arrays.toString(nums));
            int select = eachArr(nums, leftIndexArr, rightIndexArr, left*num*right);
            if (select > maxSum) {
                maxSum = select;
            }

            nums = copyNums;
            leftIndexArr = copyLeft;
            rightIndexArr = copyRight;
        }
        return sum + maxSum;
    }

    private void removeOne(int index, int[] leftIndexArr, int[] nums, int[] rightIndexArr){
        nums[index] = -1;

        // 左边index-1的位置的右边是它的右边
        if (leftIndexArr[index] >=0) {
            rightIndexArr[leftIndexArr[index]] = rightIndexArr[index];
        }

        // 右边index+1的位置的左边是它的左边
        if (rightIndexArr[index] >= 0) {
            leftIndexArr[rightIndexArr[index]] = leftIndexArr[index];
        }

        rightIndexArr[index] = -1;
        leftIndexArr[index] = -1;
    }
    private int caculateHT(int len, int[] nums){
        int end = nums[0];
        if (nums[0]<nums[len-1]) {
            end = nums[len-1];
        }
        return nums[0]*nums[len-1] +end;
    }

    /**
     * 遍历
     *//*
    private int eachArr(int[] nums, int[] leftIndexArr, int[] rightIndexArr, int sum){

        boolean hasChoose = false;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (num==-1) {
                continue;
            }
            if (i==nums.length-1 && !hasChoose) {
                // 选
                int left = i==0? 1: nums[i-1];
                int right = i==nums.length-1? 1: nums[i+1];
                removeOne(i, leftIndexArr, nums, rightIndexArr);
                int select = eachArr(nums, leftIndexArr, rightIndexArr, sum + num * left * right);
                return sum+ select;
            }

            continue;

            // 不选
            int unselect = eachArr(nums, leftIndexArr, rightIndexArr, sum);
            continue;

            // 选
            int left = i==0? 1: nums[i-1];
            int right = i==nums.length-1? 1: nums[i+1];
            removeOne(i, leftIndexArr, nums, rightIndexArr);
            int select = eachArr(nums, leftIndexArr, rightIndexArr, sum + num * left * right);
            hasChoose = true;
            if (unselect>select) {
                sum = sum+ unselect;
            }else {
                sum = sum+ select;
            }
            break;
        }


        return sum;
    }
*/

    /**
     * 戳第i个
     */
    private int prickI(int[] nums, int[] leftIndexArr, int[] rightIndexArr, int sum, int i){

        int num = nums[i];
        if (num==-1) {
            return sum;
        }
        // 选
        int left = i==0? 1: nums[i-1];
        int right = i==nums.length-1? 1: nums[i+1];
        sum = sum+num * left * right;
        removeOne(i, leftIndexArr, nums, rightIndexArr);
        return sum;
    }




}
