public class disjointSet {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() { // to initialize the parent array.
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) { //recursive calls
        if(par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
        //This is for optimization, once we find the parent of a element we
        //can store it directly in par[] as we always need topmost parent.
    }

    public static void union(int a, int b) {
        int parA = par[a];
        int parB = par[b];

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] > rank[parB]) { 
            par[parB] = parA;
        }
        else{
            par[parA] = parB;
        }
    }

    public static void main(String args[]) {
        init();
        System.out.println(find(3));
        union(5, 1);
        union(5, 6);
        union(5, 3);
        System.out.println(find(3));
    }
}