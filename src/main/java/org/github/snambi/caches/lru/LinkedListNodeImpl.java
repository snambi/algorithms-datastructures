package org.github.snambi.caches.lru;

public class LinkedListNodeImpl<T> implements LinkedListNode<T>{

    private T value;
    private DoublyLinkedList list;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;

    public LinkedListNodeImpl( T value, DoublyLinkedList list){
        this.value = value;
        this.list = list;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getElement() {
        return this.value;
    }

    @Override
    public void detach() {
        this.getPrev().setNext( this.getNext());
        this.getNext().setPrev( this.getPrev());
    }

    @Override
    public LinkedListNode<T> setPrev(LinkedListNode<T> prev) {
        if( prev != null ) {
            this.prev = prev;
        }
        return this.prev;
    }

    @Override
    public LinkedListNode<T> setNext(LinkedListNode<T> next) {
       if( next != null ){
           this.next = next;
       }
       return this.next;
    }

    @Override
    public LinkedListNode<T> getPrev() {
        return this.prev;
    }

    @Override
    public LinkedListNode<T> getNext() {
        return this.next;
    }

    @Override
    public LinkedListNode<T> search(T input) {
        return this.getElement() == input ? this : this.next.search(input);
    }
}
