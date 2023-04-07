package com.naveen.problems.trees;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem297_SerializeAndDeserializeBinaryTree {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.toString();
        }

        private void preOrder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("X,");
                return;
            }
            sb.append(root.val).append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] tokens = data.split(",");
            LinkedList<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(tokens));
            return buildTree(q);
        }

        private TreeNode buildTree(LinkedList<String> q) {
            if (q.isEmpty()) return null;
            String curVal = q.poll();
            if ("X".equals(curVal)) return null;
            TreeNode cur = new TreeNode(Integer.valueOf(curVal));
            cur.left = buildTree(q);
            cur.right = buildTree(q);
            return cur;
        }
    }
}
