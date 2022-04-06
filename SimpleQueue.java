package ru.vsu.cs.volobueva;

public interface SimpleQueue<T> {
    void addElement(T element);
    int count();
    boolean isEmpty();
    T removeElement() throws Exception;
    T getElement() throws Exception;
}
