public class Main {

    static class MyCircularDeque {

        private int[] deque;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularDeque(int k) {
            capacity = k;
            deque = new int[k];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            if (size == 0) {
                front = rear = 0;
            } else {
                front = (front - 1 + capacity) % capacity;
            }
            deque[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            if (size == 0) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            deque[rear] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            if (size == 1) {
                front = 0;
                rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            if (size == 1) {
                front = 0;
                rear = -1;
            } else {
                rear = (rear - 1 + capacity) % capacity;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return deque[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return deque[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {

        MyCircularDeque dq = new MyCircularDeque(5);

        System.out.println("Insert Last 10: " + dq.insertLast(10));
        System.out.println("Insert Last 20: " + dq.insertLast(20));
        System.out.println("Insert Front 5 : " + dq.insertFront(5));
        System.out.println("Front Element  : " + dq.getFront());
        System.out.println("Rear Element   : " + dq.getRear());

        System.out.println("Delete Last    : " + dq.deleteLast());
        System.out.println("Rear Element   : " + dq.getRear());

        System.out.println("Insert Front 99: " + dq.insertFront(99));
        System.out.println("Front Element  : " + dq.getFront());
    }
}
