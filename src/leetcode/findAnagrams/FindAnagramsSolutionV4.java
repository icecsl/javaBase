package leetcode.findAnagrams;

import java.util.*;

/**
 * @Author: huangbingjing
 * @DATE: 11/28/21
 */
public class FindAnagramsSolutionV4 {

    public static void main(String[] args) {
        FindAnagramsSolutionV4 solution = new FindAnagramsSolutionV4();

        String s1 = "abab";
        String s2 = "ab";
        List<Integer> list = solution.findAnagrams(s1, s2);
        System.out.println(list);
    }


    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        int oriMissCount = getMissCount(p, pArr);

        int sCharMapCount = 0;
        char[] scharArr = s.toCharArray();
        int index= -1;
        int missCount = oriMissCount;
        List<Integer> list = new ArrayList<>();
        for (char schar : scharArr) {
            index++;
            // 看p里面是否有该元素
            int sCharIndex = schar-'a';
            int pValue = pArr[sCharIndex];
            if (pValue == 0) {
                sArr = new int[26];
                sCharMapCount = 0;
                missCount = oriMissCount;
                continue;
            }
            sCharMapCount ++ ;
            if (sCharMapCount < p.length()) {
                missCount = getMissCount(sArr,pArr,pValue, sCharIndex, -1, missCount);
                continue;
            }
            int beginIndex= index-p.length()+1;
            int removeIndex = -1;
            if (sCharMapCount > p.length()){
                removeIndex = scharArr[beginIndex-1] - 'a';
            }
            missCount = getMissCount(sArr,pArr,pValue, sCharIndex, removeIndex, missCount);
            if (missCount == 0) {
                list.add(beginIndex);
            }
        }
        return list;
    }

    private int getMissCount(int[] sArr, int[] pArr,int pValue, int addIndex, int removeIndex, int missCount){
        if (removeIndex != -1 && addIndex == removeIndex) {
            return missCount;
        }

        if (removeIndex != -1) {
            int removeValue = sArr[removeIndex];
            sArr[removeIndex] --;
            int diff = removeValue-pArr[removeIndex];
            if (diff == 0){
                missCount++;
            }
            if (diff == 1){
                missCount--;
            }
        }

        int addValue = sArr[addIndex];
        int diff = addValue-pValue;
        sArr[addIndex] ++;
        if (diff == 0){
            missCount++;
        }
        if (diff == -1){
            missCount--;
        }
        return missCount;
    }

    private int getMissCount(String p, int[] pArr){
        int missCount = 0;
        for (char pchar: p.toCharArray()) {
            int index = pchar-'a';
            int count = pArr[index];
            if (count == 0) {
                missCount++;
            }
            count++;
            pArr[index] = count;
        }
        return missCount;
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
