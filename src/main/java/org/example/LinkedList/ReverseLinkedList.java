package org.example.LinkedList;

public class ReverseLinkedList {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // ===== SOLUTION =====
    static class Solution {

        Node boss = null; // (not required but kept since it was in your code)

        Node reverseList(Node head) {

            Node temp2 = null;
            Node temp1 = null;

            while (head != null) {
                temp2 = head.next;
                head.next = temp1;
                temp1 = head;
                head = temp2;
            }

            return temp1;
        }
    }

    // ===== HELPER: CREATE LIST =====
    static Node createList(int arr[]) {

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // ===== HELPER: PRINT LIST =====
    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Solution sol = new Solution();

        int arr[] = {1, 2, 3, 4, 5};

        Node head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        head = sol.reverseList(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}
