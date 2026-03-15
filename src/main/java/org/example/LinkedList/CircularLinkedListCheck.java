package org.example.LinkedList;

import java.util.*;

public class CircularLinkedListCheck {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    // ===== Solution =====
    static class Solution {

        public static boolean isCircular(Node head) {

            if (head == null)
                return true;

            Node curr = head.next;

            while (curr != null && curr != head) {
                curr = curr.next;
            }

            return (curr == head);
        }
    }

    // ===== Create Normal List =====
    static Node createList(int arr[]) {

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            curr.next = temp;
            temp.prev = curr;
            curr = temp;
        }

        return head;
    }

    // ===== Make Circular =====
    static void makeCircular(Node head) {

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        head.prev = curr;
    }

    // ===== Print (safe for non circular) =====
    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    // ===== Main =====
    public static void main(String[] args) {

        Node head1 = createList(new int[]{1,2,3,4});

        System.out.print("List 1: ");
        printList(head1);

        System.out.println("Is Circular: " + Solution.isCircular(head1));

        Node head2 = createList(new int[]{5,6,7,8});
        makeCircular(head2);

        System.out.println("\nList 2 made circular.");

        System.out.println("Is Circular: " + Solution.isCircular(head2));
    }
}
