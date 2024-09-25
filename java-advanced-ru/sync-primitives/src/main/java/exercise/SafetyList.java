package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int size;
    private int[] elements;

    public SafetyList(int initialCapacity) {
        this.elements = new int[initialCapacity];
        size = initialCapacity;
    }

    public SafetyList() {
        this(0);
    }

    public synchronized boolean add(int element) {
        elements = Arrays.copyOf(elements, size + 1);
        elements[size++] = element;
        return true;
    }

    public int get(int index) {
        return elements[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
