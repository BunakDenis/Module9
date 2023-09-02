package global.goit.edu.module9;


import java.util.LinkedList;
import java.util.StringJoiner;

public class MyLinkedList {

    private MyNode first;
    private MyNode last;
    private int size = 0;

    public MyLinkedList() {

    }

    private static class MyNode {
        Object item;
        MyNode next;
        MyNode prev;

        public MyNode(MyNode prev, Object item, MyNode next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

/*        @Override
        public String toString() {
            return "MyNode{" +
                    "item=" + item +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }*/
    }

    public void add(Object value) {
        final MyNode l = last;
        final MyNode f = first;
        if (f == null) {
            final MyNode newMyNode = new MyNode(null, value, l);
            first = newMyNode;
        } else if (l == null){
            final MyNode newMyNode = new MyNode(f, value, null);
            last = newMyNode;
            first.next = last;
        } else {
            //Создаём новый нод в него в prev добавляем ссылку на ласт и меняем ласт на новый нод
            final MyNode newMyNode = new MyNode(l, value, null);
            l.next = newMyNode;
            last = newMyNode;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringJoiner = new StringBuilder();
        MyNode f = first;
        if (f.item == null) {
            return "[]";
        } else {
            MyNode x = first;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(first.item);
            for (; x.next != null; x = x.next) {
                stringBuilder.append(", ");
                stringBuilder.append(x.item);
            }
            return "[" + stringBuilder.toString() + "]";
        }
    }

/*
    Методи
        add(Object value) додає елемент в кінець                    +++
        remove(int index) видаляє елемент із вказаним індексом
        clear() очищає колекцію
        size() повертає розмір колекції
        get(int index) повертає елемент за індексом
     */

}
