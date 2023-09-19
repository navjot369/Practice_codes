import java.util.LinkedList;
import java.util.ArrayList;

public class HashMaps_Implement {
    public static class hashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public hashMap() {
            N = 4;
            buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFun(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for(int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        public void put(K key, V value) {
            int bi = hashFun(key);
            int di = searchInLL(key, bi);
            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)(n/N);
            if(lambda > 2.0) {
                rehash();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            N *= 2;
            buckets = new LinkedList[N];
            for(int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for(int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFun(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFun(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return buckets[bi].get(di).value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFun(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySets() {
            ArrayList<K> list = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node:ll) {
                    list.add(node.key);
                }
            }
            return list;
        }
    }

    public static void main(String args[]) {
        hashMap<String, Integer> hm = new hashMap<>();
        hm.put("China", 34);
        hm.put("India", 23);
        hm.put("Nepal", 12);

        System.out.println(hm.get("Nepal"));
        System.out.println(hm.remove("India"));


        ArrayList<String> list = hm.keySets();

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
