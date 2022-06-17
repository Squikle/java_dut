package com.company;

import java.util.Iterator;

public class ArrayList<T> implements Collection<T> {
    private Object[] array;
    private int size = 0;

    ArrayList(int capacity)
    {
        array = new Object[capacity];
    }

    @Override
    public void add(Object data)
    {
        doubleCapacityIfRequired();
        array[size] = data;
        size++;
    }

    @Override
    public boolean remove(Object data)
    {
        return remove(indexOf(data));
    }

    private int indexOf(Object data)
    {
        for (int i = 0; i < size; i++) {
            if (data.equals(array[i]))
                return i;
        }
        return -1;
    }

    private boolean remove(int index)
    {
        if (!isIndexInBoundary(index)) {
            return false;
        }

        Object[] newArray = new Object[array.length];

        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size - 1 - index);

        array = newArray;
        size--;

        return true;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean contains(T data)
    {
        for(T listData : this) {
            if (data.equals(listData)) {
                return true;
            }
        }

        return false;
    }

    private void doubleCapacityIfRequired()
    {
        if (size == array.length)
        {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            
            array = newArray;
        }
    }

    private boolean isIndexInBoundary(int index)
    {
        return index <= size - 1 && index >= 0;
    }
    
    @Override
    public Iterator<T> iterator()
    {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
        private int cursor = -1;

        @Override
        public T next()
        {
            cursor++;
            return (T)array[cursor];
        }

        @Override
        public void remove()
        {
            ArrayList.this.remove(Math.max(cursor, 0));
        }

        @Override
        public boolean hasNext()
        {
            return cursor != size - 1;
        }
    }
}