package leetcode.findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 11/28/21
 */
public class FindAnagramsSolutionV32 {

    public static void main(String[] args) {
        FindAnagramsSolutionV32 solution = new FindAnagramsSolutionV32();

        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> list = solution.findAnagrams(s1, s2);
        System.out.println(list);
    }


    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr = new int[26];
        for (int i=0; i<p.length(); i++) {
            char pchar = p.charAt(i);
            int index = pchar-'a';
            addOne(index, pArr);
        }

        int[] sArr = new int[26];
        int sCharMapCount = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            char schar = s.charAt(i);
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
            int beginIndex= i-p.length()+1;
            if (result) {
                list.add(beginIndex);
            }
            int beginCharIndex= s.charAt(beginIndex) - 'a';
            removeOne(beginCharIndex, sArr);
        }
        return list;
    }


    private void addOne(int index, int[] arr){
        arr[index]++ ;
    }
    private void removeOne(int index, int[] arr){
        arr[index]-- ;
    }



}
