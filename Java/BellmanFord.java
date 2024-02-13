import java.util.*;

public class BellmanFord {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int V  = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 4, 2));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 5, 2));
        graph[5].add(new Edge(5, 3, -3));


        algo(graph, 0);

    }

    public static void algo(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int[] dis = new int[V];
        for(int i = 0; i < V; i++) {
            if(i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < V; i++) {
            for(int ii = 0; ii < V; ii++) {
                for(int iii=0; iii < graph[ii].size(); iii++) {
                    Edge e = graph[ii].get(iii);
                    if(dis[e.src] != Integer.MAX_VALUE && dis[e.src] + e.wt < dis[e.dest]) {
                        dis[e.dest] = dis[e.src] + e.wt;
                    }
                }
            }
        }

        // Graph to check for negative weight cycle
        for(int i = 0; i < V; i++) {
            for(int ii = 0; ii < graph[i].size(); ii++) {
                Edge e = graph[i].get(ii);
                if(dis[e.src] != Integer.MAX_VALUE && dis[e.src] + e.wt < dis[e.dest]) {
                    System.out.println("Negative cycle exists!!!");
                    return;
                }
            }
        }

        for(int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dis[i]);
        }
    }
}