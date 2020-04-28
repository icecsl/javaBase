package com.hbj.leetcode.solveNQueens.perfect;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-27
 */
public class Queen {
    private Integer i;
    private Integer j;

    public Queen(Integer i, Integer j) {
        this.i = i;
        this.j = j;
    }

    public Queen(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }
}
