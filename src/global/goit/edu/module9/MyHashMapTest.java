package global.goit.edu.module9;

public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "Denis");
        myHashMap.put(2, "Max");
        myHashMap.put(3, "Alina");
        myHashMap.put(4, "Igor");
        myHashMap.put(4, "Igor");
        myHashMap.put(4, "Igor");

        System.out.println("myHashMap.get(1) = " + myHashMap.get(1));
        System.out.println("myHashMap.get(2) = " + myHashMap.get(2));
        System.out.println("myHashMap.get(3) = " + myHashMap.get(3));
        System.out.println("myHashMap.get(5) = " + myHashMap.get(5));

        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println(myHashMap);

        myHashMap.remove(1);
        myHashMap.remove(4);

        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println(myHashMap);

        myHashMap.clear();

        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println(myHashMap);

        myHashMap.put(1, "Denis");
        myHashMap.put(2, "Max");
        myHashMap.put(3, "Alina");
        myHashMap.put(4, "Igor");
        myHashMap.put(4, "Igor");
        myHashMap.put(4, "Igor");

        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println(myHashMap);
    }
}
