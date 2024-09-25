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
        elements = Arrays.copyOf(elements, size + 2);
        elements[size + 1] = element;
        size = size + 1;
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
