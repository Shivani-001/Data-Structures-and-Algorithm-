package org.example.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

class Edge {
    int src;
    int dest;
    int wt;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        wt = w;
    }
}

public class Kuruskal_MST {

    static long kruskalDSU(ArrayList<Edge> adj, int n, int m) {

        Collections.sort(adj, (a, b) -> a.wt - b.wt);

        int parent[] = new int[n];
        int rank[] = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        long mstWeight = 0;
        int edgesUsed = 0;

        for (Edge e : adj) {
            int pu = find(e.src, parent);
            int pv = find(e.dest, parent);

            if (pu != pv) {
                mstWeight += e.wt;
                union(pu, pv, parent, rank);
                edgesUsed++;
            }

            if (edgesUsed == n - 1) break;
        }

        return mstWeight;
    }

    static int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    static void union(int x, int y, int[] parent, int[] rank) {

        int px = find(x, parent);
        int py = find(y, parent);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
    public static void main(String[] args) {

        // ---------- Test Case 1 ----------
        int n1 = 4;
        ArrayList<Edge> edges1 = new ArrayList<>();
        edges1.add(new Edge(0, 1, 10));
        edges1.add(new Edge(0, 2, 6));
        edges1.add(new Edge(0, 3, 5));
        edges1.add(new Edge(1, 3, 15));
        edges1.add(new Edge(2, 3, 4));

        System.out.println("MST Weight (Test 1): "
                + kruskalDSU(edges1, n1, edges1.size()));
        // Expected: 19

        // ---------- Test Case 2 ----------
        int n2 = 5;
        ArrayList<Edge> edges2 = new ArrayList<>();
        edges2.add(new Edge(0, 1, 2));
        edges2.add(new Edge(0, 3, 6));
        edges2.add(new Edge(1, 2, 3));
        edges2.add(new Edge(1, 3, 8));
        edges2.add(new Edge(1, 4, 5));
        edges2.add(new Edge(2, 4, 7));

        System.out.println("MST Weight (Test 2): "
                + kruskalDSU(edges2, n2, edges2.size()));
        // Expected: 16

        // ---------- Test Case 3 (Simple line graph) ----------
        int n3 = 3;
        ArrayList<Edge> edges3 = new ArrayList<>();
        edges3.add(new Edge(0, 1, 1));
        edges3.add(new Edge(1, 2, 2));

        System.out.println("MST Weight (Test 3): "
                + kruskalDSU(edges3, n3, edges3.size()));
        // Expected: 3
    }
}