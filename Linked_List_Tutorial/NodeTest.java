class NodeTest {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node head = buildBackwards(values);



        // Node n = new Node();
        // System.out.println(n);
        // n.setData(5);
        // System.out.println(n);

        // Node p = new Node();
        // p.setData(10);

        // n.setLink(p);

        // // Same Result
        // p.setData(15);
        // n.getLink().setData(15);

        // p = new Node();
        // n.getLink().setLink(p);

        // p.setLink(new Node());
        // p.getLink().setData(100);

        // printList(head);
        printRList(head);
    }

    public static Node buildBackwards(int[] values) {
        Node head = null, curr;

        int count = values.length;

        while (count > 0) {
            curr = new Node();
            curr.setData(values[count - 1]);
            curr.setLink(head);
            head = curr;

            count--;
        }

        return head;
    }



    public static void printList(Node temp) {
        while (temp != null) {
            System.out.print(temp);
            temp = temp.getLink();
        }
        System.out.println();
    }

    public static void printRList(Node temp) {
        if (temp != null) {
            if (temp.getLink() == null) {
                System.out.print(temp.getData());
            }
            else {
                System.out.print(temp.getData() + " -> ");
                printRList(temp.getLink());
            }
        }
    }

}