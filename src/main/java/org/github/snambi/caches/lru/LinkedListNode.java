package org.github.snambi.caches.lru;

public interface LinkedListNode<T> {

    boolean isEmpty();

    T getElement();

    void detach();

    LinkedListNode<T> setPrev(LinkedListNode<T> prev );
    LinkedListNode<T> setNext(LinkedListNode<T> next );

    LinkedListNode<T> getPrev();

    LinkedListNode<T> getNext();

    LinkedListNode<T> search( T value);
}
