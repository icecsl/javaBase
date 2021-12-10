package leetcode.numMatchingSubseq;

import leetcode.findAnagrams.FindAnagramsSolution;

import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 12/1/21
 */
public class NumMatchingSubseqSolution {

    public static void main(String[] args) {
        NumMatchingSubseqSolution solution = new NumMatchingSubseqSolution();

        String s = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        int result = solution.numMatchingSubseq(s, words);
        System.out.println(result);
    }

    public int numMatchingSubseq(String s, String[] words) {
        char[] sCharArr = s.toCharArray();
        int[][] sArr = new int[26][sCharArr.length];
        int slen = sCharArr.length;
        for (int i =0; i<slen; i++) {
            char schar = sCharArr[i];
            int index = schar-'a';
            int scharNum = sArr[index][0];
            sArr[index][0]++;
            sArr[index][scharNum+1] = i+1;
        }
        int nums = 0;
        for (String w:words){
            nums = nums+isMatch(sArr, w);
        }

        return nums;
    }

    private int isMatch(int[][] sArr, String w){
        char[] wCharArr = w.toCharArray();
        int pos = -1;
        for (char wchar : wCharArr) {
            int index = wchar - 'a';
            int[] sValue = sArr[index];
            // s中不存在这个字符
            if (sValue[0] == 0) {
                return 0;
            }

            int hasW = hasWord(sValue, pos);
            if (hasW != -1) {
                pos = hasW;
            } else {
                return 0;
            }
        }

        return 1;
    }

    private int hasWord(int[] sValue, int pos){
        for (int i =1; i<sValue.length; i++) {
            int sPos = sValue[i];
            if (sPos==0){
                return -1;
            }
            if (sPos > pos) {
                return sPos;
            }
        }
        return -1;
    }



}
