public class Main {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(25);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(30);
        bst.insert(29);
        bst.insert(26);
        bst.insert(22);
        bst.insert(32);

        bst.inOrderTraverse();

        int value = 100;
        System.out.println("Node with value " + value + " - " + bst.get(value));
    }
}
