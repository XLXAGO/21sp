package deque;

public class ArrayDeque<T> implements Deque<T> {

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

    public void resize(int sizer) {
        T[] temp = (T[]) new Object[sizer];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public boolean isFull() {
        return size == capacity;
    }
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(2 * capacity);
        }
        if (isEmpty()) {
            first = 0;
            last = 0;
        }
        if (first == 0) {
            first = capacity - 1;
        } else {
            first -= 1;
        }
        items[first] = item;
        size += 1;

    }
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(2 * capacity);
        }
        if (isEmpty()) {
            first = 0;
            last = 0;
        }

        if (last == capacity) {
            last = 0;
        } else {
            last += 1;
        }
        items[last] = item;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(first + i) % capacity] + " ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if ((size - 1) < 0.25 * capacity && capacity > 8) {
            resize(capacity / 2);
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
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if ((size-1) < 0.25*capacity && capacity > 8) {
            resize(capacity / 2);
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
    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        return items[(first + index) % capacity];
    }
}
