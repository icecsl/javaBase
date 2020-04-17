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
     * 参团位置个数, 当个数为0时候，要清零
     */
    private Integer memberIndexNums;


    private Set<Integer> memberIndexs;

    private int groupId;


    public static GroupInfo init(int index){
        GroupInfo p = new GroupInfo();
        p.setMemberNums(1);
        p.memberIndexs = new TreeSet<>();
        p.memberIndexs.add(index);
        p.setGroupId(index);
        return p;
    }


    public boolean join(int index){
        memberIndexs.add(index);
        this.setMemberNums(memberNums+1);
        int min = index < groupId?index:groupId;
        if (min != groupId) {
            this.setGroupId(min);
            return true;
        }
        return false;
    }

    public boolean deleteIndex(int index){
        memberIndexs.remove(index);
        if (index == groupId) {
            List <Integer> lst = new ArrayList<>(memberIndexs);
            if(lst!=null && !lst.isEmpty()) {
                this.setGroupId(lst.get(0));
            }
            return true;
        }
        return false;
    }

    public boolean merge(GroupInfo groupInfo){
        this.setMemberNums(memberNums+groupInfo.getMemberNums());
        memberIndexs.addAll(groupInfo.getMemberIndexs());

        List <Integer> lst = new ArrayList<>(memberIndexs);
        int newId =lst.get(0);
        if (newId!=groupId){
            this.setGroupId(newId);
            return true;
        }
        return false;
    }

    private void disjustId(){

    }

    public Integer getMemberNums() {
        return memberNums;
    }

    public void setMemberNums(Integer memberNums) {
        this.memberNums = memberNums;
    }

    public Integer getMemberIndexNums() {
        return memberIndexNums;
    }

    public void setMemberIndexNums(Integer memberIndexNums) {
        this.memberIndexNums = memberIndexNums;
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
