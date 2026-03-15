package org.example.LinkedList;
import java.util.*;
public class RemoveLoopLinkedList {


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

        public static void removeLoop(Node head) {

            Node slow = head, fast = head;
            boolean flag = false;

            while (slow != null && fast != null && fast.next != null) {

                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    flag = true;
                    break;
                }
            }

            if (!flag) return;

            slow = head;

            if (slow == fast) {

                while (fast.next != slow)
                    fast = fast.next;

            } else {

                while (fast.next != slow.next) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }

            fast.next = null;
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

    // ===== HELPER: CREATE LOOP =====
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

    // ===== SAFE PRINT (prevents infinite printing) =====
    static void printList(Node head, int limit) {

        Node curr = head;
        int count = 0;

        while (curr != null && count < limit) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
            count++;
        }

        System.out.println("null");
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5};

        Node head = createList(arr);

        // create loop at index 2 (node value 3)
        createLoop(head, 2);

        System.out.println("List before removing loop (limited print):");
        printList(head, 10);

        Solution.removeLoop(head);

        System.out.println("List after removing loop:");
        printList(head, 10);
    }
}