package leetcode.numMatchingSubseq;

/**
 * @Author: huangbingjing
 * @DATE: 12/1/21
 */
public class NumMatchingSubseqSolutionV3 {

    public static void main(String[] args) {
        NumMatchingSubseqSolutionV3 solution = new NumMatchingSubseqSolutionV3();

        String s = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        int result = solution.numMatchingSubseq(s, words);
        System.out.println(result);
    }

    public int numMatchingSubseq(String s, String[] words) {
        char[] sCharArr = s.toCharArray();
        int slen = sCharArr.length;
        //计算s的字符数
        int[] sCharNumArr = new int[26];
        for (char schar : sCharArr) {
            int index = schar - 'a';
            sCharNumArr[index]++;
        }

        //初始化s字符位置
        int[][] sArr = new int[26][];
        int[] sCharCountArr = new int[26];
        for (int i =0; i<slen; i++) {
            char schar = sCharArr[i];
            int index = schar-'a';

            if (sArr[index] == null) {
                sArr[index] = new int[sCharNumArr[index]];
            }
            int scharNum = sCharCountArr[index];
            sCharCountArr[index]++;
            sArr[index][scharNum] = i;
        }

        // 计算匹配数
        int nums = 0;
        for (String w:words){
            nums = nums+isMatch(sArr, w);
        }

        return nums;
    }

    private int isMatch(int[][] sArr, String w){
        char[] wCharArr = w.toCharArray();
        int pos = -1;
        int[] posIndexArr ={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        for (char wchar : wCharArr) {
            int index = wchar - 'a';
            int[] sValue = sArr[index];
            // s中不存在这个字符
            if (sValue == null) {
                return 0;
            }

            int hasW = hasWord(sValue, pos, index, posIndexArr);
            if (hasW != -1) {
                pos = hasW;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private int hasWord(int[] sValue, int pos, int posIndex, int[] posIndexArr){
        int lastIndex = posIndexArr[posIndex];
        for (int i =lastIndex+1; i<sValue.length; i++) {
            int sPos = sValue[i];
            if (sPos > pos) {
                posIndexArr[posIndex] = i;
                return sPos;
            }
        }
        return -1;
    }

}
