package org.example.LinkedList;

import java.util.*;

public class LinkedListPalindrome {

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

        public boolean isPalindrome(Node head) {

            HashSet<Integer> h = new HashSet<Integer>();

            int sum = 0;

            Node temp = head;

            while (temp != null) {
                sum = sum + temp.data;
                h.add(sum);
                temp = temp.next;
            }

            temp = head;

            while (temp != null) {
                sum = sum - temp.data;

                if (!h.contains(sum) && sum != 0)
                    return false;

                temp = temp.next;
            }

            return true;
        }
    }

    // ===== HELPER: CREATE LINKED LIST =====
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

        // Test Case 1 (Palindrome)
        Node head1 = createList(new int[]{1,2,3,2,1});

        System.out.print("List 1: ");
        printList(head1);

        System.out.println("Is Palindrome: " + sol.isPalindrome(head1));


        // Test Case 2 (Not Palindrome)
        Node head2 = createList(new int[]{1,2,3,4});

        System.out.print("\nList 2: ");
        printList(head2);

        System.out.println("Is Palindrome: " + sol.isPalindrome(head2));


        // Test Case 3 (Palindrome)
        Node head3 = createList(new int[]{5,6,6,5});

        System.out.print("\nList 3: ");
        printList(head3);

        System.out.println("Is Palindrome: " + sol.isPalindrome(head3));
    }
}
