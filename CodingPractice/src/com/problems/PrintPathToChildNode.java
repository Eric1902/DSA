package com.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintPathToChildNode {
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printPathToNode(root, 5);
    }

    private static void printPathToNode(Node root, int nodeData) {
        if(root==null)
            return;

        path.add(root.data);
        if(root.data==nodeData) {
            System.out.println(path);
            return;
        }

        printPathToNode(root.left, nodeData);
        printPathToNode(root.right, nodeData);

        path.remove(path.size()-1);
    }
}
