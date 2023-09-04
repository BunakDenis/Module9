package global.goit.edu.module9;


public class MyLinkedList <E> {

    private MyNode first;
    private MyNode last;
    private int size = 0;

    public MyLinkedList() {

    }

    private static class MyNode <E> {
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        public MyNode(MyNode<E> prev, E item, MyNode<E> next) {
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

/*    public void add(Object value) {
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
            last.next = newMyNode;
            last = newMyNode;
        }
        size++;
    }*/

    public void add(E value) {

        if (first == null) {
            linkedFirst(value);
        } else {
            linkedNext(value);
        }
        size++;
    }

    private void linkedFirst(E value) {
        final MyNode<E> f = new MyNode<>(null, value, null);
        first = f;
        last = first;
        //System.out.println("first.item = " + first.item);
    }

    private void linkedNext(E value) {
        final MyNode<E> l = last;
        final MyNode<E> newMyNode = new MyNode<>(l, value, null);
        last = newMyNode;
        l.next = newMyNode;
        //System.out.println("last.item = " + last.item);
    }

    public int size() {
        return size;
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


    public void remove(int index) {
        int count = 0;
        for (MyNode<E> x = first; x != null; x = x.next) {
            count++;
            if (count == index) {
                unlink(x);
                x.next = null;
                x.item = null;
                x.prev = null;
            }
        }
        size--;
    }

    private void unlink(MyNode<E> x) {
        MyNode<E> next = x.next;
        MyNode<E> prev = x.prev;

        if (prev == null) {
            next.prev = null;
            first = next;
        } else if (next == null) {
            prev.next = null;
            last = prev;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }

    public E get(int index) {

        int count = 1;
        E result = null;

        for (MyNode<E> x = first; x != null; x = x.next) {
            if (count == index) {
                result = x.item;
            }
            count++;
        }

        return result;

    }

    @Override
    public String toString() {
        MyNode<E> f = first;
        //System.out.println("f.item = " + f.item);
        if (f == null) {
            return "[]";
        } else {
            MyNode<E> x = first;
            StringBuilder stringBuilder = new StringBuilder();
            for (; x != null; x = x.next) {
                stringBuilder.append(x.item);

                if (x.next != null) {
                    stringBuilder.append(", ");
                }
            }
            return "[" + stringBuilder.toString() + "]";
        }
    }
}