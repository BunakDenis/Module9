package global.goit.edu.module9;

public class MyStackTest {
    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>();

        for (int i = 0; i < 50; i++) {

            myStack.push(i);

        }

        System.out.println("myStack.pop() = " + myStack.pop());

        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("myStack.peek() = " + myStack.peek());

        System.out.println("myStack = " + myStack);

        myStack.remove(0);

        System.out.println("myStack.pop() = " + myStack.pop());

        System.out.println("myStack.peek() = " + myStack.peek());

        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("myStack = " + myStack);

        myStack.clear();

        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("myStack.pop() = " + myStack.pop());

        System.out.println("myStack = " + myStack);
    }
}
