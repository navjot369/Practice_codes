public class GraphDetectCycle {
    public static class Edge{
        int src;
        int dest;

        public Node(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int[] vis, int src, int parent) {
        vis[src] = true;
        ArrayList<Edge> curr = graph[src];
        for(int i = 0; i < curr.size(); i++) {
            
        }
    }
    }

    public static void main(String args[]) {
        int V  = 5;
        ArrayList<Edge>[] graph = new ArrayList<>[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));

        graph[4].add(new Edge(4, 2));

    }
}