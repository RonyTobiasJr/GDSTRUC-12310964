public class Tree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        }
    }

    public void traverseInOrderDescending() {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }

    public Node get(int value) {
        if (root == null) {
            return null;
        }
        return root.get(value);
    }

    public Node getMin() {
        if (root == null) return null;
        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    public Node getMax() {
        if (root == null) return null;
        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }
}
