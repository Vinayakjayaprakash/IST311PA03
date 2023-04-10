public class BinarySearchTree {
    Node<Album> root;

    public BinarySearchTree() {

        root = null;
    }

    public void insert(Node<Album> current, Album album1) {
        if (current.album.compareTo(album1) > 0) {
            if (current.leftChild != null) {
                insert(current.leftChild, album1);
            } else {
                current.leftChild = new Node<>(album1);
            }
        } else if (current.album.compareTo(album1) < 0) {
            if (current.rightChild != null) {
                insert(current.rightChild, album1);
            } else {
                current.rightChild = new Node<>(album1);
            }
        }
    }

    public Node<Album> insert(Album album1) {
        if (root == null) {
            root = new Node<>(album1);
        } else {
            insert(root, album1);
        }
        return root;
    }


}
