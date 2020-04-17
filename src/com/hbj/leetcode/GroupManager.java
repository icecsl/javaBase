package com.hbj.leetcode;

/**
 * @Author: huangbingjing
 * @DATE: 2020-04-17
 */
public class GroupManager {

    private GroupInfo[] groupInfos;

    private int[] memberInfos;

    public static GroupManager init(int n){
        GroupInfo[] groupInfos = new GroupInfo[n];
        int[] memberInfo = new int[n]; // 成员信息初始化
        for (int i =0; i<n; i++) {
            memberInfo[i]=-1;
        }
        GroupManager manager = new GroupManager();
        manager.setGroupInfos(groupInfos);
        manager.setMemberInfos(memberInfo);
        return manager;
    }


    public GroupInfo getGroupInfo(int index){
        if (index>=0 && index<groupInfos.length){
            return groupInfos[index];
        }
        return null;
    }

    public int getMemberInfo(int index){
        if (index>=0 && index< memberInfos.length){
            return memberInfos[index];
        }
        return -1;
    }

    public void createGroup(int groupId){
        GroupInfo currentGroup = GroupInfo.init(groupId);
        this.groupInfos[groupId] = currentGroup;
        memberInfos[groupId] = groupId;
    }

    public int deleteIndex(int index, int aboveMember){
        int deleteMemberNums = 0;
        GroupInfo aboveGroup = getGroupInfo(aboveMember);
        if (aboveGroup!=null) {
            int oriId = aboveGroup.getGroupId();
            aboveGroup.deleteIndex(index);
            if (aboveGroup.getMemberIndexs() == null || aboveGroup.getMemberIndexs().isEmpty()) {
                // 清空
                this.groupInfos[aboveMember] = null;
                deleteMemberNums = aboveGroup.getMemberNums();
            }
            adjust(oriId, aboveGroup);
        }
        memberInfos[index] = -1;
        return deleteMemberNums;
    }

    public void joinGroup(int index, GroupInfo group){
        int oriId = group.getGroupId();
        group.join(index);
        adjust(oriId, group);
        memberInfos[index] = group.getGroupId();
    }


    public void merge(GroupInfo toGroup, GroupInfo fromGroup){
        int oriId = toGroup.getGroupId();
        toGroup.merge(fromGroup);
        for (Integer aboveIndex:toGroup.getMemberIndexs()) {
            memberInfos[aboveIndex] = toGroup.getGroupId();
        }

        int newId = toGroup.getGroupId();
        this.groupInfos[oriId] = null;
        this.groupInfos[newId] = toGroup;
        this.groupInfos[fromGroup.getGroupId()] = toGroup;
    }




    private void adjust(int oriId, GroupInfo newGroup){
        int newId = newGroup.getGroupId();
        if (newId != oriId) {
            for (int memberIndex : newGroup.getMemberIndexs()) {
                memberInfos[memberIndex] = newId;
            }
            this.groupInfos[oriId] = null;
            this.groupInfos[newId] = newGroup;
        }
    }


    public GroupInfo[] getGroupInfos() {
        return groupInfos;
    }

    public void setGroupInfos(GroupInfo[] groupInfos) {
        this.groupInfos = groupInfos;
    }

    public int[] getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(int[] memberInfos) {
        this.memberInfos = memberInfos;
    }
}
