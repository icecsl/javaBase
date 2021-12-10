package leetcode.numMatchingSubseq;

/**
 * @Author: huangbingjing
 * @DATE: 12/1/21
 */
public class NumMatchingSubseqSolutionV2 {

    public static void main(String[] args) {
        NumMatchingSubseqSolutionV2 solution = new NumMatchingSubseqSolutionV2();

        String s = "dsahjpjauf";
        String[] words = new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
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
        for (char wchar : wCharArr) {
            int index = wchar - 'a';
            int[] sValue = sArr[index];
            // s中不存在这个字符
            if (sValue == null) {
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
        for (int sPos : sValue) {
            if (sPos > pos) {
                return sPos;
            }
        }
        return -1;
    }

}
