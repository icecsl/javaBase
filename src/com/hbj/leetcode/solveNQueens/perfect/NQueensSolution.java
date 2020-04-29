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

        List<Integer> cows = new ArrayList<>(n);
        List<Integer> cols = new ArrayList<>(n);
        List<Queen> queens = new ArrayList<>(n);
        begin(0,0, n, cows, cols,   queens,result);
        System.out.println(result);
        return result;
    }

    public static void begin(int row, int col, int n, List<Integer> cows, List<Integer> cols, List<Queen> queens, List<List<String>> queenResult) {
        begin:
        for (int i=row; i<n; i++) {

            lable:
            for (int j = 0; j < n; j++) {

                if (i == row && j< col) {
                    continue;
                }
                if (cows.contains(i)){
                    continue begin;
                }
                if (cols.contains(j)){
                    continue;
                }
                for (Queen queen: queens) {
                    if (Math.abs(i-queen.getI()) == Math.abs(j-queen.getJ())){
                        continue lable;
                    }

                }
//                if (lastQueen !=null){
//                    if (i == lastQueen.getI()+1 && j==lastQueen.getJ()-1){
//                        continue ;
//                    }
//                    if (i == lastQueen.getI()+1 && j==lastQueen.getJ()+1){
//                        continue ;
//                    }
//                }

                List<Queen> newQueens = new ArrayList<>();
                newQueens.addAll(queens);
                List<Integer> newRows = new ArrayList<>();
                newRows.addAll(cows);
                List<Integer> newCols = new ArrayList<>();
                newCols.addAll(cols);

//                Queen queenI = new Queen(i,j);
//                queens.add(queenI);
//                begin(i+1,0, n, queens, queenResult);
                makeQeen(i, j, n, cows, cols, queens, queenResult);

                begin(i,j+1, n,  newRows, newCols, newQueens, queenResult);
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

    public static void makeQeen(int row, int col, int n, List<Integer> cows, List<Integer> cols, List<Queen> queens, List<List<String>> queenResult) {
        Queen queenI = new Queen(row,col);
        queens.add(queenI);
        cows.add(row);
        cols.add(col);
        begin(row+1, 0, n, cows, cols, queens, queenResult);
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
