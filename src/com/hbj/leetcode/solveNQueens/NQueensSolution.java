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

        System.out.println(queenResults);
        return null;
    }



    public static void begin(int row, int col, QueenResult queenResult, int n, List<QueenResult> queenResults){

        Integer[][] array = queenResult.getArray();
        List<Queen> queens = queenResult.getQueens();

        head:
        for (int i=row; i<n; i++) {

            lable:
            for (int j = 0; j < n; j++) {
                Integer item = array[i][j];
                if (item != null) {
                    continue;
                }

                for (Queen queen: queens) {
                    if (i == queen.getI()) {
                        array[i][j] = 0;
                        continue lable;
                    }
                    if (j == queen.getJ()) {
                        array[i][j] = 0;
                        continue lable;
                    }
                    if (Math.abs(i-queen.getI()) == Math.abs(j-queen.getJ())){
                        array[i][j] = 0;
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
        Integer[][] array = queenResult.getArray();
        array[row][col] = 1;
        begin(row, col, queenResult, n, queenResults);
    }

//    private void makeQueen(int row, int col, List<Queen> queens, Integer[][] array, int n){
//        Queen queen = new Queen(row, col);
//        queens.add(queen);
//        array[row][col] = 1;
//        begin(row, col, array, n, queens);
//    }

    public static void makeNoQueen(int row, int col, QueenResult queenResult, int n, List<QueenResult> queenResults){
        Integer[][] array = queenResult.getArray();
        array[row][col] = 0;
        begin(row, col, queenResult, n, queenResults);
    }



    public static void main(String[] args) {

        solveNQueens(5);

//        Integer[][] array = new Integer[9][9];
//        array[0][0] = 1;
//
//        Integer[][] array2 = new Integer[9][9];
//        for (int i=0;i<9;i++){
//            array2[i] = Arrays.copyOf(array[i], array[i].length);
//        }
//        array[0][1] = 1;
//        System.out.println(array);
//        System.out.println(array2);
    }





}
