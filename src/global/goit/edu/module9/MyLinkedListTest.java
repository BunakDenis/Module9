package global.goit.edu.module9;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i);
        }
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println("myLinkedList.getSize() = " + myLinkedList.size());

        System.out.println("myLinkedList.get(5) = " + myLinkedList.get(5));
        myLinkedList.remove(-1);

        System.out.println("myLinkedList.getSize() = " + myLinkedList.size());


        System.out.println("myLinkedList = " + myLinkedList);

        myLinkedList.clear();
        System.out.println("myLinkedList = " + myLinkedList);

        MyLinkedList <String> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.add("Hello");
        System.out.println("myLinkedList1 = " + myLinkedList1);


    }

}