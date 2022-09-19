package deque;


// My data structure of circular sentinel link list :-)
public class LinkedListDeque <T> {

    private Node sentinel;
    private int size = 0;

    private class Node {
        public T value;
        public Node next;
        public Node prev;

        public Node(T data) {
            value = data;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T data) {
        Node temp = new Node(data);
        temp.next = sentinel.next;
        temp.prev = sentinel;
        sentinel.next.prev = temp;  // most important part
        sentinel.next = temp;
        size += 1;
    }

    public void addLast(T data) {
        Node temp = new Node(data);
        temp.prev = sentinel.prev;
        temp.next = sentinel;
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node cur = sentinel.next;
        for (int i = 0; i < size; i ++) {
            System.out.print(cur.value + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node temp = sentinel.next;
            sentinel.next = temp.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return temp.value;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            Node temp = sentinel.prev;
            temp.prev.next = sentinel;
            sentinel.prev = temp.prev;
            size -= 1;
            return temp.value;
        }
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node temp = sentinel;
        for (int i = 0; i < index; i ++) {
            temp = temp.next;
        }
        return temp.value;
    }
    public T helper(int index, Node curr) {
        if (index != 0) {
            return helper(index - 1, curr.next);
        } else {
            return curr.value;
        }
    }
    public T getRecursive(int index) {

        if (index > size) {
            return null;
        } else {
            return helper(index, sentinel);
        }
    }
}
