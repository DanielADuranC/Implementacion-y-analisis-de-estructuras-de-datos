package List;
public class DoubleListTail<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int count = 0;

    public DoubleListTail() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }

    public void pushFront(T key) {
        DoubleNode<T> newNode = new DoubleNode<T>(key);
        count++;
        if (isEmpty()) {
            head = newNode;
            tail = head;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void pushBack(T key) {
        DoubleNode<T> newNode = new DoubleNode<T>(key);
        count++;
        if (isEmpty()) {
            head = newNode;
            tail = head;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public T popFront() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar");
        }
        count--;
        T key = head.key;
        head = head.next;
        if (head != null) {
            head.prev.next = null;
            head.prev = null;
        } else {
            tail = null;
        }
        return key;
    }

    public T popBack() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar");
        }
        count--;
        T key = tail.key;
        tail = tail.prev;
        if (tail != null) {
            tail.next.prev = null;
            tail.next = null;
        } else {
            head = null;
        }
        return key;
    }

    public DoubleNode<T> find(T key) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void erase(DoubleNode<T> node) {
        if (isEmpty() || node == null) {
            return;
        }
        if (head == node) {
            popFront();
            return;
        }
        else if (tail == node) {
            popBack();
            return;
        }
        count--;
        node.prev.next = node.next;
        if (node.next != null) {
        node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    public void addBefore(DoubleNode<T> node, T key) {
        if (isEmpty() || node == null) {
            return;
        }
        if (head == node) {
            pushFront(key);
            return;
        }
        count++;
        DoubleNode<T> newNode = new DoubleNode<T>(key);
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev.next = newNode;
        node.prev = newNode;
    }

    public void addAfter(DoubleNode<T> node, T key) {
        if (isEmpty() || node == null) {
            return;
        }
        if (tail == node) {
            pushBack(key);
            return;
        }
        count++;
        DoubleNode<T> newNode = new DoubleNode<T>(key);
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
    }
}
