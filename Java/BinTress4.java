import java.util.*;

/* Question is to find the minimum Depth of Binary Tree.
It is done by using concepts of graph as binary tree can be thought as directed graph 
with no possible cycle and overlapping of vertex.
*/

public class BinTress4 {
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
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(0, 5));

        System.out.println("Minimum depth - " + minDepth(graph));
    }

    public static int minDepth(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(-1);
        int depth = 0;
        while(!q.isEmpty()) {
            int ind = q.remove();
            if(ind == -1) {
                depth++;
                q.add(-1);
                continue;
            }
            if(graph[ind].size() == 0) {
                return depth;
            }
            for(int i = 0; i < graph[ind].size(); i++) {
                q.add(graph[ind].get(i).dest);
            }
        }
        return depth;
    }
}