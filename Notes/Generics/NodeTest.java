class Node<T> {
    private T data;
    private Node link;

    public Node() {
        data = null;
        link = null;
    }

    public Node(T data, Node link) {
        this.data = data;
        this.link = link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return data + "->";
    }
}

class NodeTest {
    public static void main(String[] args) {
        Node a<Integer> = new Node<Integer>();
        Node b<Integer> = new Node<Integer>();
    }
}