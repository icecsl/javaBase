package com.hbj.leetcode.solveNQueens.perfect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-26
 */
public class NQueensSolution {


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<Map<Integer, Integer>> queens = new ArrayList<>();
        begin(0,0, n, queens,result);
        System.out.println(result);
        return result;
    }

    public static void begin(int row, int col, int n, List<Map<Integer, Integer>> queens,  List<List<String>> queenResult) {
        begin:
        for (int i=row; i<n; i++) {

            Map<Integer, Integer> queenI = new HashMap<>();
            queenI.put(0, i);
            lable:
            for (int j = 0; j < n; j++) {

                if (i == row && j< col) {
                    continue;
                }
                for (Map<Integer, Integer> queen: queens) {
                    int qI = queen.get(0);
                    int qJ = queen.get(1);

                    if (i == qI) {
                        continue begin;
                    }
                    if (j == qJ) {
                        continue lable;
                    }
                    if (Math.abs(i-qI) == Math.abs(j-qJ)){
                        continue lable;
                    }
                }
                List<Map<Integer, Integer>> newQueens = new ArrayList<>();
                newQueens.addAll(queens);

                queenI.put(1,j);
                queens.add(queenI);
                begin(i+1,0, n, queens, queenResult);
                begin(i,j+1, n, newQueens, queenResult);
                return;
            }
            if (queenI.get(1) == null){
                return;
            }
        }

        List<String> s = new ArrayList<>();
        for (Map<Integer, Integer> queen :queens) {
            s.add(getStrResult(n, queen.get(1)));
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
