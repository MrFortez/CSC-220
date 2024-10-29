/* ***************************************************
 * Brandon Fortes
 * October 28, 2024
 * Queue.java
 *
 * A file with a Queue class with several functions for interacting
 *  with the queue.
 *************************************************** */

public class Queue<T> {
    List<T> list;

    // Creates a new Queue object with an empty queue.
    public Queue() {
        list = new List<T>();
    }

    // Creates a new Queue with data copied from another Queue.
    public Queue(Queue other) {
        list = new List<T>(other.list);
    }

    // Adds a new item to the back of the Queue.
    public void Enqueue(T data) {
        list.Last();
        list.InsertAfter(data);
    }

    // Removes an item from the front of the Queue and returns it.
    public T Dequeue() {
        list.First();
        T data = list.GetValue();
        list.Remove();
        return data;
    }

    // Returns the item at the front of the Queue without removing it.
    public T Peek() {
        list.First();
        return list.GetValue();
    }
    
    // Returns the number of items in the Queue.
    public int Size() {
        return list.GetSize();
    }

    // Returns whether or not the Queue is empty.
    public boolean IsEmpty() {
        return list.IsEmpty();
    }

    // Returns whether or not the Queue is full.
    public boolean IsFull() {
        return list.IsFull();
    }

    // Returns whether or not two Queues have the exact same items and order.
    public boolean Equals(Queue other) {
        return this.list.Equals(other.list);
    }

    // Returns a new Queue with this and another Queue concatenated.
    public Queue Add(Queue other) {
        Queue result = new Queue(this);
        result.list = result.list.Add(other.list);
        return result;
    }
    
    // Prints out the items in the Queue in order.
    public String toString() {
        return list.toString();
    }
    
}
