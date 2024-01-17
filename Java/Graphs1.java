import java.util.*;

public class Graphs1 {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge>[] list = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }

        list[0].add(new Edge(0, 1, 1));
        // list[0].add(new Edge(0, 2, 1));
        list[1].add(new Edge(1, 0, 1));
        // list[1].add(new Edge(1, 3, 1));
        list[2].add(new Edge(2, 3, 1));
        list[3].add(new Edge(3, 2, 1));

        System.out.print("BFS - ");
        bfs(list);
        System.out.print("DFS - ");
        boolean[] vis = new boolean[V];
        dfs(list, 0, vis);
        System.out.println();

        vis = new boolean[V];
        System.out.println("hasPath - " + hasPath(list, 2, 3, vis));
    }

    public static void bfsUtil(ArrayList<Edge>[] list, boolean[] vis, int ind) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(ind);

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i = 0; i < list[curr].size(); i++) {
                    Edge e = list[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void bfs(ArrayList<Edge>[] list) {
        boolean vis[] = new boolean[list.length];
        for(int i = 0; i < list.length; i++) {
            if(!vis[i]){
                bfsUtil(list, vis, i);
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edge>[] list, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < list[curr].size(); i++) {
            if(!vis[list[curr].get(i).dest]){
                dfs(list, list[curr].get(i).dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] list, int src, int dest, boolean[] vis) {
        if(src == dest) {
            return true;
        }

        vis[src] = true;
        for(int i = 0; i < list[src].size(); i++) {
            Edge e = list[src].get(i);
            if(!vis[e.dest] && hasPath(list, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }
}