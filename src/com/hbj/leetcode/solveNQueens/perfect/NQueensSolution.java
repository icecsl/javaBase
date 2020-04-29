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
        Map<Integer, String> resultMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            resultMap.put(i, getStrResult(n, i));
        }
        List<Queen> queens = new ArrayList<>(n);
        begin(0, n, queens,resultMap,result);
        System.out.println(result);
        return result;
    }

    public static void begin(int row, int n, List<Queen> queens,  Map<Integer, String> resultMap, List<List<String>> queenResult) {
        begin:
        for (int i=row; i<n; i++) {
            lable:
            for (int j = 0; j < n; j++) {
                for (Queen queen: queens) {
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
                newQueens.add(queenI);
                begin(i+1, n, newQueens, resultMap, queenResult);
            }
            return;
        }

        List<String> s = new ArrayList<>();
        for (Queen queen :queens) {
            s.add(resultMap.get(queen.getJ()));
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
