package global.goit.edu.module9;

import java.util.Objects;
import java.util.StringJoiner;

public class MyArrayList<T> {

    private static final int ARRAY_SIZE = 10;
    private int index;
    private Object[] data;

    public MyArrayList() {
        data = new Object[ARRAY_SIZE];
    }

    public void add(T value) {

        resizeIfNeed();

        data[index] = value;
        index++;

    }

    private void resizeIfNeed() {
        if (index == data.length) {
            int newArraySize = data.length * 2;
            System.out.println("Resize index = " + index + ", new size = " + newArraySize);
            Object[] newArray = new Object[newArraySize];
            System.arraycopy(data, 0, newArray, 0, data.length);
            data = newArray;
        }
    }

    public void remove(int indexToRemove) {
        Object[] newData = new Object[data.length];

        for (int i = 0, k = 0; i < index; i++) {
            if (i != indexToRemove) {
                newData[k] = data[i];
                k++;
            }
        }

        data = newData;
        index--;
        reduceSizeIfNeed(); //уменьшаем размер по необходимости
    }

    public void clear() {
        Object[] newData = new Object[ARRAY_SIZE];
        data = newData;
        index = 0;
    }

    public int size() {

        return index;
    }

    T elementData (int index) {
        return (T) data[index];
    }

    public T get(int indexOfElement) {

        if (indexOfElement < 0 || indexOfElement > index) {
            System.out.println("\"Index is out of bound\" = " + "Index is out of bound");
            return elementData(index);
        } else {
            return elementData(indexOfElement);
        }
    }

    private void reduceSizeIfNeed() {
        //Если после удаления множества елементов массива его размер превышает больше чем в два раза его заполненость, уменьшаем размер массива
        if ((index * 10) <= (data.length)) {
            int newArraySize = 0;

            if (index < 5) {

                newArraySize = ARRAY_SIZE;

            } else {

                newArraySize = data.length / 2;

            }

            System.out.println("Resize index = " + index + ", new size = " + newArraySize);
            Object[] newArray = new Object[newArraySize];
            System.arraycopy(data, 0, newArray, 0, index);
            data = newArray;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (int i = 0; i < index; i++) {
            stringJoiner.add(data[i].toString());
        }
        return "[" + stringJoiner.toString() + "]";
    }
}