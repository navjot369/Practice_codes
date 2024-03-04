import java.util.*;

public class ArticulationPoint {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int e1, int e2) {
        graph[e1].add(new Edge(e1, e2));
        graph[e2].add(new Edge(e2, e1));
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 4, 5);
        addEdge(graph, 3, 5);

        AP(graph);
    }

    static int time;
    public static void AP(ArrayList<Edge>[] graph) {
        int len = graph.length;
        boolean vis[] = new boolean[len];
        int distime[] = new int[len];
        int lowtime[] = new int[len];
        boolean ap[] = new boolean[len];
        time = 0;
        for(int i = 0; i < len; i++) {
            if(!vis[i]) {
                util(graph, i, -1, distime, lowtime, vis, ap);
            }
        }

        System.out.print("Articulation Points - ");
        for(int i = 0; i < len; i++) {
            if(ap[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void util(ArrayList<Edge>[] graph, int curr, int par, int[] dt, int[] low, boolean[] vis, boolean[] ap) {
        vis[curr] = true;
        int child = 0;
        dt[curr] = low[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                child++;
                util(graph, e.dest, curr, dt, low, vis, ap);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(par != -1 && dt[curr] <= low[e.dest]) {
                    ap[curr] = true;
                }
            }
            else if(e.dest != par) {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }

        if(par == -1 && child > 1) {
            ap[curr] = true;
        }
    }
}