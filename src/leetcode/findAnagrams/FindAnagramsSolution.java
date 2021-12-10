package leetcode.findAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huangbingjing
 * @DATE: 11/28/21
 */
public class FindAnagramsSolution {

    public static void main(String[] args) {
        FindAnagramsSolution solution = new FindAnagramsSolution();

        String s1 = "abab";
        String s2 = "ab";
        List<Integer> list = solution.findAnagrams(s1, s2);
        System.out.println(list);
    }


    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCharMap = new HashMap<>();
        for (char pchar: p.toCharArray()) {
            addOne(pCharMap, pchar);
        }

        Map<Character, Integer> sCharMap = new HashMap<>();
        char[] scharArr = s.toCharArray();
        int index= 0;
        List<Integer> list = new ArrayList<>();
        for (char schar : scharArr) {
            addOne(sCharMap, schar);
            if (index < p.length()-1) {
                index++;
                continue;
            }

            boolean result = checkCharArray(sCharMap, pCharMap);
            if (result) {
                list.add(index-p.length()+1);
            }

            char begin = scharArr[index-p.length()+1];
            removeOne(sCharMap, begin);
            index++;
        }
        return list;
    }

    private void addOne(Map<Character, Integer> map, char key){
        Integer count = map.get(key);
        if (count == null) {
            count = 0;
        }
        count++;
        map.put(key, count);
    }

    private void removeOne(Map<Character, Integer> map, char key){

        Integer count = map.get(key);
        count--;
        if (count == 0) {
            map.remove(key);
        }else {
            map.put(key, count);
        }
    }


    /**
     * 比较两个数据是否一致
     * @param cmMap 比较值
     * @param baseMap 基准值
     * @return
     */
    private boolean checkCharArray(Map<Character, Integer> cmMap, Map<Character, Integer> baseMap){
        if (cmMap.size() != baseMap.size()){
            return false;
        }

        for (Map.Entry<Character, Integer> entry :baseMap.entrySet()) {
            Integer baseValue = entry.getValue();
            Integer cmValue = cmMap.get(entry.getKey());
            if (!baseValue.equals(cmValue)) {
                return false;
            }
        }
        return true;
    }



}
