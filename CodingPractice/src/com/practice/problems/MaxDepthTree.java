package com.practice.problems;

public class MaxDepthTree {
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(3);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left.left = new Node(99);
        root.right.right.right = new Node(999);
        root.right.right.right.right = new Node(9999);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;

        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
