package leetcode.largestValues;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 12/25/21
 */
public class LargestValuesSolution {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9);

        TreeNode t353 = new TreeNode(3, t5, t3);
        TreeNode t2_9 = new TreeNode(2, null, t9);
        TreeNode t132 = new TreeNode(1, t353, t2_9);

        TreeNode t123 = new TreeNode(1, t2, t3);

        TreeNode t1_2 = new TreeNode(1, null, t2);


        LargestValuesSolution solution = new LargestValuesSolution();
        List<Integer> result = solution.largestValues(t132);
//        List<Integer> result = solution.largestValues(t123);
//        List<Integer> result = solution.largestValues(t1);
//        List<Integer> result = solution.largestValues(t1_2);
        System.out.println(result);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        values.add(root.val);
        if (root.left == null && root.right == null) {
            return values;
        }

        TreeNode[] treeArr = new TreeNode[]{root.left, root.right};
        return getLargestValue(treeArr, values);
    }

    private List<Integer> getLargestValue(TreeNode[] treeArr, List<Integer> values) {
        TreeNode[] nextArr = new TreeNode[treeArr.length * 2];
        Integer max = null;
        boolean hasNextNode = false;
        for (int i = 0; i<treeArr.length; i++) {
            TreeNode node = treeArr[i];
            if (node != null) {
                if (max == null) {
                    max = node.val;
                }else {
                    if (node.val > max) {
                        max = node.val;
                    }
                }

                if (!hasNextNode && (node.left != null || node.right != null)){
                    hasNextNode = true;
                }
                nextArr[2*i] = node.left;
                nextArr[2*i+1] = node.right;
            }
        }
        values.add(max);

        if (hasNextNode) {
            return getLargestValue(nextArr, values);
        } else {
            return values;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}

