package leetcode.minIncrementForUnique;


/**
 * 超出内存限制
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolution {

    public static void main(String[] args) {
        MinIncrementForUniqueSolution solution = new MinIncrementForUniqueSolution();

//        int[] nums = new int[]{3,2,1,2,1,7};
        int[] nums = new int[]{1,2,2};
        int result = solution.minIncrementForUnique(nums);
        System.out.println(result);
    }



    public int minIncrementForUnique(int[] nums) {
        // 找到最大值
        int maxNum = 0;
        int maxCount = 1;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            maxCount = maxCount+i;
            if (num>maxNum){
                maxNum = num;
            }

        }

        // 初始化最大长度的数组
        int[] posNumArr = new int[maxNum+maxCount];

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
