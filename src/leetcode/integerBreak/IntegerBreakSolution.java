package leetcode.integerBreak;

/**
 * @Author: huangbingjing
 * @DATE: 2020-07-30
 */
public class IntegerBreakSolution {


    public static void main(String[] args) {
//        Solution solution = new Solution();
        int res = integerBreak(6);
        System.out.println(res);
    }




    public static int integerBreak(int n) {
        if (n==2){
            return 1;
        }

        int s = n%2;
        int half = s==0?n/2:n/2+1;
        return nextMax(2, n, half, 1);

    }


    public static int nextMax(int init, int left, int upLimit, int sum){
        if (left == 0) {
            return sum;
        }

        if (left <= init) {
            return left * sum ;
        }

        int max = 0;
        for (int i = init; i<= upLimit; i++) {
            int newLeft = left - i;
            upLimit = upLimit<newLeft?upLimit:newLeft;
            if (newLeft < 0) {
                continue;
            }
            int newSum = sum * i;
            int nextMax =  nextMax(i, newLeft, upLimit, newSum);
            max = max>nextMax? max : nextMax;
        }
        return max;
    }


}


