import java.util.*;

public class Graphs3 {
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

    public static class Vertex implements Comparable<Vertex> {
        int ind;
        int sp;

        public Vertex(int i, int p) {
            this.ind = i;
            this.sp = p;
        }
        public int compareTo(Vertex v) {
            return this.sp - v.sp;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String main[]) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        Dijkstra(graph, 0);
    }

    public static void Dijkstra(ArrayList<Edge>[] graph, int src) {
        boolean vis[] = new boolean[graph.length];
        int dist[] = new int[graph.length];
        for(int i = 0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(src, 0));
        
        while(!pq.isEmpty()) {
            Vertex curr = pq.remove();
            vis[curr.ind] = true;
            for(int i = 0; i < graph[curr.ind].size(); i++) {
                Edge e = graph[curr.ind].get(i);
                if(!vis[e.dest]) {
                    if(dist[e.src] + e.wt < dist[e.dest]) {
                        dist[e.dest] = dist[e.src] + e.wt;
                        pq.add(new Vertex(e.dest, dist[e.dest]));
                    }
                }
            }
        }
        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}