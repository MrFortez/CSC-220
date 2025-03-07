public class Node {
    private int data;
    private Node link;

    public Node() {
        data = 0;
        link = null;
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public int getData() {
        return data;
    }

    public String toString() {
        return data + "->";
    }
}
