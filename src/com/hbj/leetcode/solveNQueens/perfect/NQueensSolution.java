package com.hbj.leetcode.solveNQueens.perfect;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-26
 */
public class NQueensSolution {


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<Queen> queens = new ArrayList<>(n);
        begin(0,0, n, queens,result);
        System.out.println(result);
        return result;
    }

    public static void begin(int row, int col, int n, List<Queen> queens,  List<List<String>> queenResult) {
        begin:
        for (int i=row; i<n; i++) {
            lable:
            for (int j = 0; j < n; j++) {

                if (i == row && j< col) {
                    continue;
                }
                for (Queen queen: queens) {
                    if (i == queen.getI()) {
                        continue begin;
                    }
                    if (j == queen.getJ()) {
                        continue lable;
                    }
                    if (Math.abs(i-queen.getI()) == Math.abs(j-queen.getJ())){
                        continue lable;
                    }
                }
                List<Queen> newQueens = new ArrayList<>();
                newQueens.addAll(queens);
                Queen queenI = new Queen(i,j);
                queens.add(queenI);
                begin(i+1,0, n, queens, queenResult);
                if (j!=n){
                    begin(i,j+1, n, newQueens, queenResult);
                }
                return;
            }
            return;
        }

        List<String> s = new ArrayList<>();
        for (Queen queen :queens) {
            s.add(getStrResult(n, queen.getJ()));
        }
        queenResult.add(s);
    }

    public static String getStrResult(int n, int j){
        StringBuilder s = new StringBuilder();
        for (int i=0;i<n;i++){
            if (i==j){
                s.append("Q");
                continue;
            }
            s.append(".");
        }
        return s.toString();
    }




    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        solveNQueens(4);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }





}
