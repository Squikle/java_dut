package com.company;

import java.util.Iterator;

public class MyArrayList<T> implements Collection<T>{
    private Object[] elements;
    private int size = 0;

    MyArrayList(){
        elements = new Object[16];
    }

    MyArrayList(int capacity){
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean removeLast() {
        if(size > 0){
            size--;
            return true;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
        private int cursor = -1;

        @Override
        public boolean hasNext() {
            return cursor!= size-1;
        }

        @Override
        public T next() {
            cursor++;
            return (T)elements[cursor];
        }

        @Override
        public void remove(){
            MyArrayList.this.remove(cursor);
        }
    }

    @Override
    public void add(Object element) {
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    private void ensureCapacity(){
        if(size == elements.length){
            Object[] temp = new Object[elements.length*2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
    }

    @Override
    public boolean remove(Object element) {
        return remove(indexOf(element));
    }

    public boolean remove(int index) {
        if(!checkIndex(index)){
            return false;
        }

        Object[] tempElements = new Object[elements.length];

        if (index >= 0)
            System.arraycopy(elements, 0, tempElements, 0, index);
        if (size - 1 - index >= 0)
            System.arraycopy(elements, index + 1, tempElements, index, size - 1 - index);

        elements = tempElements;
        size--;

        return true;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i]))
                return i;
        }
        return -1;
    }

    private boolean checkIndex(int index) {
        return index <= size - 1 && index >= 0;
    }
}