import java.util.*;

public class ConnectingCities {
    public static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    public static void main(String args[]) {
        int cities[][] =   {{0, 1, 2, 3, 4},
                            {1, 0, 5, 0, 7},
                            {2, 5, 0, 6, 0},
                            {3, 0, 6, 0, 0},
                            {4, 7, 0, 0, 0}};

        System.out.println(connectCities(cities));
    }

    @SuppressWarnings("unchecked")
    public static int connectCities(int cities[][]) {
        int N = cities.length;
        int total = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        boolean vis[] = new boolean[N];

        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                total += curr.cost;
                for(int i = 0; i < N; i++) {
                    if(cities[curr.dest][i] != 0){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return total;
    }
}
