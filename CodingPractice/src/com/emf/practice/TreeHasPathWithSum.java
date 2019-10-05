package com.emf.practice;

public class TreeHasPathWithSum {

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(3);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(hasPathWithSum(root, 26));
    }

    private static boolean hasPathWithSum(Node node, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null) {
            return node.data == sum;
        }

        return hasPathWithSum(node.left, sum - node.data) || hasPathWithSum(node.right, sum - node.data);
    }
}
