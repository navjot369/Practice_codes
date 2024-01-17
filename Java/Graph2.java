import java.util.*;

public class Graph2 {
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
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 5));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        // System.out.println("Cycle exists - " + isCycle(graph));
        // TopologicalSort(graph);
        // TopoSort(graph);
        allPaths(graph, 5, 1);
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void topoSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topoSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void TopologicalSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = graph.length-1; i >= 0 ; i--) {
            if(!vis[i]) topoSortUtil(graph, i, vis, s);
        }
        System.out.print("Topological Sort - ");
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " -> ");
        }
        System.out.println();
    }

    //Topological sort using BFS -- Khan's alogrithm
    public static void TopoSort(ArrayList<Edge>[] graph) {
        int indeg[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            for(int ii=0; ii < graph[i].size(); ii++) {
                indeg[graph[i].get(ii).dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        System.out.println("Topo Sort - ");
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " > ");
            for(int i = 0 ; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void allPathsUtil(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest, String str) {
        if(src == dest) {
            System.out.println(str + dest);
        }
        vis[src] = true;
        for(int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!vis[e.dest]) {
                allPathsUtil(graph, vis, e.dest, dest, str+src);
            }
        }
        vis[src] = false;
    }

    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest) {
        boolean vis[] = new boolean[graph.length];
        allPathsUtil(graph, vis, src, dest, "");
    }
}