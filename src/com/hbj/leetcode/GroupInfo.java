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
    private int memberNums;

    public GroupInfo(int memberNums) {
        this.memberNums = memberNums;
    }

    public void add(int nums){
        this.memberNums = memberNums + nums;
    }

    public Integer getMemberNums() {
        return memberNums;
    }
}
