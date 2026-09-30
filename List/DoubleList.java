package List;
public class DoubleList<T> {
    private DoubleNode<T> head;
    private int count = 0;

    public DoubleList() {
        this.head = null;
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
            return;
        }
        DoubleNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public T popFront() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar");
        }
        T value = head.key;
        head = head.next;   
        if (head != null) {
            head.prev = null;
        }
        count--;
        return value;
    }

    public T popBack() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar");
        }
        if (head.next == null) {
            T value = head.key;
            head = null;
            count--;
            return value;
        }
        DoubleNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        T value = current.key;
        current.prev.next = null;
        current.prev = null;
        count--;
        return value;
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
        DoubleNode<T> newNode = new DoubleNode<T>(key);
        newNode.prev = node;
        newNode.next = node.next;
        if (node.next != null) {
            node.next.prev = newNode;
        }
        node.next = newNode;
        count++;
    }
}
