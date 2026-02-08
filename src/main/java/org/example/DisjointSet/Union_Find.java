package org.example.DisjointSet;

public class Union_Find {

    int find(int x,int[] par){
        if(par[x]!=x) par[x]=find(par[x],par);
        return par[x];
    }
    // Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[]) {
        // add your code here
        int pa=find(a,par);
        int pb=find(b,par);
        if(pa==pb) return ;
        if(rank[pa]>rank[pb]) par[pb]=pa;
        else if(rank[pa]<rank[pb]) par[pa]=pb;
        else {par[pb]=par[pa]; rank[pa]++;}
    }

    // Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[]) {
        // add your code here
        return (find(a, par) == find(b, par));
    }

    public static void main(String[] args) {

            int n = 6; // nodes: 0 to 5

            int[] parent = new int[n];
            int[] rank = new int[n];

            // Initialize DSU
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            // ✅ Create object of SAME class
            Union_Find dsu = new Union_Find();

            // ---- Perform Unions ----
            dsu.union_(0, 1, parent, rank);
            dsu.union_(1, 2, parent, rank);
            dsu.union_(3, 4, parent, rank);

            // ---- Test Connections ----
            System.out.println("0 connected to 2: "
                    + dsu.isConnected(0, 2, parent, rank)); // true

            System.out.println("0 connected to 3: "
                    + dsu.isConnected(0, 3, parent, rank)); // false

            System.out.println("3 connected to 4: "
                    + dsu.isConnected(3, 4, parent, rank)); // true

            System.out.println("4 connected to 5: "
                    + dsu.isConnected(4, 5, parent, rank)); // false

            // ---- Union more ----
            dsu.union_(2, 3, parent, rank);

            System.out.println("0 connected to 4 (after union): "
                    + dsu.isConnected(0, 4, parent, rank)); // true
        }
}