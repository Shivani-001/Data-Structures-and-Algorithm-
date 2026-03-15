package org.example.LinkedList;

import java.util.*;

public class CloneLinkedListRandomPointer {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }

    // ===== SOLUTION =====
    static class Solution {

        public Node cloneLinkedList(Node head) {

            if (head == null) return null;

            HashMap<Node, Node> h = new HashMap<>();

            Node curr = head;

            // create cloned nodes
            while (curr != null) {
                h.put(curr, new Node(curr.data));
                curr = curr.next;
            }

            curr = head;

            // connect next and random pointers
            while (curr != null) {

                Node cloneNode = h.get(curr);

                cloneNode.next = h.get(curr.next);
                cloneNode.random = h.get(curr.random);

                curr = curr.next;
            }

            return h.get(head);
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

    // ===== HELPER: PRINT LIST WITH RANDOM POINTER =====
    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {

            int randomVal = (curr.random != null) ? curr.random.data : -1;

            System.out.println(
                    "Node: " + curr.data +
                            " | Next: " + (curr.next != null ? curr.next.data : "null") +
                            " | Random: " + randomVal
            );

            curr = curr.next;
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Solution sol = new Solution();

        // Create list
        Node head = createList(new int[]{1,2,3,4});

        // Assign random pointers manually
        head.random = head.next.next;       // 1 -> 3
        head.next.random = head;            // 2 -> 1
        head.next.next.random = head.next.next.next; // 3 -> 4
        head.next.next.next.random = head.next; // 4 -> 2

        System.out.println("Original List:");
        printList(head);

        Node clonedHead = sol.cloneLinkedList(head);

        System.out.println("\nCloned List:");
        printList(clonedHead);
    }
}