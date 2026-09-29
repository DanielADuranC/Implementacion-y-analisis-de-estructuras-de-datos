public class DynamicQueue<T> implements MyQueue<T> {
    T[] queue;
    int capacity;
    int front;
    int rear;
    int size;

    public DynamicQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public void enqueue(T x) {
        if (size == capacity) {
            T[] NewQueue = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                NewQueue[i] = queue[(front + i) % capacity];
            }
            queue = NewQueue;
            capacity *= 2;
            front = 0;
            rear = size;
        }
        queue[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T objeto = queue[front];
        queue[front] = null; 
        front = (front + 1) % capacity;
        size--;
        return objeto;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    @Override
    public void delete(T n) {
        if (isEmpty()) {
            return;
        }
        int index = front;
        for (int i = 0; i < size; i++) {
            if (queue[index].equals(n)) {
                if (index == front) {
                    dequeue();
                    return;
                }
                for (int j = index; j != rear; j = (j + 1) % capacity) {
                    queue[j] = queue[(j + 1) % capacity];
                }
                rear = (rear - 1 + capacity) % capacity;
                queue[rear] = null;
                size--;
                return;
            }
            index = (index + 1) % capacity;
        }
    }

    

}