import java.util.*;

public class MotherVertex {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        graph[1].add(new Edge(1, 4));

        System.out.println("Mother vertex - " + getMother(graph));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static int getMother(ArrayList<Edge>[] graph) {
        int len = graph.length;
        boolean vis[] = new boolean[len];
        int vertex = -1;

        for(int i = 0; i < len; i++) {
            if(!vis[i]) {
                dfs(graph, i, vis);
                vertex = i;
            }
        }

        boolean check[] = new boolean[len];
        dfs(graph, vertex, check);
        for(boolean i:check) {
            if(!i) {
                return -1;
            }
        }

        return vertex;

    }
}