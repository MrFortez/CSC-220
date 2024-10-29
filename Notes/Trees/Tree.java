class Tree {
    public static void main(String[] args) {
        Node root = new Node('A');

        // Create Left Subtree
        root.setLeftLink(new Node('B'));
        root.getLeftLink().setLeftLink(new Node('D'));
        root.getLeftLink().setRightLink(new Node('E'));
        root.getLeftLink().getLeftLink().setRightLink(new Node('G'));

        // Create Right Subtree
        root.setRightLink(new Node('C'));
        root.getRightLink().setRightLink(new Node('F'));
        root.getRightLink().getRightLink().setLeftLink(new Node('H'));

        inOrder(root);
        System.out.println();
        
        preOrder(root);
        System.out.println();
        
        postOrder(root);
        System.out.println();

    }

    public static void inOrder(Node temp) {
        if (temp == null) {
            return;
        }

        inOrder(temp.getLeftLink());
        System.out.print(temp);
        inOrder(temp.getRightLink());
    }

    public static void preOrder(Node temp) {
        if (temp == null) {
            return;
        }

        System.out.print(temp);
        preOrder(temp.getLeftLink());
        preOrder(temp.getRightLink());
    }

    public static void postOrder(Node temp) {
        if (temp == null) {
            return;
        }

        postOrder(temp.getLeftLink());
        postOrder(temp.getRightLink());
        System.out.print(temp);
    }
}
