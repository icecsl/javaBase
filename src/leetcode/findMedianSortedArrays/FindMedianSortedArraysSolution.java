package leetcode.findMedianSortedArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: huangbingjing
 * @DATE: 2020-07-30
 */
public class FindMedianSortedArraysSolution {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{1, 2};

        double res =  findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;
        int midle = size/2 + 1;
        int flag = size % 2 == 0 ? 0:1;

        Map<Integer, Integer> map = new TreeMap<>();
        handleMap(nums1, map);
        handleMap(nums2, map);
        int count = 0;
        Integer lastKey = null ;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getValue();
            int key = entry.getKey();
            count = count + value;
            if (count < midle) {
                lastKey = key;
                continue;
            }
            if (count == midle) {
                if (flag == 1) {
                    return key;
                }else {
                    if (null == lastKey) {
                        return key;
                    }
                    return (key + lastKey)*1.0/2;

                }
            }
            if (count > midle) {
                return key;
            }

        }
        return 0;
    }

    public static void handleMap(int[] nums, Map<Integer, Integer> map){
        for (int n: nums) {
            Integer value = map.get(n);
            value = value == null ? 0:value;
            map.put(n, value+1);
        }
    }

}
