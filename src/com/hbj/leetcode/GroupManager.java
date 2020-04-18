//package com.hbj.leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: huangbingjing
// * @DATE: 2020-04-17
// */
//public class GroupManager {
//
//    private Map<Integer, GroupInfo> groupInfos;
//
//    private int[] memberInfos;
//
//
//    public static GroupManager init(int n){
//        int[] memberInfo = new int[n]; // 成员信息初始化
//        for (int i =0; i<n; i++) {
//            memberInfo[i]=-1;
//        }
//        GroupManager manager = new GroupManager();
//        manager.setGroupInfos(new HashMap<>(n));
//        manager.setMemberInfos(memberInfo);
//        return manager;
//    }
//
//
//    public GroupInfo getGroupInfo(int groupId){
//        return groupInfos.get(groupId);
//    }
//
//    public int getMemberInfo(int index){
//        if (index>=0 && index< memberInfos.length){
//            return memberInfos[index];
//        }
//        return -1;
//    }
//
//    public void createGroup(int index){
//        GroupInfo currentGroup = GroupInfo.init();
//        int groupId = currentGroup.getGroupId();
//        currentGroup.join(index);
//        this.groupInfos.put(groupId, currentGroup);
//        memberInfos[index] = groupId;
//    }
//
//    public void deleteIndex(int index){
//        int oriGroupId = getMemberInfo(index);
//        GroupInfo aboveGroup = getGroupInfo(oriGroupId);
//        if (aboveGroup!=null) {
//            aboveGroup.away(index);
//        }
//        memberInfos[index] = -1;
//    }
//
//    public void joinGroup(int index, GroupInfo group){
//        int oriId = group.getGroupId();
//        group.join(index);
//        memberInfos[index] = oriId;
//    }
//
//
//    public void merge(GroupInfo toGroup, GroupInfo fromGroup){
//        int groupId = toGroup.getGroupId();
//        toGroup.merge(fromGroup);
//        for (Integer index:toGroup.getMemberIndexs()) {
//            memberInfos[index] = groupId;
//        }
//        this.groupInfos.remove(fromGroup.getGroupId());
//    }
//
//    public Map<Integer, GroupInfo> getGroupInfos() {
//        return groupInfos;
//    }
//
//    public void setGroupInfos(Map<Integer, GroupInfo> groupInfos) {
//        this.groupInfos = groupInfos;
//    }
//
//    public void setMemberInfos(int[] memberInfos) {
//        this.memberInfos = memberInfos;
//    }
//}
