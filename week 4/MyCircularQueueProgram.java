public class MyCircularQueueProgram {

    static class MyCircularQueue {

        private int[] queue;
        private int head;
        private int tail;
        private int size;
        private int capacity;

        public MyCircularQueue(int k) {
            capacity = k;
            queue = new int[k];
            head = 0;
            tail = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;

            tail = (tail + 1) % capacity;
            queue[tail] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;

            head = (head + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return queue[head];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return queue[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {

        MyCircularQueue cq = new MyCircularQueue(3);

        System.out.println(cq.enQueue(10)); // true
        System.out.println(cq.enQueue(20)); // true
        System.out.println(cq.enQueue(30)); // true
        System.out.println(cq.enQueue(40)); // false (full)

        System.out.println("Rear: " + cq.Rear()); // 30

        System.out.println(cq.isFull()); // true

        System.out.println(cq.deQueue()); // true
        System.out.println(cq.enQueue(40)); // true

        System.out.println("Rear: " + cq.Rear()); // 40
        System.out.println("Front: " + cq.Front()); // 20
    }
}
