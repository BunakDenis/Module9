package global.goit.edu.module9;

import java.util.StringJoiner;

public class MyQueue<E> {

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
    public void add(E value) {
        if (first == null) {
            linkedFirst(value);
        } else {
            linkedNext(value);
        }
        size++;
    }
    private void linkedFirst(E value) {
        final MyNode<E> myNode = new MyNode<>(null, value, null);
        first = last = myNode;
    }
    private void linkedNext (E value) {
        final MyNode<E> l = last;
        final MyNode<E> myNode = new MyNode<>(l, value, null);
        last = myNode;
        l.next = myNode;
    }
    public void clear() {
        for (MyNode <E> x = first; x != null ; x = x.next) {
            x.prev = null;
            x.item = null;
            x.next = null;
        }
        first = last = null;
        size = 0;
    }
    public int size () {
        return size;
    }
    public E peek() {
        if (first != null) {
            E result = (E) first.item;
            return result;
        } else {
            MyNode <Integer> myNode = new MyNode<>(null, -1, null);
            E result = (E) myNode.item;
            return result;
        }
    }
    public E poll() {
        if (first != null) {
            E result = (E) first.item;
            unLinkedFirst();
            size--;
            return result;
        } else {
            MyNode <Integer> myNode = new MyNode<>(null, -1, null);
            E result = (E) myNode.item;
            return result;
        }
    }
    private void unLinkedFirst () {
        final MyNode<E> f = first.next;
        f.prev = null;
        first.prev = null;
        first.item = null;
        first.next = null;
        first = f;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        if (first == null) {
            return "[]";
        } else {
            for (MyNode<E> x = first; x != null ; x = x.next) {
                stringJoiner.add(String.valueOf(x.item));
            }
        }
        return "[" + stringJoiner + "]";
    }
}