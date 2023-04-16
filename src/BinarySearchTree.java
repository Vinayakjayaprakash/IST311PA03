import java.util.ArrayList;

public class BinarySearchTree {
    Node<Album> root;

    public BinarySearchTree() {

        root = null;
    }

    public Node<Album> insert(Node<Album> current, Album album1) {
        if (current != null) {
            if (current.album.compareTo(album1) > 0)
                current.leftChild = insert(current.leftChild, album1);
            else if (current.album.compareTo(album1) < 0)
                current.rightChild = insert(current.rightChild, album1);
        } else {
            current = new Node<>(album1);
        }


        return current;
    }

    public Node<Album> insert(Album album1) {
        this.root = insert(this.root, album1);
        return this.root;
    }

    public Node<Album> contains(Node<Album> current, Album album1) {
        if (current != null) {
            if (current.album.compareTo(album1) == 0)
                return current;
            else if (current.album.compareTo(album1) < 0) {
                current.rightChild = contains(current.rightChild, album1);
            } else if (current.album.compareTo(album1) > 0) {
                current.leftChild = contains(current.leftChild, album1);
            }
        }
        return current;
    }

    public boolean contains(Album album1) {
        return contains(this.root, album1) != null;
    }


    public Node<Album> delete(Node<Album> current, Album album1) {

        IllegalArgumentException IAe = new IllegalArgumentException();
        if (current == null) {
            throw IAe;
        }
        if (current.album.compareTo(album1) == 0) {
            if (current.leftChild == null) { //checks if left or right subtrees are already null
                return current.rightChild;
            } else if (current.rightChild == null) {
                return current.leftChild;
            } else {
                current.album = findMin(current.rightChild); //finds the minimum value in the right subtree and deletes it
                current.rightChild = delete(current.rightChild, current.album); //recursively deletes that value
            }
        } else if (current.album.compareTo(album1) < 0) {
            current.rightChild = delete(current.rightChild, album1);
        } else {
            current.leftChild = delete(current.leftChild, album1);
        }
        return current;
    }

    private Album findMin(Node<Album> current) {
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current.album;
    }

    public Node<Album> delete(Album album1) {
        this.root = delete(this.root, album1);
        return this.root;
    }

    public Node<Album> buildTree(ArrayList<Node> inorder) {
        if (inorder.isEmpty()) {
            return null; // Base case: empty list
        }

        int start = 0;
        int end = inorder.size() - 1;
        int mid = (start + end) / 2; //midpoint
        Node<Album> root = inorder.get(mid);
        BinarySearchTree balanced = new BinarySearchTree();
        balanced.insert(root.album);

        Node<Album> leftInorder = buildTree(new ArrayList<>(inorder.subList(0, mid)));
        Node<Album> rightInorder = buildTree(new ArrayList<>(inorder.subList(mid + 1, inorder.size())));

        balanced.root.leftChild = leftInorder;
        balanced.root.rightChild = rightInorder;

        return balanced.root;
    }

    public ArrayList<Node> getNodes() {
        ArrayList<Node> inorder = new ArrayList<>();
        getNodesHelper(this.root, inorder);
        return inorder;
    }

    private void getNodesHelper(Node<Album> current, ArrayList<Node> inorder) {
        if (current != null) {
            getNodesHelper(current.leftChild, inorder);
            inorder.add(current);
            getNodesHelper(current.rightChild, inorder);
        }
    }
    public Node<Album>  rebalance(){
        ArrayList<Node> inorder = new ArrayList<Node>();
        inorder = getNodes();
        Node<Album> balanced = buildTree(inorder);
        return balanced;
    }

    public ArrayList<Album> partition(Node<Album> current, Album album1) {
        ArrayList<Album> result = new ArrayList<>();
        if (current != null) {
            result.addAll(this.partition(current.leftChild, album1));
            if (current.album.albumID >= album1.albumID) {
                result.add(current.album);
            }
            result.addAll(this.partition(current.rightChild, album1));
        }
        return result;
    }

    public ArrayList<Album> partition(Album album1) {
        return this.partition(this.root, album1);
    }
}

