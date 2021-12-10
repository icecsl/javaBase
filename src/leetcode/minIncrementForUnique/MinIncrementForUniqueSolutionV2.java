package leetcode.minIncrementForUnique;


/**
 * 超出内存限制
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolutionV2 {

    public static void main(String[] args) {
        MinIncrementForUniqueSolutionV2 solution = new MinIncrementForUniqueSolutionV2();

        int[] nums = new int[]{3,2,1,2,1,7};
//        int[] nums = new int[]{1,2,2};
        int result = solution.minIncrementForUnique(nums);
        System.out.println(result);
    }



    public int minIncrementForUnique(int[] nums) {
        // 找到最大值和最小值
        int maxNum = 0;
        int minNum = nums[0];
        for (int num :nums) {
            if (num>maxNum){
                maxNum = num;
            }
            if (num<minNum){
                minNum = num;
            }
        }
        if (minNum != 0) {
            for (int i=0; i<nums.length; i++) {
                nums[i] = nums[i] - minNum;
            }
        }

        // 找到最大值
        maxNum = maxNum- minNum;
        int deduct = maxNum==0?1:2;
        int len = nums.length;
        int maxCount = (1+(len-deduct))*(len-deduct)/2;

        // 初始化最大长度的数组
        int[] posNumArr = new int[maxNum+maxCount+1];

        int count = 0;
        for (int num :nums) {
            count = put(posNumArr, num, count);
        }

        return count;
    }

    private int put(int[] posNumArr, int index, int count){
        if (posNumArr[index] == -1) {
            count++;
            count = put(posNumArr,index+1, count);
            return count;
        }else {
            posNumArr[index] = -1;
            return count;
        }
    }


}
