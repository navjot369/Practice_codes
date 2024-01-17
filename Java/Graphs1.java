import java.util.*;

public class Graph1 {
    static class Edge {
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
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 4, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 3, 1));

        // graph[4].add(new Edge(4, 3, 1));

        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));

        bfs(graph, V);
        dfs(graph, V);
        boolean vis[] = new boolean[V];
        System.out.println(hasPath(graph, 0, 5, vis));

        System.out.println("Has Cycle - " + hasCycle(graph, V));
        System.out.println("Bipartite - " + isBipartite(graph, V));
        System.out.println("2. Bipartite - " + isBipartite2(graph, V));
    }

    public static void bfsUtil(int ind, ArrayList<Edge>[] graph, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(ind);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                ArrayList<Edge> curr_list = graph[curr];
                for(int i = 0; i < curr_list.size(); i++) {
                    q.add(curr_list.get(i).dest);
                    
                }
            }
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                bfsUtil(i, graph, vis);
            }
        }
        System.out.println();
    }

    public static void dfsUtil(int ind, ArrayList<Edge>[] graph, boolean[] vis) {
        if(vis[ind]) return;

        System.out.print(ind + " ");
        vis[ind] = true;
        ArrayList<Edge> curr = graph[ind];
        for(int i = 0; i < curr.size(); i++) {
            if(!vis[curr.get(i).dest]) {
                dfsUtil(curr.get(i).dest, graph, vis);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        for(int i=0; i < V; i++) {
            if(!vis[i]) {
                dfsUtil(i, graph, vis);
            }
        }
        System.out.println();
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if(src == dest) {
            return true;
        }

        vis[src] = true;
        for(int i = 0; i < graph[src].size(); i++) {
            if(!vis[graph[src].get(i).dest] && hasPath(graph, graph[src].get(i).dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph, int ind, int parent, boolean[] vis) {
        vis[ind] = true;

        for(int i = 0; i < graph[ind].size(); i++) {
            Edge e = graph[ind].get(i);
            if(!vis[e.dest]){
                if(hasCycleUtil(graph, e.dest, ind, vis)) {
                    return true;
                }
            }
            else if(vis[e.dest] && e.dest != parent) {
                return true;
            }
            
        }
        return false;
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        for(int i = 0; i< V; i++) {
            if(!vis[i] && hasCycleUtil(graph, i, -1, vis)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph, int V) {
        int col[] = new int[V];
        for(int i = 0 ; i<V; i++) col[i] = -1;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int ii = 0; ii < graph[curr].size(); ii++) {
                        Edge e = graph[curr].get(ii);
                        if(col[e.dest] == -1) {
                            col[e.dest] = col[curr] == 0? 1 : 0;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isBipartUtil(ArrayList<Edge>[] graph, int[] vis,boolean[] isvis, int curr, int parent) {
        vis[curr] = 1;
        isvis[curr] = true;
        printArr(curr, vis);
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(isvis[e.dest]) {
                if(e.dest != parent && vis[e.dest] % 2 != 0) {
                    return false;
                }
            }else{
                for(int ii=0; ii < vis.length;ii++) {
                    if(vis[ii] != 0) vis[ii]++;
                }
                if(!isBipartUtil(graph, vis, isvis, e.dest, curr)) {
                    return false;
                }
                for(int ii=0; ii < vis.length; ii++) {
                    if(vis[ii] != 0) vis[ii]--;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite2(ArrayList<Edge>[] graph, int V) {
        boolean isvis[] = new boolean[V];
        int vis[] = new int[V];
        for(int i = 0 ; i < V; i++) {
            if(!isvis[i]) {
                if(!isBipartUtil(graph, vis, isvis, i, -1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printArr(int curr,int[] arr) {
        System.out.print(curr + " -- ");
        for(int i:arr) System.out.print(i + ", ");
        System.out.println();
    }
}