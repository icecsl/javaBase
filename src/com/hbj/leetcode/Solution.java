package com.hbj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-17
 */
public class Solution {

    public static void main(String[] args) {

        int[][] grid = {
        {1,1,0,0,1,1,1,0,0},
        {1,1,0,0,1,0,1,0,1},
        {0,0,1,0,0,0,1,1,1},
        {1,0,0,0,0,0,0,1,0},
        {1,0,1,0,1,1,0,1,0},
        {0,0,0,1,0,0,1,0,1},
        {0,0,0,1,0,1,0,1,0},
        {1,0,0,1,0,1,0,0,1},
        {0,1,0,0,0,0,0,1,0}};

//        int[][] grid = {{1}};
//          int[][] grid = {
//                  {1,1,0,0,1},
//                  {1,1,0,0,1},
//                  {0,0,1,0,0},
//                  {1,0,0,1,1},
//                  {1,0,0,1,1}};

        int n = grid[0].length;
        Map<Integer, GroupInfo> groupInfos = new HashMap<>(n);

        int max = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<n; j++) {
                int item = grid[i][j]; // 当前数
                int leftMember = j==0 ? 0:grid[i][j-1];  // 左边成员信息
                int aboveMember = i==0? 0: grid[i-1][j];  // 当前成员原始信息

                if (item == 1){
                    GroupInfo leftGroup = leftMember != 0? groupInfos.get(leftMember) : null;
                    GroupInfo aboveGroup = aboveMember != 0? groupInfos.get(aboveMember) : null;
                    if (leftGroup != null) {
                        leftGroup.join(j);
                        grid[i][j] = leftMember;
                        if (aboveGroup != null) {
                            if (leftGroup != aboveGroup){
                                leftGroup.merge(aboveGroup);
                            }
                        }
                    }else {
                        if (aboveGroup != null) {
                            aboveGroup.join(j);
                            grid[i][j] = aboveMember;
                        }else {
                            GroupInfo currentGroup = new GroupInfo(1);
                            int groupId = IdGenerator.getId();
                            groupInfos.put(groupId, currentGroup);
                            grid[i][j] = groupId;
                        }
                    }
                }
            }
        }

        for (GroupInfo groupInfo :groupInfos.values()){
            if (groupInfo !=null){
                int memberNums = groupInfo.getMemberNums();
                max = memberNums > max?memberNums:max;
            }
        }
        System.out.println("max================="+max);

    }
}
