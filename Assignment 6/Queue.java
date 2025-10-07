import java.util.LinkedList;

public class Queue<T> {
    private final LinkedList<T> list = new LinkedList<>();

    public void enqueue(T e) {
        list.addLast(e);
    }

    public T dequeue() {
        return list.isEmpty() ? null : list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        return list.isEmpty() ? null : list.get(0);
    }
}