//This is implementation of Circular Queue using Array.

public class CirQueue_Array {
    static class Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if(isFull()) {
                return;
            }

            rear = (rear + 1) % size;
            if(front == -1) {
                front = 0;
            }
            arr[rear] = data;
        }

        public int remove() {
            if(isEmpty()) {
                return -1;
            }
            int res = arr[front];
            if(front == rear) {
                rear = front = -1;
            }
            else{
                front = (front + 1) % size;
            }

            return res;
        }

        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
