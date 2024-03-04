import java.util.*;

public class CycleDetectionUF {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static int V;
    static int par[];
    static int rank[];

    public static int find(int ver) {
        if(par[ver] == ver) {
            return ver;
        }
        return find(par[ver]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] > rank[parB]) {
            par[parB] = parA;
        }
        else if(rank[parB] > rank[parA]) {
            par[parA] = parB;
        }
        else{
            par[parB] = parA;
            rank[parA]++;
        }
    }

    public static boolean isCycle(ArrayList<Edge> edges) {
        par = new int[V];
        rank = new int[V];
        for(int i = 0; i < V; i++) {
            par[i] = i;
            rank[i] = 0;
        }

        for(int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if(find(e.src) == find(e.dest)) {
                return true;
            }

            union(e.src, e.dest);
        }

        return false;
    }

    public static void main(String args[]) {
        V = 5;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 4));
        // edges.add(new Edge(1, 4));  //This edge makes cycle
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));

        if(isCycle(edges)) {
            System.out.println("Cycle exists");
        }
        else{
            System.out.println("Cycle don't exists");
        }
    }
}