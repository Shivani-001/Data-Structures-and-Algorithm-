package org.example.LinkedList;

import java.util.*;

public class DeleteNodeWithoutHead {

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

        // Function to delete a node without head pointer
        void deleteNode(Node node) {

            if (node == null || node.next == null) return;

            node.data = node.next.data;
            node.next = node.next.next;
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

    // ===== HELPER: FIND NODE BY VALUE =====
    static Node findNode(Node head, int value) {

        Node curr = head;

        while (curr != null) {
            if (curr.data == value)
                return curr;
            curr = curr.next;
        }

        return null;
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

        int arr[] = {1,2,3,4,5};

        Node head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        // delete node with value 3
        Node nodeToDelete = findNode(head, 3);

        sol.deleteNode(nodeToDelete);

        System.out.print("After Deleting Node 3: ");
        printList(head);
    }
}