package leetcode.minIncrementForUnique;


import java.util.*;

/**
 * map  无语.. 283s
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolutionV7 {

    public static void main(String[] args) {
        MinIncrementForUniqueSolutionV7 solution = new MinIncrementForUniqueSolutionV7();

//        int[] nums = new int[]{3,2,1,2,1,7};
        int[] nums = new int[]{0,1,2,2,2};
//        int[] nums = new int[]{1,2,2};
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

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num :nums) {
            put(map, num);
        }




        int minNum = -1;
        int moveCount = 0;
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {

            int currNum = entry.getKey();
            int minCount = entry.getValue();
            if (minNum == -1 ||currNum>minNum){
                minNum = currNum;
            }
            if (currNum<minNum){
                moveCount = moveCount + (minNum - currNum)*minCount;
            }
            if (minCount>1) {
                moveCount = moveCount + minCount * (minCount - 1) / 2;
            }
            minNum = minCount + minNum;
        }

        return moveCount;
    }

    private void put(Map<Integer, Integer> map, int key){
        Integer value = map.getOrDefault(key, 0);
        value++;
        map.put(key, value);
    }


}
