import java.util.*;

public class GraphBridges {
    public static class Edge{
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest) {
        graph[src].add(new Edge(src, dest));
        graph[dest].add(new Edge(dest, src));
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
        addEdge(graph, 2, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 3, 5);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);

        getBridges(graph);
    }


    static int time;
    public static void getBridges(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        int disc[] = new int[graph.length];
        int low[] = new int[graph.length];
        time = 0;

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                bridges(graph, i, -1, vis, disc, low);
            }
        }
    }

    public static void bridges(ArrayList<Edge>[] graph, int curr, int parent, boolean[] vis, int[] disc, int[] low) {
        vis[curr] = true;
        disc[curr] = low[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                bridges(graph, e.dest, curr, vis, disc, low);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(disc[curr] < low[e.dest]) {
                    System.out.println(curr + " --- " + e.dest);
                }
            }
            else if(e.dest != parent) {
                low[curr] = Math.min(low[curr], disc[e.dest]);
            }


        }

    }
}