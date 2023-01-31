package leetcode.findNthDigit;


/**
 * https://leetcode-cn.com/problems/nth-digit/
 * @Author: huangbingjing
 * @DATE: 12/26/21
 */
public class FindNthDigitSolution {

    public static void main(String[] args) {
        FindNthDigitSolution solution = new FindNthDigitSolution();
        int n = 2147483647;
        int result = solution.findNthDigit(n);
        System.out.println(result);
    }


    public int findNthDigit(int n) {
        int p = 1;
        long count = 9;
        if (n<=9) {
            return n;
        }

        n = n - 9;
        while (true) {
            p++;
            count = count*10;

            if (n == p*count) {
                return 9;
            }
            if (n < p*count ) {
                int divisor = n/p; // 商
                int remainder = n%p; // 余数

                // 这里其投机了，正确应该是 int current = divisor==0? temp:remainder ==0?divisor-1+temp: divisor+temp;
                int temp = (int)count/9;
                int current = divisor==0? temp :remainder ==0?divisor-1: divisor+temp;
                if (remainder == 0) {
                    return current%10;
                } else {
                    return getN(current, p-remainder);
                }
            }else {
                long t = p*count;
                n = n-(int)t;
            }
        }
    }

    /**
     * 给定一个数n，算出第p位上数字是几, 从后往前数
     * @return
     */
    private int getN(int n, int p){
        if (p!=0) {
            for (int i =0; i<p; i++) {
                n = n/10;
            }
        }
        return n%10;
    }
}

/**
 * 分析思路
 * 0, 1,2,3,4,5,6,7,8,9		-1, 9
 *
 * 10,11,12,13,14,15,16,17,18,19, 	-2, 90
 * 20,21,22,23,24,25,26,27,28,29
 * ...
 * 90,91,92,93,94,95,96,97,98,99,
 *
 * 100, 101, 102,103,104,105,106,107.108,109. 	-3, 900
 * ...
 * 990, 991, 992,993,994,995,996,997.998,999.
 *
 * 1000, 1001, 1002,1003,1004,1005,1006,1007.1008,1009.		-4, 9000
 * 1010, 1011, 1012,1013,1014,1015,1016,1017.1018,1019,
 *
 * 1. 先找到该数字是几位数的 p
 * 2. 超出的部分除以位数就轻松找到当前数
 * eg 101 = 9+92 (说明是2位数) = 2*46 (说明是第46个， 从10开始第46位就是， 55)
 *
 */
