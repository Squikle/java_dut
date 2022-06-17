package com.company;

public interface Collection<T> extends Iterable<T> {
    public void add(T element);
    public boolean remove(T element);
    public int size();
    public boolean removeLast();

    public default boolean contains(T element){
        for(T T : this){
            if (element.equals(T)) {
                return true;
            }
        }
        return false;
    };
}
