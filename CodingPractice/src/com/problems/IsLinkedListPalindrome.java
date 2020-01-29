package com.problems;

public class IsLinkedListPalindrome {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(3);
        head.next.next.next.next.next = new LLNode(2);
        head.next.next.next.next.next.next = new LLNode(1);
        System.out.println(isLinkedListPalindrome(head, 7));

        head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(3);
        head.next.next.next.next = new LLNode(2);
        head.next.next.next.next.next = new LLNode(1);

        System.out.println(isLinkedListPalindrome(head, 6));
    }

    private static boolean isLinkedListPalindrome(LLNode head, int length) {
        LLNode newHead = reverseHalfLinkedList(head, length);

        return checkPalindrome(newHead, length);
    }

    private static LLNode reverseHalfLinkedList(LLNode head, int length) {
        if (head == null || head.next == null)
            return head;

        LLNode previous = null;
        LLNode current = head;
        LLNode next = current.next;
        for (int i = 0; i < length / 2; i++) {
            current.next = previous;

            previous = current;
            current = next;
            next = next.next;
        }
        head.next = current;

        return previous;
    }

    private static boolean checkPalindrome(LLNode head, int length) {
        LLNode slowPointer = head;
        LLNode fastPointer = getFastPointer(head, length);

        while (fastPointer != null) {
            if (slowPointer.data != fastPointer.data)
                return false;

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return true;
    }

    private static LLNode getFastPointer(LLNode head, int length) {
        int movePlaces;
        if (length % 2 == 0)
            movePlaces = length / 2;
        else
            movePlaces = length / 2 + 1;

        LLNode fastPointer = head;
        for (int i = 0; i < movePlaces; i++) {
            fastPointer = fastPointer.next;
        }
        return fastPointer;
    }
}
