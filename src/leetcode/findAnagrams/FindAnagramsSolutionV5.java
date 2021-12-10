package leetcode.findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 11/28/21
 */
public class FindAnagramsSolutionV5 {

    public static void main(String[] args) {
        FindAnagramsSolutionV5 solution = new FindAnagramsSolutionV5();

        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> list = solution.findAnagrams(s1, s2);
        System.out.println(list);
    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] pSArr = p.toCharArray();
        char[] scharArr = s.toCharArray();
        int[] pArr = new int[26];
        int[] sArr = new int[26];

        int lens = s.length(), lenp = p.length();
        for (int i = 0; i < lenp; i++) {pArr[pSArr[i] - 'a']++;}
        for (int i = 0; i < lenp; i++) {sArr[scharArr[i] - 'a']++;}
        if (Arrays.equals(pArr, sArr)) {
            list.add(0);
        }

        int sCharMapCount = lenp;
        int remove= scharArr[0] - 'a';
        removeOne(remove, sArr);

        for (int i = lenp; i < lens; i++){
            char schar = scharArr[i];
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
