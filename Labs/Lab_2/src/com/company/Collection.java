package com.company;

public interface Collection<T> extends Iterable<T> {
    public void add(T data);
    public boolean remove(T data);
    public int size();
    public boolean contains(T data);
}
