public class DynamicStack<T> implements MyStack<T> {
    T[] stack;
    int capacity;
    int top;

    public DynamicStack(int capacity) {
        stack = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void push(T x) {
        if (top == capacity) {
            T[] newStack = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
            capacity *= 2;
        }
        stack[top] = x;
        top++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pila vacia");
        }
        top--;
        T objeto = stack[top];
        stack[top] = null; 
        return objeto;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Pila vacia");
        }
        return stack[top - 1];
    }

    @Override 
    public void delete(T n) {
        for (int i = 0; i < top; i++) {
            if (stack[i].equals(n)) {
                for (int j = i; j < top - 1; j++) {
                    stack[j] = stack[j + 1];
                }
                top--;
                stack[top] = null;
                return;
            }
        }
    }
}