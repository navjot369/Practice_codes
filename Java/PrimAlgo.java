import java.util.*;

public class PrimAlgo {
    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src= s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i=0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 40));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 40));
        graph[1].add(new Edge(1, 3, 10));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 10));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));

        System.out.println("Total cost - " + prims(graph, 0));
    }

    public static int prims(ArrayList<Edge>[] graph, int src) {
        boolean vis[] = new boolean[graph.length];
        ArrayList<Edge> ans = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < graph[src].size(); i++) {
            pq.add(graph[src].get(i));
        }
        vis[src] = true;
        int cost = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                cost += curr.wt;
                ans.add(curr);
                for(int i = 0; i < graph[curr.dest].size(); i++) {
                        pq.add(graph[curr.dest].get(i));
                    
                }
            }
        }

        for(int i = 0; i < ans.size(); i++) {
            Edge curr = ans.get(i);
            System.out.println(curr.src + " -- " + curr.dest);
        }
        return cost;
    }
}