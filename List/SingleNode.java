package List;
public class SingleNode<T> {
    T key;
    SingleNode<T> next;

    SingleNode(T key) {
        this.key = key;
        this.next = null;
    }
}
