package com.company;

import java.util.Iterator;

public class MyLinkedList<T> implements Collection<T>{
    private Node<T> firstNode;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean removeLast() {
        if(size == 0){
            return false;
        }

        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.remove();
        size--;
        return true;
    }

    @Override
    public boolean remove(T element) {
        Iterator<T> iterator = iterator();
        T obj;
        while (iterator.hasNext()) {
            obj = iterator.next();
            if (element.equals(obj)) {
                iterator.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (firstNode == null)
            firstNode = newNode;
        else {
            getLastNode().next = newNode;
        }
        size++;
    }

    private Node<T> getLastNode() {
        Node<T> tempNode = firstNode;
        while (true) {
            if (tempNode.next == null) {
                return tempNode;
            } else {
                tempNode = tempNode.next;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
        Node<T> prevNode = null;
        Node<T> cursorNode = null;

        @Override
        public boolean hasNext() {
            if (cursorNode == null)
                return firstNode != null;
            else
                return cursorNode.next != null;
        }

        @Override
        public T next() {
            if (cursorNode == null)
                cursorNode = firstNode;
            else {
                prevNode = cursorNode;
                cursorNode = cursorNode.next;
            }
            return cursorNode.data;
        }

        @Override
        public void remove() {
            if (prevNode == null) {
                firstNode = firstNode.next;
            } else
                prevNode.next = cursorNode.next;
        }
    }
}
