package org.example.DisjointSet;

import java.util.ArrayList;

public class DetectCyclesinGraph_usingDSU {

    // DSU find with path compression
    static int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    // DSU union by rank
    static void union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);

        if (px == py) return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    // Function to detect cycle using DSU
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int parent[] = new int[V];
        int rank[] = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Traverse all edges
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {

                // process each undirected edge only once
                if (u < v) {
                    int pu = find(u, parent);
                    int pv = find(v, parent);

                    if (pu == pv)
                        return 1; // cycle detected

                    union(u, v, parent, rank);
                }
            }
        }
        return 0;
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        DetectCyclesinGraph_usingDSU sol = new DetectCyclesinGraph_usingDSU();

        /* ---------- Test Case 1 : Graph WITH cycle ---------- */
        int V1 = 5;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();

        for (int i = 0; i < V1; i++)
            adj1.add(new ArrayList<>());

        // 0-2-4-0 forms a cycle
        adj1.get(0).add(2);
        adj1.get(2).add(0);

        adj1.get(2).add(4);
        adj1.get(4).add(2);

        adj1.get(4).add(0);
        adj1.get(0).add(4);

        int expected1 = 1;
        int actual1 = sol.detectCycle(V1, adj1);

        System.out.println("Test Case 1 (Cycle Present)");
        System.out.println("Expected Output: " + expected1);
        System.out.println("Actual Output  : " + actual1);
        System.out.println();


        /* ---------- Test Case 2 : Graph WITHOUT cycle ---------- */
        int V2 = 4;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i < V2; i++)
            adj2.add(new ArrayList<>());

        // Tree structure: 0-1-2-3
        adj2.get(0).add(1);
        adj2.get(1).add(0);

        adj2.get(1).add(2);
        adj2.get(2).add(1);

        adj2.get(2).add(3);
        adj2.get(3).add(2);

        int expected2 = 0;
        int actual2 = sol.detectCycle(V2, adj2);

        System.out.println("Test Case 2 (No Cycle)");
        System.out.println("Expected Output: " + expected2);
        System.out.println("Actual Output  : " + actual2);
    }
}