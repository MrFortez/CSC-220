/* ***************************************************
 * Brandon Fortes
 * September 23, 2024
 * ListTemplate.java
 *
 * <a simple, short program/class description>
 *************************************************** */

// the EasyList class
class List
{
	public static final int MAX_SIZE = 50;

	private int end;	// the index of the last valid item in the list
	private int curr;	// the index of the current item in the list
	private char[] list;	// the list

	// constructor
	// remember that an empty list has a "size" of -1 and its "position" is at -1
	public List() {
		curr = end = -1;
		list = new char[MAX_SIZE];
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l) {
		curr = end = -1;
		list = new char[MAX_SIZE];

		for (int i = 0; i < l.GetSize(); i++) {
			InsertAfter(l.list[i]);
		}
	}

	// navigates to the beginning of the list
	public void First()
	{
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev() {
		if (!IsEmpty()) {
			if (curr > 0) {
				curr--;
			}
		}
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next() {
		if (!IsEmpty()) {
			if (curr < end) {
				curr++;
			}
		}
	}

	// returns the location of the current element (or -1)
	public int GetPos() {
		return curr;
	}

	// returns the value of the current element (or -1)
	public char GetValue() {
		if (!IsEmpty()) {
			return list[curr];
		}
		return ' ';

	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize() {
		return end + 1;
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(char data) {
		if (!IsFull()) {
			if (IsEmpty()) {
				list[0] = data;
				end++;
				curr++;
			}
			else {
				for (int i = end; i >= curr; i--) {
					list[i + 1] = list[i];
				}
				list[curr] = data;
				end++;
			}
		}

	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(char data) {
		if (!IsFull()) {
			if (IsEmpty()) {
				InsertBefore(data);
			}
			else if (curr == end) {
				end++;
				curr++;
				list[curr] = data;
			}
			else {
				Next();
				InsertBefore(data);
			}
				
				
		}
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove() {

	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(char data) {

	}

	// returns if the list is empty
	public boolean IsEmpty() {
		return (end <= -1);
	}

	// returns if the list is full
	public boolean IsFull() {
		return (end >= MAX_SIZE - 1);
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l) {
		return false;
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l) {
		return null;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString() {
		if (IsEmpty()) { 
			return "";	
		}
		else {
			String result = "";
			for (char value : list) {
				result += value + " ";
			}
			return result;
		}
	}
}
