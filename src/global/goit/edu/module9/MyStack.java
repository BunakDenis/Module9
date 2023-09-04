package global.goit.edu.module9;

import java.util.StringJoiner;

public class MyStack<E> {

    private MyNode<E> first;
    private MyNode<E> last;
    private int size = 0;

    private static class MyNode<E> {
        private MyNode<E> prev;
        private E item;
        private MyNode<E> next;

        public MyNode(MyNode<E> prev, E item, MyNode<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public void push(E value) {
        if (first == null) {
            linkedFirst(value);
        } else {
            linkedLast(value);
        }
        size++;
    }

    private void linkedFirst(E value) {
        MyNode<E> f = new MyNode<>(null, value, null);
        first = last = f;
    }

    private void linkedLast(E value) {
        MyNode<E> l = last;
        MyNode<E> newNode = new MyNode<>(l, value, null);
        last = newNode;
    }

    public void remove(int index) {
        int count = 0;
        for (MyNode<E> x = last; x != null; x = x.prev) {
            if (index == count) {
                unlink(x);
                x.prev = null;
                x.item = null;
                x.next = null;
            }
            count++;
        }
        size--;
    }

    private void unlink(MyNode<E> myNode) {

        MyNode<E> prev = myNode.prev;
        MyNode<E> next = myNode.next;

        if (next == null) {
            prev.next = null;
            last = prev;
        } else if (prev == null) {
            next.prev = null;
            first = next;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }

    public void clear() {
        for (MyNode<E> x = first; x != null; x = x.next) {
            x.prev = null;
            x.item = null;
            x.next = null;
        }
        first = last = null;
        size = 0;
    }

    public int size() {

        return size;

    }

    public E peek() {
        E result;
        result = last.item;
        return result;
    }

    public E pop() {
        E result;
        result = last.item;

        MyNode<E> l = last.prev;
        last.next = null;
        last.item = null;
        last.prev = null;

        l.next = null;
        last = l;
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");

        if (first == null) {
            return "[]";
        }
        for (MyNode<E> x = last; x != null; x = x.prev) {
            stringJoiner.add(String.valueOf(x.item));
        }
        return "[" + stringJoiner + "]";
    }
}
