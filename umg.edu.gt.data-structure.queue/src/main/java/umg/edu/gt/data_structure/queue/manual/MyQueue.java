package umg.edu.gt.data_structure.queue.manual;

import java.util.NoSuchElementException; 

public class MyQueue<T> {
    private Node<T> head; 
    private Node<T> tail; 
    private int size;     

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    
    public void enqueue(T item) {
        Node<T> newNode = new Node<T>(item);
        if (isEmpty()) {
          
            head = newNode;
            tail = newNode;
        } else {
          
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

  
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Error: No puedes hacer dequeue en una cola vacía.");
        }
        
        T item = head.data; 
        head = head.next;   
        
        if (head == null) {
            tail = null;
        }
        
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Error: La cola está vacía.");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
