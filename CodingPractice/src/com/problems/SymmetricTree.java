package com.problems;

public class SymmetricTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));

    }

    private static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return left.data == right.data && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
