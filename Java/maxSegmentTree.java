public class maxSegmentTree {
    static int seg[];

    public static void build(int arr[], int ind, int si, int ei) {
        if(si == ei){
            seg[ind] = arr[si]; 
            return;
        }

        int mid = (si+ei)/2;
        build(arr, 2*ind+1, si, mid);
        build(arr, 2*ind+2, mid+1, ei);
        seg[ind] = Math.max(seg[2*ind+1], seg[2*ind+2]);
    }

    public static int query(int ind, int ss, int se, int qs, int qe) {
        if(qe < ss || se < qs) {
            return Integer.MIN_VALUE;
        }
        if(qs <= ss && se <= qe) {
            return seg[ind];
        }

        int mid = (ss+se)/2;
        return Math.max(query(2*ind+1, ss, mid, qs, qe), query(2*ind+2, mid+1, se, qs, qe));
    }

    public static void update(int arr[], int ind, int val) {
        arr[ind] = val;
        updateUtil(0, 0, arr.length-1, ind, val);
    }

    public static void updateUtil(int ind, int ss, int se, int i, int val) {
        if(i < ss || i > se) {
            return;
        }
        
        if(ss == se){
            seg[ind] = val;
        }
        else {
            seg[ind] = Math.max(seg[ind], val);
            int mid = (ss+se)/2;
            updateUtil(2*ind+1, ss, mid, i, val);
            updateUtil(2*ind+2, mid+1, se, i, val);
        }
    }
    public static void main(String args[]) {
        int arr[] = {2, 4, 1, -100, 6, 7, 3, 1};
        int n = arr.length-1;
        seg = new int[4*n];
        build(arr, 0, 0, n);
        for(int i = 0; i < seg.length; i++) {
            System.out.print(seg[i] + " ");
        }
        System.out.println();
        System.out.println(query(0, 0, n, 1, 6));
        update(arr, 3, -1);
        for(int i = 0; i < seg.length; i++) {
            System.out.print(seg[i] + " ");
        }
        System.out.println(query(0, 0, n, 1, 6));
    }
}
