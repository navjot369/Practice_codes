import java.util.*;

public class KruskalAlgo {
    public static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int cost;

        public Edge(int s, int d, int c){
            this.src = s;
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;
    static int[] par = new int[n];

    public static void init() {
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = par[a];
        int parB = par[b];

        par[parA] = parB;
    }

    public static int kruskal(ArrayList<Edge> edges) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for(int i = 0; count < n-1 ;i++) {
            Edge e = edges.get(i);
            if(find(e.src) != find(e.dest)) {
                union(e.src, e.dest);
                mstCost += e.cost;
                count++;
            }
        }
        return mstCost;
    }

    public static void main(String args[]) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        System.out.println(kruskal(edges));
    }
}