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
        begin(0,0, new String[n][n], new ArrayList<>(), new ArrayList<>(), n, result);
        System.out.println(result);
        return result;
    }



    public static void begin(int row, int col, String[][] array, List<Queen> queens, List<String> stringResult, int n, List<List<String>> queenResults){

        for (int i=row; i<n; i++) {
            StringBuilder s = new StringBuilder();
            lable:
            for (int j = 0; j < n; j++) {

                String item = array[i][j];
                if (item != null) {
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
                List<Queen> newQueens = new ArrayList<>();
                newQueens.addAll(queens);
                String[][] newArray =  new String[n][n];
                for (int k=0;k<n;k++){
                    newArray[k] = Arrays.copyOf(array[k], array[k].length);
                }
                List<String> newStrResult = new ArrayList<>();
                newStrResult.addAll(stringResult);

                makeQueen(i, j, array, queens, stringResult, n, queenResults);
                makeNoQueen(i, j, newArray, newQueens, newStrResult, n, queenResults);
                return;
            }
            stringResult.add(s.toString());
        }

        if (queens.size() == n) {
            queenResults.add(stringResult);
        }

    }
    public static void makeQueen(int row, int col, String[][] array, List<Queen> queens, List<String> stringResult, int n, List<List<String>> queenResults){
        Queen queen = new Queen(row, col);
        queens.add(queen);
        array[row][col] = "Q";
        begin(row, col, array,queens, stringResult , n, queenResults);
    }

    public static void makeNoQueen(int row, int col, String[][] array, List<Queen> queens, List<String> stringResult, int n, List<List<String>> queenResults){
        array[row][col] = ".";
        begin(row, col, array,queens, stringResult , n, queenResults);
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        solveNQueens(8);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }





}
