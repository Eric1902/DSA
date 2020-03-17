package com.practice.problems;

public class PrintAllPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printPaths(root);
    }

    private static void printPaths(Node root) {
        String path = "";
        printPaths(root, path);
    }

    private static void printPaths(Node root, String path) {
        path += root.data;
        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            if (root.left != null)
                printPaths(root.left, path);
            if (root.right != null)
                printPaths(root.right, path);
        }

    }
}
