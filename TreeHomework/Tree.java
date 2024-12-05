/* ***************************************************************************
 * Brandon Fortes
 * October 30, 2024
 * Tree.java
 *
 * A class representation of a Binary Search Tree, with various methods to
 *  both modify and display the tree.
 * **************************************************************************/
class Tree
{
    private Node root;
    private int size;
    public static final int MAX_SIZE = 30;

    // Constructor. An empty tree has a size of 0.
    public Tree() {
        root = null;
        size = 0;
    }

    // Copy constructor. Clones Tree t (i.e. its nodes, and its size)
    public Tree(Tree t) {
        this.root = null;
        this.size = t.Size();
        if (!t.IsEmpty()) {
            this.root = mycopy(t.root);
        }
    }

    // Private copy function that recursively copies Node a (along with
    // all its links, and returns that copy.
    private Node mycopy(Node a) {
        if (a == null) {
            return null;
        }

        Node temp = new Node(a.getData());

        temp.setLeft(mycopy(a.getLeft()));
        temp.setRight(mycopy(a.getRight()));

        return temp;
    }

    // function that takes the key and calls the deleteKey function.
    // Should only work if the tree is not empty.
    public void Delete(int key) {
        if (!IsEmpty()) {
            DeleteKey(root, key);
        }
    }

    // private recursive function that takes a node, and the key to delete from
    // the subtrees attached to that node. It returns a copy of the tree
    // with the required node having been removed from the appropriate subtrees.
    private Node DeleteKey(Node a, int key) {

        // If it cant find a node with data key, it is an invalid search,
        // thus just return the tree as it was.
        if (a == null) {
            return root;
        }

        // Navigate to the Node we are deleting
        if (key != a.getData()) {
            return key < a.getData() ? DeleteKey(a.getLeft(), key) : DeleteKey(a.getRight(), key);
        }

        // Account for both leaf and 1 child nodes
        if (a.getLeft() == null) {
            replace(a, a.getRight());
        }
        else if (a.getRight() == null) {
            replace(a, a.getLeft());
        }

        // If the node has two children...
        else {

            // Find its successor.
            Node replacement = Successor(a);

            // If the successor is not the right child of the node to delete, replacec
            // the successor's original position with the successor's original right child.
            // Then, set the successor's right child to the node to delete's right child.
            if (a.getRight() != replacement) {
                replace(replacement, replacement.getRight());
                replacement.setRight(a.getRight());
            }
            
            // Replace the node to delete with its successor.
            replace(a, replacement);
            replacement.setLeft(a.getLeft());
        }

        // Update the size.
        size--; 

        return root;
    }

    // Private function to find the successor to a node. The successor
    // of a node in a binary tree is the node immediately larger than
    // the required node.
    private Node Successor(Node a) {

        // Just return the current node if the current node is also the largest.
        if (a.getData() == getMax()) {
            return a;
        }

        // Temp node used for naviagting the list.
        Node temp = root;

        // Get an in order representation of the list as an array of strings
        String[] treeData = InOrder(root, "").split(" ");

        // The Data stored in the node immediately larger than the required node
        int nextKey = 0;

        // Iterated through the in order array until you find the key of the 
        // required node. Once it is found, store the data of the next node
        // in the nextKey variable, and then leave the loop.
        for (int i = 0; i < treeData.length - 1; i++) {
            if (Integer.parseInt(treeData[i]) == a.getData()) {
                nextKey = Integer.parseInt(treeData[i + 1]);
                break; 
            }
        }

        // Navigate to the node with the data of nextKey
        while (temp.getData() != nextKey) {
            if (temp.getData() <= nextKey) {
                temp = temp.getRight();
            }
            else {
                temp = temp.getLeft();
            }
        }

        return temp;
    }

    // Get the pointer for the parent of the given node.
    private Node getParent(Node child) {
        Node parent = root;

        // If the "child" is the root of the tree, then there is no
        // parent to go to, so we will return null
        if (child == root) {
            parent = null;
        }
        else {

            // Moving down the tree until we find a node with the given
            // child node as one of its nodes.
            while (parent.getLeft() != child && parent.getRight() != child) {

                // if the target child wasnt found in the tree, just
                // default to null as a failsafe.
                if (parent == null) {
                    break;
                }

                if (parent.getData() > child.getData()) {
                    parent = parent.getLeft();
                }
                else {
                    parent = parent.getRight();
                }
            }
        }
        
        return parent;
    }

    // Replace the target node with the replacement node. 
    // This process removes both the target node and all
    // of it's children from the tree.
    private void replace(Node target, Node replacement) {
        Node targetParent = getParent(target);
        if (targetParent == null) {
            root = replacement;
        }
        else if (targetParent.getLeft() == target) {
            targetParent.setLeft(replacement);
        }
        else {
            targetParent.setRight(replacement);
        }
    }


    // Function to insert data into the tree in its appropriate location
    // by using the Add() recursive function. This should not be
    // possible for a tree that is already full. If the tree is empty,
    // then it does the insertion itself.
    public void Insert(int data) {
        if (!IsFull()) {
            if (IsEmpty()) {
                root = new Node(data);
            }
            else {
                Add(data, root);
            }

            size++;
        }
    }

    // Private recursive function that takes a Node attached to its own 
    // subtrees, and attaches the data to the tree in the proper location.
    private void Add(int data, Node a) {
        try {
            Node child = data < a.getData() ? a.getLeft() : a.getRight();
            Add(data, child);
        }

        // If it throws an exception, the correct spot for the new node
        // has been found.
        catch (Exception e) {
            Node newNode = new Node(data);
            if (data < a.getData()) {
                a.setLeft(newNode);
            }
            else {
                a.setRight(newNode);
            }
        }
    }

    // function to return the size of the tree (i.e. the number of nodes
    // in the tree).
    public int Size() {
        return size;
    }

    // Function to tell whether the tree is empty or not.
    public boolean IsEmpty() {
        return root == null ? true : false;
    }

    // Function to tell whether the tree is full or not.
    public boolean IsFull() {
        return size >= MAX_SIZE ? true : false;
    }

    // Function to return the InOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the inorder traversal of the tree.
    private String InOrder(Node a, String s) {
        if (a == null) {
            return s;
        }

        s = InOrder(a.getLeft(), s);
        s += a.getData() + " ";
        s = InOrder(a.getRight(), s);

        
        return s;
    }

    // Function to return the PreOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the preorder traversal of the tree.
    private String PreOrder(Node a, String s) {
        if (a == null) {
            return s;
        }

        s += a.getData() + " ";
        s = PreOrder(a.getLeft(), s);
        s = PreOrder(a.getRight(), s);

        return s;
    }

    // Function to return the PostOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the postorder traversal of the tree.
    private String PostOrder(Node a, String s) {
        if (a == null) {
            return s;
        }

        s = PostOrder(a.getLeft(), s);
        s = PostOrder(a.getRight(), s);
        s += a.getData() + " ";

        return s;
    }

    // A function that returns the maximum value in the tree. That value
    // is -1 for an empty tree.
    public int getMax() {
        Node temp = root;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        } 
        return temp.getData();
    }

    // A function that returns the minimum value in the tree. That value
    // is -1 for an empty tree.
    public int getMin() {
        Node temp = root;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        } 
        return temp.getData();
    }

    // A function that returns if two trees are equal by value.
    public boolean Equals(Tree t) {
        if (this.Size() != t.Size()) {
            return false;
        }
        else if (t.PreOrder(t.root, "").equals(this.PreOrder(this.root, "")) &&
                 t.InOrder(t.root, "").equals(this.InOrder(this.root, ""))) {
                    return true;
                }

        return false;
    }

    // A toString function that returns "NULL" if the tree is empty.
    // Otherwise, it returns the InOrder traversal of the tree.
    public String toString() {
       return IsEmpty() ? "NULL" : InOrder(root, "");
    }

    // A Print function that prints out the InOrder, PreOrder, and
    // PostOrder traversals of the tree (each one preceeded by the word
    // identifying what kind of traversal it is). It also calls the
    // private Print() function which prints out the tree sideways.
    public void Print() {
        System.out.println("InOrder: " + InOrder(root, ""));
        System.out.println("PreOrder: " + PreOrder(root, ""));
        System.out.println("PostOrder: " + PostOrder(root, ""));
        Print(root, 0);
    }

    // A Print function that takes a node and an int to recursively print
    // out the tree sideways. The int "lev" determines how far away from
    // the root that particular node will be printed. (Refer to notes for 
    // details of this function).
    private void Print(Node n, int lev) {
        if (n != null) 
        { 
            Print(n.getRight(), lev+1);     //go down the right subtree and increase 
                                            //the number of tabs i'll have to make
            
            for (int i = 0; i < lev; i++) 
                System.out.print("\t");     //print out the appropriate no. of tabs
            System.out.println(n.getData());//and the data, and move to next line
            
            Print(n.getLeft(), lev+1);      //go down the left subtree and increase 
                                            //tabs
        } 
    }
}
