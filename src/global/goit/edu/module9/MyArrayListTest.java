package global.goit.edu.module9;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList <Integer> arr = new MyArrayList<>();

        for (int i = 0; i < 2; i++) {
            arr.add(i);
        }
        arr.add(0);
        arr.add(1);

        arr.remove(3);

        System.out.println("arr = " + arr);
    }
}