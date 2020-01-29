package com.problems;

public class CountUniversalTrees {
    private static int result = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);

        root.left.left = new Node(1);
        root.left.right = new Node(1);

        root.right.left = new Node(1);
        //root.right.right = new Node(2);

        countUniversalTrees(root);
        System.out.println(result);
    }

    private static int countUniversalTrees(Node root) {
        if (root == null)
            return 0;

        int left = countUniversalTrees(root.left);
        int right = countUniversalTrees(root.right);

        //Node with left=null and right=null
        if (left == 0 && right == 0) {
            result++;
            return root.data;
        }
        //Node with right=null and node.data=node.left.data
        if (left == root.data && right == 0) {
            result++;
            return root.data;
        }
        //Node with left=null and node.data=node.right.data
        if (left == 0 && right == root.data) {
            result++;
            return root.data;
        }
        //Node with node.data=node.left.data and node.data=node.right.data
        if (left == root.data && right == root.data) {
            result++;
            return root.data;
        }

        return -1;
    }
}
