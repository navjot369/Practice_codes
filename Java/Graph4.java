import java.util.*;

public class Graph4 {
    public static class Edge {
        int src;
        int dest;
        boolean isVis;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            this.isVis = false;
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge>[] graph= new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        System.out.println("Is cycle -- " + isCycle(graph));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        int parent[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++) parent[i] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()) {
            int ind = q.remove();
            vis[ind] = true;
            for(int i = 0; i < graph[ind].size(); i++) {
                Edge e = graph[ind].get(i);
                if(!vis[e.dest]) {
                    if(parent[e.dest] != -1) {
                        return true;
                    }
                    else{
                        parent[e.dest] = ind;
                    }
                    q.add(e.dest);
                }
                else {
                    if(parent[ind] != e.dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}