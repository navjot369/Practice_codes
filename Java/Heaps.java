import java.util.ArrayList;

public class Heaps {
    static class Heap {
        ArrayList<Integer> al = new ArrayList<>();

        public void insert(int data) {
            al.add(data);

            int x = al.size() - 1;
            int par = (x-1)/2;

            while(al.get(par) > al.get(x)) {
                int temp = al.get(par);
                al.set(par, al.get(x));
                al.set(x, temp);
                x = par;
                par = (x-1)/2;
            }
        }

        public void heapify(int ind) {
            int minInd = ind;
            int left = 2*ind + 1;
            int right = 2*ind + 2;

            if(left < al.size() && al.get(left) < al.get(minInd)) {
                minInd = left;
            }
            if(right < al.size() && al.get(right) < al.get(minInd)) {
                minInd = right;
            }

            if(minInd != ind) {
                int temp = al.get(ind);
                al.set(ind, al.get(minInd));
                al.set(minInd, temp);

                heapify(minInd);
            }
        }

        public int remove() {
            int data = al.get(0);

            int temp = al.get(al.size() - 1);
            al.set(al.size() - 1, al.get(0));
            al.set(0, temp);

            al.remove(al.size() - 1);

            heapify(0);
            return data;

        }

        public int peek(){
            return al.get(0);
        }

        public boolean isEmpty() {
            return al.size() == 0;
        }
    }

    public static void printAL(ArrayList<Integer> al) {
        for(int i = 0; i < al.size() - 1; i++) {
            System.out.print(al.get(i) + ", ");
        }
        if(al.size() > 0) 
        {
            System.out.println(al.get(al.size() - 1));
        }
    }

    public static void main(String args[]) {
        Heap h1 = new Heap();
        int arr[] = {2, 3, 4, 5, 10, 1};

        for(int i = 0; i < arr.length; i++) {
            h1.insert(arr[i]);
            printAL(h1.al);
            System.out.println(i + "  -------------------");
        }

        System.out.println("\n Now, remove ");
        while(!h1.isEmpty()) {
            printAL(h1.al);
            System.out.println(h1.remove());
        }
        printAL(h1.al);
    }
}