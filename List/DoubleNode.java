package List;
public class DoubleNode<T> {
    T key;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    DoubleNode(T key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
