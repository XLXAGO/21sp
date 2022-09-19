package deque;

public class ArrayDeque <T> {

    private T[] items;
    private int capacity;
    private int first = 0;
    private int last = 0;
    private int size;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize(2 * capacity);
        }

        if (first == 0) {
            first = capacity - 1;
        } else {
            first -= 1;
        }
        items[first] = item;
        size += 1;

    }

    public void addLast(T item) {
        if (isFull()) {
            resize(2 * capacity);
        }

        if (last == capacity) {
            last = 0;
        } else {
            last += 1;
        }
        items[last] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i ++) {
            System.out.print(items[(first + i) % capacity] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T temp = items[first];
        items[first] = null;

        if (first == capacity) {
            first = 0;
        } else {
            first += 1;
        }
        size -= 1;

        return temp;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T temp = items[last];
        items[last] = null;

        if (last == 0) {
            last = capacity;
        } else {
            last -= 1;
        }
        size -= 1;

        return temp;
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        return items[(first + index) % capacity];
    }
}
