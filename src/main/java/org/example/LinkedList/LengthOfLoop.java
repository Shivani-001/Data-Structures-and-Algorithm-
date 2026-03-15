package org.example.LinkedList;

import java.util.*;

public class LengthOfLoop {

    // ===== Node Definition =====
    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    // ===== SOLUTION CLASS =====
    static class Solution {

        // Function to find the length of a loop in the linked list.
        public int countNodesinLoop(Node head) {

            Node slow = head, fast = head;

            while (fast != null && fast.next != null) {

                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return countLoopLength(slow);
                }
            }

            return 0;
        }

        public int countLoopLength(Node node) {

            Node temp = node.next;
            int count = 1;

            while (temp != node) {
                temp = temp.next;
                count++;
            }

            return count;
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

    // ===== HELPER: CREATE LOOP =====
    // pos = index where tail connects
    static void createLoop(Node head, int pos) {

        if (pos == -1) return;

        Node loopNode = null;
        Node curr = head;
        int index = 0;

        while (curr.next != null) {

            if (index == pos)
                loopNode = curr;

            curr = curr.next;
            index++;
        }

        curr.next = loopNode;
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Solution sol = new Solution();

        // Test Case 1
        int arr1[] = {1,2,3,4,5};
        Node head1 = createList(arr1);
        createLoop(head1, 2);  // loop starting at index 2 (value 3)

        System.out.println("Loop Length Test 1: " + sol.countNodesinLoop(head1));


        // Test Case 2
        int arr2[] = {10,20,30,40};
        Node head2 = createList(arr2);
        createLoop(head2, 1);  // loop starting at 20

        System.out.println("Loop Length Test 2: " + sol.countNodesinLoop(head2));


        // Test Case 3 (No Loop)
        int arr3[] = {5,6,7,8};
        Node head3 = createList(arr3);

        System.out.println("Loop Length Test 3: " + sol.countNodesinLoop(head3));
    }
}