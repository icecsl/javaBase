package leetcode.findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @Author: huangbingjing
 * @DATE: 11/28/21
 */
public class FindAnagramsSolutionV3 {

    public static void main(String[] args) {
        FindAnagramsSolutionV3 solution = new FindAnagramsSolutionV3();

        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> list = solution.findAnagrams(s1, s2);
        System.out.println(list);
    }


    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr = new int[26];
        for (char pchar: p.toCharArray()) {
            int index = pchar-'a';
            addOne(index, pArr);
        }

        int[] sArr = new int[26];
        int sCharMapCount = 0;
        char[] scharArr = s.toCharArray();
        int index= -1;
        List<Integer> list = new ArrayList<>();
        for (char schar : scharArr) {
            index++;
            // 看p里面是否有该元素
            int sCharIndex = schar-'a';
            int pValue = pArr[sCharIndex];
            if (pValue == 0) {
                sArr = new int[26];
                sCharMapCount = 0;
                continue;
            }
            addOne(sCharIndex, sArr);
            sCharMapCount ++ ;
            if (sCharMapCount < p.length()) {
                continue;
            }

            boolean result = pValue == sArr[sCharIndex] && Arrays.equals(pArr, sArr);
            int beginIndex= index-p.length()+1;
            if (result) {
                list.add(beginIndex);
            }
            int beginCharIndex= scharArr[beginIndex] - 'a';
            removeOne(beginCharIndex, sArr);
        }
        return list;
    }


    private void addOne(int index, int[] arr){
        int count = arr[index];
        count++;
        arr[index]=count;
    }
    private void removeOne(int index, int[] arr){
        int count = arr[index];
        count--;
        arr[index]=count;
    }



}
