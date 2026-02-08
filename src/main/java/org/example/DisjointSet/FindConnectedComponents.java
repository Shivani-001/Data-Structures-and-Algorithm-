package org.example.DisjointSet;

public class FindConnectedComponents {
    

    // Find function with path compression
    static int find(int x, int arr[]) {
        if (arr[x] != x) {
            arr[x] = find(arr[x], arr); // Path compression
        }
        return arr[x];
    }

    // Function to merge two nodes a and b
    static void unionNodes(int a, int b, int arr[], int rank1[], int n) {
        int parentA = find(a, arr);
        int parentB = find(b, arr);

        if (parentA == parentB) return; // already in same set

        // Union by rank
        if (rank1[parentA] < rank1[parentB]) {
            arr[parentA] = parentB;
        } else if (rank1[parentA] > rank1[parentB]) {
            arr[parentB] = parentA;
        } else {
            arr[parentB] = parentA;
            rank1[parentA]++;
        }
    }

    // Function to count number of connected components
    static int findNumberOfConnectedComponents(int n, int arr[], int rank1[]) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == i) count++; // Node is its own parent → represents a set
        }
        return count;
    }

    // Optional: test main
    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n + 1];
        int[] rank1 = new int[n + 1];

        // Initialize parent of each node to itself
        for (int i = 1; i <= n; i++) arr[i] = i;

        // Example edges: {(1,3), (1,5)}
        unionNodes(1, 3, arr, rank1, n);
        unionNodes(1, 5, arr, rank1, n);

        System.out.println(findNumberOfConnectedComponents(n, arr, rank1)); // Output: 3
    }
}