import java.util.*;


public class Kosaraju {
    public static class Edge{
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        // graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));

        SSC(graph);
    }

    public static void SSC(ArrayList<Edge>[] graph) {
        Stack<Integer> s = getStack(graph);

        ArrayList<Edge>[] trans = transpose(graph);

        boolean[] vis = new boolean[graph.length];
        int total = 0;

        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                dfsComponent(trans, curr, vis);
                System.out.println();
                total++;
            }
        }
        System.out.println("Total SSc - " + total);
    }

    public static void dfsComponent(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr + "  ");

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsComponent(graph, e.dest, vis);
            }
        }
    }

    public static void getStackUtil(ArrayList<Edge>[] graph, Stack<Integer> s, int curr, boolean[] vis) {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                getStackUtil(graph, s, e.dest, vis);
            }
        }
        s.add(curr);
    }

    public static Stack<Integer> getStack(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                getStackUtil(graph, s, i, vis);
            }
        }

        return s;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] transpose(ArrayList<Edge>[] graph) {
        ArrayList<Edge>[] trans = new ArrayList[graph.length];

        for(int i = 0; i < trans.length; i++) {
            trans[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                trans[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        return trans;
    }
}