package global.goit.edu.module9;

public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue<Integer> myQueueTest = new MyQueue();

        for (int i = 10; i < 100; i++) {
            myQueueTest.add(i);
        }

        System.out.println("myQueueTest.peek() = " + myQueueTest.peek());
        System.out.println("myQueueTest = " + myQueueTest);
        System.out.println("myQueueTest.size() = " + myQueueTest.size());

        myQueueTest.clear();

        System.out.println("myQueueTest = " + myQueueTest);
        System.out.println("myQueueTest.size() = " + myQueueTest.size());

        for (int i = 50; i < 100; i++) {
            myQueueTest.add(i);
        }

        for (int i = 0; i < 25; i++) {

            System.out.println("myQueueTest.poll() = " + myQueueTest.poll());
        }

        System.out.println("myQueueTest = " + myQueueTest);
    }
}
