/* ***************************************************************************
 * <your name>
 * <the date>
 * <the file name>
 *
 * <a simple, short program/class description>
 * **************************************************************************/
class Tree
{
    private Node root;
    private int size;
    public static final int MAX_SIZE = 30;

    // Constructor. An empty tree has a size of 0.
    public Tree()
    {
    }

    // Copy constructor. Clones Tree t (i.e. its nodes, and its size)
    public Tree(Tree t)
    {
    }

    // Private copy function that recursively copies Node a (along with
    // all its links, and returns that copy.
    private Node mycopy(Node a)
    {
    }

    // function that takes the key and calls the deleteKey function.
    // Should only work if the tree is not empty.
    public void Delete(int key)
    {
    }

    // private recursive function that takes a node, and the key to delete from
    // the subtrees attached to that node. It returns a copy of the tree
    // with the required node having been removed from the appropriate subtrees.
    private Node DeleteKey(Node a, int key)
    {
    }

    // Private function to find the successor to a node. The successor
    // of a node in a binary tree is the node immediately larger than
    // the required node.
    private Node Successor(Node a)
    {
    }


    // Function to insert data into the tree in its appropriate location
    // by using the Add() recursive function. This should not be
    // possible for a tree that is already full. If the tree is empty,
    // then it does the insertion itself.
    public void Insert(int data)
    {
    }

    // Private recursive function that takes a Node attached to its own 
    // subtrees, and attaches the data to the tree in the proper location.
    private void Add(int data, Node a)
    {
    }

    // function to return the size of the tree (i.e. the number of nodes
    // in the tree).
    public int Size()
    {
    }

    // Function to tell whether the tree is empty or not.
    public boolean IsEmpty()
    {
    }

    // Function to tell whether the tree is full or not.
    public boolean IsFull()
    {
    }

    // Function to return the InOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the inorder traversal of the tree.
    private String InOrder(Node a, String s)
    {
    }

    // Function to return the PreOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the preorder traversal of the tree.
    private String PreOrder(Node a, String s)
    {
    }

    // Function to return the PostOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the postorder traversal of the tree.
    private String PostOrder(Node a, String s)
    {
    }

    // A function that returns the maximum value in the tree. That value
    // is -1 for an empty tree.
    public int getMax()
    {
    }

    // A function that returns the minimum value in the tree. That value
    // is -1 for an empty tree.
    public int getMin()
    {
    }

    // A toString function that returns "NULL" if the tree is empty.
    // Otherwise, it returns the InOrder traversal of the tree.
    public String toString()
    {
    }

    // A Print function that prints out the InOrder, PreOrder, and
    // PostOrder traversals of the tree (each one preceeded by the word
    // identifying what kind of traversal it is). It also calls the
    // private Print() function which prints out the tree sideways.
    public void Print()
    {
    }

    // A Print function that takes a node and an int to recursively print
    // out the tree sideways. The int "lev" determines how far away from
    // the root that particular node will be printed. (Refer to notes for 
    // details of this function).
    private void Print(Node n, int lev)
    {
    }

    // A function that returns if two trees are equal by value.
    public boolean Equals(Tree t)
    {
    }
}
