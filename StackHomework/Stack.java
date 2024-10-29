/* ***************************************************
 * Brandon Fortes
 * October 28, 2024
 * Stack.java
 *
 * A file with a Stack class with several functions for interacting
 *  with the stack.
 *************************************************** */

 public class Stack<T> {
    List<T> list;

    // Creates a new Stack object with an empty stack
    public Stack() {
        list = new List<T>();
    }

    // Creates a new stack with data copied from another stack
    public Stack(Stack other) {
        list = new List<T>(other.list);
    }

    // Adds a new item to the top of the stack
    public void Push(T data) {
        list.SetPos(0);
        list.InsertBefore(data);
    }

    // Removes an item from the top of the stack and returns it.
    public T Pop() {
        list.SetPos(0);
        T data = list.GetValue();
        list.Remove();
        return data;
    }

    // Returns the item at the top of the stack without removing it.
    public T Peek() {
        list.SetPos(0);
        return list.GetValue();
    }

    // Returns the number of items in the stack.
    public int Size() {
        return list.GetSize();
    }

    // Returns whether or not the stack is empty.
    public boolean IsEmpty() {
        return list.IsEmpty();
    }

    // Returns whether or not the stack is full.
    public boolean IsFull() {
        return list.IsFull();
    }

    // Returns whether or not two stacks have the exact same items and order.
    public boolean Equals(Stack other) {
        return this.list.Equals(other.list);
    }

    // Returns a new stack with this and another stack concatenated.
    public Stack Add(Stack other) {
        Stack result = new Stack(this);
        result.list = result.list.Add(other.list);
        return result;
    }

    // Prints out the items in the stack in order.
    public String toString() {
        return list.toString();
    }
    
}
