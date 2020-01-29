package com.problems;

public class LCA {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);

        root.left.right.left.right = new Node(11);

        System.out.println(lca(root, 3, 7).data);
    }

    private static Node lca(Node root, int node1, int node2) {

        if (root == null)
            return null;

        if (root.data == node1 || root.data == node2)
            return root;

        Node left = lca(root.left, node1, node2);
        Node right = lca(root.right, node1, node2);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
