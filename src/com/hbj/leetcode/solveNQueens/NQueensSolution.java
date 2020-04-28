package com.hbj.leetcode.solveNQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-26
 */
public class NQueensSolution {


    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        QueenResult queenResult = QueenResult.init(n);
        begin(0,0, queenResult, n, result);
        System.out.println(result);
        return result;
    }



    public static void begin(int row, int col, QueenResult queenResult, int n, List<List<String>> queenResults){

        String[][] array = queenResult.getArray();
        List<Queen> queens = queenResult.getQueens();
        List<String> stringResult = queenResult.getResult();

        head:
        for (int i=row; i<n; i++) {
            int queensize = 0;

            StringBuilder s = new StringBuilder();
            lable:
            for (int j = 0; j < n; j++) {

                String item = array[i][j];
                if (item != null) {
                    if ("Q".equals(item)){
                        queensize = 1;
                    }
                    s.append(item);
                    continue;
                }
                for (Queen queen: queens) {
                    if (i == queen.getI()) {
                        array[i][j] = ".";
                        s.append(".");
                        continue lable;
                    }
                    if (j == queen.getJ()) {
                        array[i][j] = ".";
                        s.append(".");
                        continue lable;
                    }
                    if (Math.abs(i-queen.getI()) == Math.abs(j-queen.getJ())){
                        array[i][j] = ".";
                        s.append(".");
                        continue lable;
                    }
                }
                QueenResult noQueenResult = new QueenResult(queens, array, stringResult, n);
                makeQueen(i, j, queenResult, n, queenResults);
                makeNoQueen(i, j, noQueenResult,n, queenResults);
                return;
//                break head;

            }

            if (queensize != 1) {
                return;
            }
            stringResult.add(s.toString());
        }

        if (queens.size() == n) {
            queenResults.add(stringResult);
        }

    }
    public static void makeQueen(int row, int col, QueenResult queenResult, int n, List<List<String>> queenResults){
        Queen queen = new Queen(row, col);
        queenResult.getQueens().add(queen);
        String[][] array = queenResult.getArray();
        array[row][col] = "Q";
        begin(row, col, queenResult, n, queenResults);
    }

    public static void makeNoQueen(int row, int col, QueenResult queenResult, int n, List<List<String>> queenResults){
        String[][] array = queenResult.getArray();
        array[row][col] = ".";
        begin(row, col, queenResult, n, queenResults);
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        solveNQueens(4);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }





}
