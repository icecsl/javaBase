package leetcode.solveNQueens.perfect;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-27
 */
public class Queen {
    private int i;
    private int j;

    public Queen(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Queen(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
