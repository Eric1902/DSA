package com.emf.practice;

public class PrintTreePaths {

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(3);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        printPaths(root);
    }

    static void printPaths(Node node) {
        printPaths(node, new String());
    }

    private static void printPaths(Node node, String path) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            System.out.println(path + node.data);
        }
        printPaths(node.left, (path + node.data + "_"));
        printPaths(node.right, (path + node.data + "_"));

    }
}
