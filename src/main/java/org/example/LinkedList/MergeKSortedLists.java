package org.example.LinkedList;
import java.util.*;

public class MergeKSortedLists {

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

        Node mergeKLists(Node[] arr) {

            if (arr == null || arr.length == 0) return null;

            int i = 1;

            while (i < arr.length) {
                arr[i] = sortedmerge(arr[i - 1], arr[i]);
                i++;
            }

            return arr[arr.length - 1];
        }

        Node sortedmerge(Node head1, Node head2) {

            Node head = new Node(0);
            Node temp = head;

            while (head1 != null || head2 != null) {

                if (head1 != null && head2 != null) {

                    if (head1.data < head2.data) {
                        temp.next = head1;
                        head1 = head1.next;
                    } else {
                        temp.next = head2;
                        head2 = head2.next;
                    }

                } else if (head1 != null) {
                    temp.next = head1;
                    head1 = head1.next;

                } else {
                    temp.next = head2;
                    head2 = head2.next;
                }

                temp = temp.next;
            }

            return head.next;
        }
    }

    // ===== HELPER: CREATE LIST FROM ARRAY =====
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

        Node list1 = createList(new int[]{1,4,7});
        Node list2 = createList(new int[]{2,5,8});
        Node list3 = createList(new int[]{3,6,9});

        Node arr[] = {list1, list2, list3};

        System.out.println("Input Lists:");

        for (Node head : arr) {
            printList(head);
        }

        Node merged = sol.mergeKLists(arr);

        System.out.println("\nMerged List:");
        printList(merged);
    }
}