package org.example.LinkedList;
import java.util.*;

public class SwapKthNodeLinkedList {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // ===== SOLUTION =====
    static class Solution {

        public Node swapKthNode(Node head, int k) {

            if (head == null) return null;

            int n = 0;
            Node curr = head;

            while (curr != null) {
                curr = curr.next;
                n++;
            }

            if (k > n || (2 * k - 1 == n)) return head;

            Node prev1 = null, prev2 = null;
            Node node1 = head, node2 = head;

            for (int i = 1; i < k; i++) {
                prev1 = node1;
                node1 = node1.next;
            }

            for (int i = 1; i < n - k + 1; i++) {
                prev2 = node2;
                node2 = node2.next;
            }

            if (prev1 != null) prev1.next = node2;
            if (prev2 != null) prev2.next = node1;

            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;

            if (k == 1) head = node2;
            if (k == n) head = node1;

            return head;
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

        // Test Case 1
        int arr1[] = {1,2,3,4,5};
        Node head1 = createList(arr1);

        System.out.print("Original List: ");
        printList(head1);

        head1 = sol.swapKthNode(head1, 2);

        System.out.print("After Swapping k=2: ");
        printList(head1);


        // Test Case 2
        int arr2[] = {10,20,30,40,50,60};
        Node head2 = createList(arr2);

        System.out.print("\nOriginal List: ");
        printList(head2);

        head2 = sol.swapKthNode(head2, 3);

        System.out.print("After Swapping k=3: ");
        printList(head2);


        // Test Case 3
        int arr3[] = {7,8,9};
        Node head3 = createList(arr3);

        System.out.print("\nOriginal List: ");
        printList(head3);

        head3 = sol.swapKthNode(head3, 1);

        System.out.print("After Swapping k=1: ");
        printList(head3);
    }
}