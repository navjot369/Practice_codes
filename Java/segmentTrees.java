public class segmentTrees {

  static int seg[];

  public static void buildSegmentTree(int arr[], int ind, int si, int ei) {
    if (si == ei) {
      seg[ind] = arr[si];
      return;
    }
    int mid = (ei + si) / 2;
    buildSegmentTree(arr, 2 * ind + 1, si, mid);
    buildSegmentTree(arr, 2 * ind + 2, mid + 1, ei);
    seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
  }

  public static int query(int ind, int qs, int qe, int ss, int se) {
    if (se < qs || qe < ss) {
      return 0;
    }

    if (qs <= ss && se <= qe) {
      return seg[ind];
    }

    int mid = (ss + se) / 2;
    int left = query(2 * ind + 1, qs, qe, ss, mid);
    int right = query(2 * ind + 2, qs, qe, mid + 1, se);

    return left + right;
  }

  public static void updateUtil(int i, int si, int ei, int ind, int diff) {
    if (ind < si || ind > ei) {
      return;
    }
    seg[i] += diff;
    if(si != ei) {
        int mid = (si+ei)/2;
        updateUtil(2*i+1, si, mid, ind, diff);
        updateUtil(2*i+2, mid+1, ei, ind, diff);
    }
  }

  public static void update(int arr[], int ind, int newVal) {
    int diff = newVal - arr[ind];
    arr[ind] = newVal;
    updateUtil(0, 0, arr.length-1, ind, diff);
  }

  public static void main(String args[]) {
    int arr[] = { 3, 2, 5, 1, 6, 9 };
    int n = arr.length;
    seg = new int[4 * n];
    buildSegmentTree(arr, 0, 0, n - 1);

    for (int i : seg) {
      System.out.print(i + ", ");
    }
    System.out.println();

    System.out.println(query(0, 2, 4, 0, arr.length - 1));
    update(arr, 3, 7);
    System.out.println(query(0, 2, 4, 0, arr.length - 1));
    
  }
}
