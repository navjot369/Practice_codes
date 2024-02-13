import java.util.*;

public class CheapestKStops {
    public static class Edge {
        int src;
        int dest;
        int cost;

        public Edge(int s, int d, int c) {
            this.src = s;
            this.dest = d;
            this.cost = c;
        }
    }

    public static class Info {
        int vert;
        int stops;

        public Info(int v, int s) {
            this.vert = v;
            this.stops = s;
        }
    }

    public static void main(String args[]) {
        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0;
        int dest = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dest, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0));

        int dist[] = new int[n];
        for(int i = 0; i < n; i++){ 
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }

            for(int i = 0; i < graph[curr.vert].size(); i++) {
                Edge e = graph[curr.vert].get(i);
                if(dist[e.dest] > dist[e.src] + e.cost) {
                    dist[e.dest] = dist[e.src] + e.cost;
                    System.out.println(e.dest + " -- " + (curr.stops + 1));
                    q.add(new Info(e.dest, curr.stops + 1));
                }
            }
        }

        return (dist[dst] == Integer.MAX_VALUE? -1 : dist[dst]);
    }
}