package org.example.LinkedList;

import java.util.*;

public class CheckSortedLinkedList {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ===== Solution =====
    static class Solution {

        public static boolean isSorted(Node head) {

            if (head == null || head.next == null)
                return true;

            int order = 0; // 0 = unknown, 1 = increasing, 2 = decreasing

            if (head.data > head.next.data)
                order = 2;
            else if (head.data < head.next.data)
                order = 1;

            while (head != null && head.next != null) {

                if (order == 0 && head.data != head.next.data) {

                    if (head.data > head.next.data)
                        order = 2;
                    else
                        order = 1;
                }

                else if ((head.data > head.next.data && order == 1) ||
                        (head.data < head.next.data && order == 2)) {

                    return false;
                }

                head = head.next;
            }

            return true;
        }
    }

    // ===== Helper: Create List =====
    static Node createList(int arr[]) {

        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // ===== Helper: Print List =====
    static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        Node head1 = createList(new int[]{1,2,3,4,5});
        Node head2 = createList(new int[]{9,7,5,3});
        Node head3 = createList(new int[]{1,3,2,4});

        System.out.print("List 1: ");
        printList(head1);
        System.out.println("Is Sorted: " + Solution.isSorted(head1));

        System.out.print("\nList 2: ");
        printList(head2);
        System.out.println("Is Sorted: " + Solution.isSorted(head2));

        System.out.print("\nList 3: ");
        printList(head3);
        System.out.println("Is Sorted: " + Solution.isSorted(head3));
    }
}
