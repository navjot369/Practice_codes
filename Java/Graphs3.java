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

    public static class Vertex {
        int ind;
        int sp;

        public Vertex(int i, int p) {
            this.ind = i;
            this.sp = p;
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
    }

    public static void Dijkstra(ArrayList<Edge>[] graph) {
        
    }
}