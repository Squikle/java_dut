package com.company;

import java.util.Iterator;

public class LinkedList<T> implements Collection<T> {
    private Node<T> rootNode;
    private int size;

    private static class Node<T>
    {
        T data;
        Node<T> nextNode;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T data)
    {
        Node<T> newNode = new Node<>(data);

        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            getTailNode().nextNode = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(T element)
    {
        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            if (element.equals(iterator.next())) {
                iterator.remove();
                size -= 1;

                return true;
            }
        }

        return false;
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

    private Node<T> getTailNode()
    {
        Node<T> tempNode = rootNode;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }

        return tempNode;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T>
    {
        Node<T> previousNode = null;
        Node<T> cursorNode = null;

        @Override
        public boolean hasNext() {
            if (cursorNode == null) {
                return rootNode != null;
            }
            else {
                return cursorNode.nextNode != null;
            }
        }

        @Override
        public T next()
        {
            if (cursorNode == null) {
                cursorNode = rootNode;
            }
            else {
                previousNode = cursorNode;
                cursorNode = cursorNode.nextNode;
            }

            return cursorNode.data;
        }

        @Override
        public void remove()
        {
            if (previousNode == null) {
                rootNode = rootNode.nextNode;
            }
            else {
                previousNode.nextNode = cursorNode.nextNode;
            }
        }
    }
}
