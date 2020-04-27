package com.hbj.leetcode.solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-26
 */
public class NQueensSolution {


    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        List<QueenResult> queenResults = new ArrayList<>();
        QueenResult queenResult = QueenResult.init(n);
        begin(0,0, queenResult, n, queenResults);
        for (QueenResult result1 :queenResults){
            List<String> ss = new ArrayList<>();
            String[][] array = result1.getArray();
            for (int i=0; i<n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    s.append(array[i][j]);
                }
                ss.add(s.toString());
            }
            result.add(ss);
        }

        return result;
    }



    public static void begin(int row, int col, QueenResult queenResult, int n, List<QueenResult> queenResults){

        String[][] array = queenResult.getArray();
        List<Queen> queens = queenResult.getQueens();

        head:
        for (int i=row; i<n; i++) {

            lable:
            for (int j = 0; j < n; j++) {
                String item = array[i][j];
                if (item != null) {
                    continue;
                }

                for (Queen queen: queens) {
                    if (i == queen.getI()) {
                        array[i][j] = ".";
                        continue lable;
                    }
                    if (j == queen.getJ()) {
                        array[i][j] = ".";
                        continue lable;
                    }
                    if (Math.abs(i-queen.getI()) == Math.abs(j-queen.getJ())){
                        array[i][j] = ".";
                        continue lable;
                    }
                }
                QueenResult noQueenResult = new QueenResult(queens, array, n);
                makeQueen(i, j, queenResult, n, queenResults);
                makeNoQueen(i, j, noQueenResult,n, queenResults);
                return;
//                break head;
            }
        }
        if (queens.size() == n) {
            queenResults.add(queenResult);
        }

    }
    public static void makeQueen(int row, int col, QueenResult queenResult, int n, List<QueenResult> queenResults){
        Queen queen = new Queen(row, col);
        queenResult.getQueens().add(queen);
        String[][] array = queenResult.getArray();
        array[row][col] = "Q";
        begin(row, col, queenResult, n, queenResults);
    }

    public static void makeNoQueen(int row, int col, QueenResult queenResult, int n, List<QueenResult> queenResults){
        String[][] array = queenResult.getArray();
        array[row][col] = ".";
        begin(row, col, queenResult, n, queenResults);
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }





}
