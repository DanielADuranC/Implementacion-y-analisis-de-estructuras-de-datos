package List;
public class SingleListTail<T> {
    private SingleNode<T> head;
    private SingleNode<T> tail;
    private int count = 0;

    public SingleListTail() {
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
        SingleNode<T> newNode = new SingleNode<>(key);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public void pushBack(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public T popFront() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar");
        }
        T value = head.key;
        head = head.next;
        if (head == null) {
            tail = null;
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
            tail = null;
            count--;
            return value;
        }
        SingleNode<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T value = tail.key;
        tail = current;
        tail.next = null;
        count--;
        return value;
    }

    public SingleNode<T> find(T key) {
        SingleNode<T> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void erase(SingleNode<T> node) {
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
        SingleNode<T> current = head;
        while (current.next != null) {
            if (current.next == node) {
                current.next = current.next.next;
                count--;
                return;
            }
            current = current.next;
        }
    }

    public void addBefore(SingleNode<T> node, T key) {
        if (isEmpty() || node == null) {
            return;
        }
        if (head == node) {
            pushFront(key);
            return;
        }
        SingleNode<T> current = head;
        while (current.next != null) {
            if (current.next == node) {
                SingleNode<T> newNode = new SingleNode<T>(key);
                newNode.next = current.next;
                current.next = newNode;
                count++;
                return;
            }
            current = current.next;
        }
    }

    public void addAfter(SingleNode<T> node, T key) {
        if (isEmpty() || node == null) {
            return;
        }
        if (tail == node) {
            pushBack(key);
            return;
        }
        SingleNode<T> newNode = new SingleNode<T>(key);
        newNode.next = node.next;
        node.next = newNode;
        count++;
        return;
    }

}