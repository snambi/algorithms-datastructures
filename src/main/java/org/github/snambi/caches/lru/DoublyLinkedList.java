package org.github.snambi.caches.lru;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DoublyLinkedList<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    private AtomicInteger size;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private DummyNode dummy = null;

    public DoublyLinkedList(){
        dummy = new DummyNode(this);
        this.clear();
    }

    public void clear(){
        lock.writeLock().lock();
        try{
            head = dummy;
            tail = dummy;
            size = new AtomicInteger(0);
        }finally {
            lock.writeLock().unlock();
        }
    }

    public boolean contains( T value ){
        this.lock.readLock().lock();

        try{
            if( head.search(value).getElement() != null ){
                return true;
            }else{
                return false;
            }
        }finally {
            lock.readLock().unlock();
        }
    }

    public T search(T value){
        lock.readLock().lock();

        try{
            return head.search(value).getElement();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void add( T value ){
        lock.writeLock().lock();

        try{

            LinkedListNode node = new LinkedListNodeImpl(value, this);

            // since this is the latest, this becomes the head
            if( head.isEmpty() ){
                node.setNext(tail);
                tail.setPrev(node);
            }else{
                node.setNext(head);
                head.setPrev(node);
            }

            head = node;
            size.incrementAndGet();

        }finally {
            lock.readLock().unlock();
        }
    }

    public void get( T Value){
        lock.readLock().lock();
    }

    public void evict(){
        lock.writeLock().lock();

        try{
            tail.detach();
        }finally {
            lock.writeLock().unlock();
        }
    }

    public class DummyNode<T> implements LinkedListNode<T>{
        private DoublyLinkedList list = null;

        public DummyNode( DoublyLinkedList<T> list ){
            this.list = list;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public T getElement() {
            return null;
        }

        @Override
        public void detach() {

        }

        @Override
        public LinkedListNode<T> setPrev(LinkedListNode<T> prev) {
            return null;
        }

        @Override
        public LinkedListNode<T> setNext(LinkedListNode<T> next) {
            return null;
        }

        @Override
        public LinkedListNode<T> getPrev() {
            return null;
        }

        @Override
        public LinkedListNode<T> getNext() {
            return null;
        }

        @Override
        public LinkedListNode<T> search(T value) {
            return null;
        }
    }
}
