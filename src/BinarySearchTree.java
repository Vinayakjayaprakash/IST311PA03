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
    public Node<Album> deletePos(int delposition) {
        IllegalArgumentException IAe = new IllegalArgumentException();
        if (delposition < 0) {
            throw IAe;
        }
        Node<Album> toDelete;
        if (root == null) {
            throw IAe;
        } else if (delposition == 0) {
            toDelete = root;
            root = root.leftChild;
            if (root != null) {
                root.rightChild = null;
            }
        } else {
            Node<Album> current = root;
            int pos = 0;
            while (pos < delposition - 1 && current.leftChild != null) {
                current = current.rightChild;
                pos++;
            }
            if (current.leftChild == null) {
                throw IAe;
            }
            toDelete = current.rightChild;
            current.leftChild = toDelete.rightChild;
            if (toDelete.leftChild != null) {
                current.leftChild.rightChild = current;
            }
        }
        toDelete.leftChild = null;
        toDelete.rightChild = null;
        return toDelete;
    }

}
