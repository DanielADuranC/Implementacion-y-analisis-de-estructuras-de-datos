package List;
public class SingleList<T> {

    private SingleNode<T> head;
    private int count = 0;

    public SingleList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }

    public void pushFront(T key) {
        SingleNode<T> newNode = new SingleNode<T>(key);
        count++;
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void pushBack(T key) {
        SingleNode<T> newNode = new SingleNode<T>(key);
        count++;
        if (isEmpty()) {
            head = newNode;
            return;
        }
        SingleNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    public T popFront() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar");
        }
        T value = head.key;
        head = head.next;
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
        SingleNode<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T value = current.next.key;
        current.next = null;
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
            head = head.next;
            count--;
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
        SingleNode<T> newNode = new SingleNode<T>(key);
        newNode.next = node.next;
        node.next = newNode;
        count++;
        return;
    }

    


}