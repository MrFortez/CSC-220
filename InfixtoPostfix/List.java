/* ***************************************************
 * Brandon Fortes
 * October 22, 2024
 * List.java
 *
 * A file with two classes, a Node class and a List class, that make a Linked List,
 * 	with the List class containing several methods for manipulating the list.
 *************************************************** */

// the Node class
class Node<T>
{
	private T data;
	private Node link;

	// constructor
	public Node()
	{
		this.data = null;
		this.link = null;
	}

	// accessor and mutator for the data component
	public T getData()
	{
		return this.data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	// accessor and mutator for the link component
	public Node getLink()
	{
		return this.link;
	}

	public void setLink(Node link)
	{
		this.link = link;
	}
}

// the List class
public class List<T>
{
	public static final int MAX_SIZE = 1024;

	private Node<T> head;
	private Node<T> tail;
	private Node<T> curr;
	private int num_items;

	// constructor
	// remember that an empty list has a "size" of 0 and its "position" is at -1
	public List() {
		head = null;
		tail = null;
		curr = null;
		num_items = 0;
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l) {
		
		Node temp = l.head;
		// this.head = new Node();
		// this.head.setData(l.head.getData());
		// this.curr = this.head;
		// this.num_items++;
		while (temp != null) {
		// 	this.curr.setLink(new Node());
		// 	this.curr = this.curr.getLink();
			this.InsertAfter((T)temp.getData());
			temp = temp.getLink();
			
		// 	this.curr.setData(temp.getData());
		// 	this.num_items++;
		}
		this.tail = curr;
	}

	// navigates to the beginning of the list
	public void First() {
		curr = head;
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last() {
		curr = tail;
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos) {
		if (!IsEmpty() && pos >= 0 && pos < num_items) {
			curr = head;
			for (int i = 0; i < pos; i++) {
				curr = curr.getLink();
			}
		}
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev() {
		if (!IsEmpty() && !curr.equals(head)) {
			Node temp = head;
			while (!temp.getLink().equals(curr)) {
				temp = temp.getLink();
			}
			curr = temp;
		}
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next() {
		if ((!IsEmpty()) && (curr.getLink() != null)) {
			curr = curr.getLink();
		}
	}

	// returns the location of the current element (or -1)
	public int GetPos() {
		if (IsEmpty()) {
			return -1;
		}
		int index = 0;
		Node temp = head;
		while (!temp.equals(curr)) {
			temp = temp.getLink();
			index++;
		}
		return index;
	}

	// returns the value of the current element (or -1)
	public T GetValue() {
		if (!IsEmpty()) {
			return curr.getData();
		}
		return null;
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize() {
		return num_items;
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(T data) {
		if (!IsFull()) {
			if (IsEmpty()) {
				head = new Node<T>();
				head.setData(data);
				curr = head;
				tail = head;
				num_items = 1;
			}
			else if (curr.equals(head)) {
				Node<T> temp = new Node<T>();
				temp.setData(data);
				temp.setLink(head);
				head = temp;
				Prev();
				num_items++;
			}
			else {
				Node<T> temp = new Node<T>();
				temp.setData(data);
				temp.setLink(curr);
				Prev();
				curr.setLink(temp);
				Next();
				num_items++;
			}
		}
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(T data) {
		
		if (!IsFull()) {
			if (IsEmpty()) {
				InsertBefore(data);
			}
			else if (curr.equals(tail)) {
				Node<T> temp = new Node<T>();
				temp.setData(data);
				tail.setLink(temp);
				tail = temp;
				Next();
				num_items++;
			}
			else {
				Node<T> temp = new Node<T>();
				temp.setData(data);
				temp.setLink(curr.getLink());
				curr.setLink(temp);
				Next();
				num_items++;
			}
		}
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list. If possible,
	// following element becomes new current element.
	public void Remove() {
		if (!IsEmpty()) {
			if (curr.equals(head)) {
				head = head.getLink();
				Next();
			}
			else if (curr.equals(tail)) {
				Prev();
				tail = curr;
				tail.setLink(null);
			}
			else {
				Prev();
				curr.setLink(curr.getLink().getLink());
				Next();
			}
			num_items--;
		}
		
	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(T data) {
		if (!IsEmpty()) {
			curr.setData(data);
		}
	}

	// returns if the list is empty
	public boolean IsEmpty() {
		return num_items <= 0;
	}

	// returns if the list is full
	public boolean IsFull() {
		return num_items >= MAX_SIZE;
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l) {
		if (this.GetSize() != l.GetSize()) {
			return false;
		}
		Node tempL = l.head;
		Node tempThis = this.head;
		while (tempThis != null) {
			if (!(tempL.getData().equals(tempThis.getData()))) {
				return false;
			}
			tempL = tempL.getLink();
			tempThis = tempThis.getLink();
		}
		return true;
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l) {
		List result = new List(this);

		if (!l.IsEmpty()) {
			for (Node temp = l.head; temp != null; temp = temp.getLink()) {
				result.InsertAfter(temp.getData());
			}
		}
		return result;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString() {
		if (IsEmpty()) {
			return "NULL";
		}
		String result = "";
		for (Node temp = head; temp != null; temp = temp.getLink()) {
			result += temp.getData() + " ";
		}
		return result;
	}
}
