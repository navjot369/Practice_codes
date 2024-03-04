import java.util.*;

public class finishAllTasks {
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
        int arr[][] = {{1, 0}, {0, 1}};
        int N = 3;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < arr.length; i++) {
            graph[arr[i][1]].add(new Edge(arr[i][1], arr[i][0]));
        }

        // System.out.println(isPossible(graph));
    }

    // public static boolean isPossible(ArrayList<Edge>[] graph) {

    // }
}