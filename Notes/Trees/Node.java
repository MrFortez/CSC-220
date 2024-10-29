class Node {
    private char data;
    private Node left;
    private Node right;

    public Node() {
        data = ' ';
        left = right = null;
    }

    public Node(char data) {
        this.data = data;
        this.left = this.right = null;
    }

    public void setLeftLink(Node link) {
        this.left = link;
    }

    public void setRightLink(Node link) {
        this.right = link;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeftLink() {
        return left;
    }
    
    public Node getRightLink() {
        return right;
    }

    public char getData() {
        return data;
    }

    public String toString() {
        return data + "->";
    }
}

