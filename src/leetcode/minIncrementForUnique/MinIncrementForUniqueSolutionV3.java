package leetcode.minIncrementForUnique;


/**
 * 超出时间限制
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolutionV3 {

    public static void main(String[] args) {
        MinIncrementForUniqueSolutionV3 solution = new MinIncrementForUniqueSolutionV3();

//        int[] nums = new int[]{3,2,1,2,1,7};
        int[] nums = new int[]{1,2,2};
        int result = solution.minIncrementForUnique(nums);
        System.out.println(result);
    }



    public int minIncrementForUnique(int[] nums) {

        int len = nums.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        if (len == 2) {
            return nums[0] == nums[1]?1:0;
        }
        return remove(nums, len, 0);
    }

    private int remove(int[] nums, int leftCount, int moveCount){
        if (leftCount == 0){
            return moveCount;
        }
        // 找到最小值及个数
        int minNum = -1;
        int minCount = 0;
        for (int num : nums) {
            if (num == -1) {
                continue;
            }
            if (minNum == -1) {
                minNum = num;
            }
            if (num < minNum) {
                minNum = num;
                minCount = 0;
            }
            if (num == minNum) {
                minCount++;
            }
        }
//        if (minNum==-1) {
//            return 0;
//        }
        if (minCount > 1) {
            moveCount = moveCount + minCount*(minCount-1)/2;
        }

        int nextMinNum = minCount + minNum;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (num == -1) {
                continue;
            }
            if (num==minNum) {
                nums[i] = -1;
                leftCount--;
                continue;
            }
            if (num<nextMinNum) {
                moveCount = moveCount+ nextMinNum-num;
                nums[i] = nextMinNum;
            }
        }
        return remove(nums, leftCount, moveCount);

    }



}
