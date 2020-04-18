package com.hbj.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-17
 */
public class GroupInfo {

    /**
     * 成员个数
     */
    private Integer memberNums;

    /**
     * 参团位置, 当个数为0时候，要清零
     */
    private Set<Integer> memberIndexs;

    private int groupId;

    public static GroupInfo init(){
        GroupInfo p = new GroupInfo();
        p.setMemberNums(0);
        p.memberIndexs = new TreeSet<>();
        p.setGroupId(IdGenerator.getId());
        return p;
    }

    public void join(int index){
        memberIndexs.add(index);
        this.setMemberNums(memberNums+1);
    }

    public void away(int index){
        memberIndexs.remove(index);
    }

    public void merge(GroupInfo groupInfo){
        this.setMemberNums(memberNums+groupInfo.getMemberNums());
        memberIndexs.addAll(groupInfo.getMemberIndexs());
    }


    public Integer getMemberNums() {
        return memberNums;
    }

    public void setMemberNums(Integer memberNums) {
        this.memberNums = memberNums;
    }

    public Set<Integer> getMemberIndexs() {
        return memberIndexs;
    }

    public void setMemberIndexs(Set<Integer> memberIndexs) {
        this.memberIndexs = memberIndexs;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
