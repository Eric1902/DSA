package com.emf.practice;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);
        head.next.next.next.next.next = new LLNode(6);

        LLNode newHead = reverseLinkedList(head);
        System.out.println(newHead);
    }

    private static LLNode reverseLinkedList(LLNode head) {
        if (head == null || head.next == null)
            return head;

        LLNode previous = null;
        LLNode current = head;
        LLNode next = current.next;

        while (next != null) {
            current.next = previous;

            previous = current;
            current = next;
            next = next.next;

            System.out.println();
        }
        current.next = previous;

        return current;
    }
}

class LLNode {
    int data;
    LLNode next;

    LLNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LLNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

