package com.emf.practice;

public class IsSubTreesSumEqualsNodeData {

    public static void main(String[] args) {
        Node root = new Node(24);
        root.left = new Node(3);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(isSumTree(root));
    }

    private static boolean isSumTree(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        int sumL = getSumSubTree(node.left);
        int sumR = getSumSubTree(node.right);
        int sumSubTree = sumL + sumR;

        boolean isLeft = isSumTree(node.left);
        boolean isRight = isSumTree(node.right);

        return node.data == sumSubTree && isLeft && isRight;
    }

    private static int getSumSubTree(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;

        return (node.left.data + node.right.data) + getSumSubTree(node.left) + getSumSubTree(node.right);
    }
}
