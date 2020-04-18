package com.hbj.leetcode;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-17
 */
public class Solution {

    public static void main(String[] args) {

                int[][] ori = {
                {1,1,0,0,1,1,1,0,0},
                {1,1,0,0,1,0,1,0,1},
                {0,0,1,0,0,0,1,0,1},
                {1,0,0,0,0,0,0,1,0},
                {1,0,1,0,1,1,0,1,0},
                {0,0,0,1,0,0,1,0,1},
                {0,0,0,1,0,1,0,1,0},
                {1,0,0,1,0,1,0,0,1},
                {0,1,0,0,0,0,0,1,0}};

//        int[][] grid = {{1}};
          int[][] grid = {
                  {1,1,0,0,1},
                  {1,1,0,0,1},
                  {0,0,1,0,0},
                  {1,0,0,1,1},
                  {1,0,0,1,1}};

        int n = grid[0].length;
        GroupManager manager = GroupManager.init(n);
        int max = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<n; j++) {
                int item = grid[i][j]; // 当前数
                int leftMember = manager.getMemberInfo(j-1);  // 左边成员信息
                int aboveMember =  manager.getMemberInfo(j);  // 当前成员原始信息

                if (item == 0){
                    // 去掉参团位置数，不能去掉员工数
                    if (aboveMember != -1) {
                        manager.deleteIndex(j);
                    }
                }else {
                    // 参团，加入位子且增加员工数
                    if (leftMember !=-1) {
                        // 左边成员有组信息
                        if (aboveMember != -1){
                            // 左边和上边相同组, 合并, 人数+1
                            if (aboveMember == leftMember) {
                                GroupInfo group = manager.getGroupInfo(leftMember);
                                manager.joinGroup(j, group);
                            }else {
                                // 不相同, 上边组加入左边组，加入该团
                                GroupInfo aboveGroup =  manager.getGroupInfo(aboveMember);
                                GroupInfo leftGroup =  manager.getGroupInfo(leftMember);
                                manager.joinGroup(j, leftGroup);
                                manager.merge(leftGroup, aboveGroup);
                            }
                        }else {
                            // 单纯加入
                            GroupInfo group = manager.getGroupInfo(leftMember);
                            manager.joinGroup(j, group);
                        }
                    }else {
                        if (aboveMember != -1){
                            // 单纯加入
                            GroupInfo group = manager.getGroupInfo(aboveMember);
                            manager.joinGroup(j, group);
                        }else {
                            // 初始化
                            manager.createGroup(j);
                        }
                    }
                }
            }
        }

        for (GroupInfo leftInfo :manager.getGroupInfos().values()){
            if (leftInfo !=null){
                int memberNums = leftInfo.getMemberNums();
                max = memberNums > max?memberNums:max;
            }
        }
        System.out.println("max================="+max);

    }
}
