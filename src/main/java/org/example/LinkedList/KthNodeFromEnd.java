package org.example.LinkedList;
import java.util.*;

public class KthNodeFromEnd {


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

        // Function to find the data of kth node from the end
        int getKthFromLast(Node head, int k) {

            if (head == null || k <= 0) return -1;

            Node fast = head, slow = head;

            for (int i = 0; i < k; i++) {
                if (fast == null) return -1;
                fast = fast.next;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow.data;
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

        int arr[] = {10, 20, 30, 40, 50};

        Node head = createList(arr);

        System.out.print("Linked List: ");
        printList(head);

        int k1 = 2;
        System.out.println("Kth from end (k=" + k1 + "): " + sol.getKthFromLast(head, k1));

        int k2 = 5;
        System.out.println("Kth from end (k=" + k2 + "): " + sol.getKthFromLast(head, k2));

        int k3 = 7;
        System.out.println("Kth from end (k=" + k3 + "): " + sol.getKthFromLast(head, k3));
    }
}