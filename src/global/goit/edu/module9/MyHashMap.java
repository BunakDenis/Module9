package global.goit.edu.module9;

import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> {

    private K key;
    private V value;
    private MyNode<K, V> head;
    private int size = 0;

    private static class MyNode<K, V> {
        private K key;
        private V value;
        private MyNode<K, V> next;

        public MyNode(K key, V value, MyNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {

        MyNode<K, V> newMyNode = new MyNode<>(key, value, null);

        if (head == null) {
            head = newMyNode;
            size++;
        } else {
            if (!compressionOfHashKeys(key)) {
                MyNode<K, V> x = head;
                for (; x != null; x = x.next) {
                    if (x.next == null) {
                        break;
                    }
                }
                x.next = newMyNode;
                size++;
            } else {
                System.out.println("Element with this key is in collection");
            }
        }
    }

    private boolean compressionOfHashKeys(K key) {
        int newKey = Objects.hash(key);
        boolean result = false;
        for (MyNode<K, V> x = head; x != null; x = x.next) {
            int hashKey = Objects.hash(x.key);

            /* System.out.println("Key of new element = " + key + ", hash of this key = " + newKey +
                    ", Key for compression = " + x.key + ", hash of this key = " + Objects.hash(x.key));

             */
            if (newKey == hashKey) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void remove(K key) {

        if (head.key == key) {
            unlinkHead();
        } else {
            unlink(key);
        }
    }

    private void unlinkHead() {
        MyNode<K, V> x = head.next;

        head.next = null;
        head.key = null;
        head.value = null;
        head = x;
        size--;
    }

    private void unlink(K key) {
        for (MyNode<K, V> x = head; x != null; x = x.next) {
            MyNode<K, V> next = x.next;
            if (next.key == key) {
                x.next = next.next;
                next.next = null;
                next.key = null;
                next.value = null;
                size--;
            }
        }
    }

    public void clear() {
        for (MyNode<K, V> x = head; x != null; x = x.next) {
            x.next = null;
            x.key = null;
            x.value = null;
        }
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get (K key) {
        V result = null;
        for (MyNode<K, V> x = head; x != null; x = x.next) {
            if (x.key == key) {
                result = x.value;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (head == null) {
            return "[]";
        }

        for (MyNode<K, V> x = head; x != null; x = x.next) {
            V result = x.value;
            stringBuilder.append(result);
            if (x.next != null) {
                stringBuilder.append(",");
            }
        }
        return "[" + stringBuilder + "]";
    }
}