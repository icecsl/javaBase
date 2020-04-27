package com.hbj.leetcode.solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-27
 */
public class QueenResult {

    private List<Queen> queens;

    private String[][] array;

    private int nums;


    public static QueenResult init(int n){
        QueenResult po = new QueenResult();
        po.setArray(new String[n][n]);
        po.setQueens(new ArrayList<>());
        po.setNums(0);
        return po;
    }


    public QueenResult() {
    }

    public QueenResult(List<Queen> queensI, String[][] array, int n) {

        this.queens = new ArrayList<>();
        queens.addAll(queensI);
        this.array = new String[n][n];
        for (int i=0;i<n;i++){
            this.array[i] = Arrays.copyOf(array[i], array[i].length);
        }
        this.nums = nums;
    }

    public List<Queen> getQueens() {
        return queens;
    }

    public void setQueens(List<Queen> queens) {
        this.queens = queens;
    }

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
