package com.hbj.leetcode;

import java.util.*;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-17
 */
public class GroupInfo {

    /**
     * 成员个数
     */
    private Integer memberNums;

    public GroupInfo(Integer memberNums) {
        this.memberNums = memberNums;
    }

    public void join(int index){
        this.setMemberNums(memberNums+1);
    }


    public void merge(GroupInfo groupInfo){
        this.setMemberNums(memberNums+groupInfo.getMemberNums());
    }


    public Integer getMemberNums() {
        return memberNums;
    }

    public void setMemberNums(Integer memberNums) {
        this.memberNums = memberNums;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, new Integer(1));
        map.put(2, new Integer(1));

        System.out.println( map.get(1) == map.get(2));

        map.put(2, map.get(1));

        System.out.println( map.get(1) == map.get(2));
    }

}
