package datastructures;

public class DynamicArray<String> {

    private int size;
    private int capacity;
    private Object[] data;

    public DynamicArray(int inputCapacity){
        capacity = inputCapacity;
        data = new Object[capacity];
        size = 0;
    }

    public String get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        } else if (index >= capacity) {
            throw new IndexOutOfBoundsException("Index beyond upper bound");
        }
        return (String)data[index];
    }

    public void set(int index, String val){
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        }

        if (index >= size) {
            size = index + 1;
            while (size > capacity) {
                resize();
            }
        }
        data[index] = val;
    }

    public void insert(int index, String val) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        }

        if (size == capacity) {
            resize();
        }
        if (index < size) {
            for ( int i = size; i > index; i-- ) {
                data[i] = data[i - 1];
            }
            data[index] = val;
            size += 1;
        } else {
            set(index, val);
        }
    }

    public void add(String val) {
        if (size == capacity) {
            resize();
        }
        data[size] = val;
        size += 1;
    }

    public void delete(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        } else if (index >= capacity) {
            throw new IndexOutOfBoundsException("Index beyond upper bound");
        }

        for ( int i = index; i + 1 < size; i++ ) {
            data[i] = (String) data[i + 1];
        }
        data[size - 1] = null;
        size -= 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean Contains(String target) {
        for ( int i = 0; i < size; i++ ) {
            if ( data[i] == target ) {
                return true;
            }
        }
        return false;
    }

    public void resize() {
        Object[] newdata = new Object[capacity * 2];
        for ( int i = 0; i < capacity; i++ ) {
            newdata[i] = data[i];
        }
        data = newdata;
        capacity *= 2;
    }

    public int size() {
        return size;
    }
}