public class BinarySearchTree {
    Node<Album> root;

    public BinarySearchTree() {

        root = null;
    }

    public Node<Album> insert(Node<Album> current, Album album1) {
        if(current != null) {
            if (current.album.compareTo(album1) > 0)
                current.leftChild = insert(current.leftChild, album1);
  else if (current.album.compareTo(album1) < 0)
                    current.rightChild = insert(current.rightChild, album1);
            } else {
                current = new Node<>(album1);
            }


        return current;
    }
            public Node<Album> insert(Album album1){
                this.root = insert(this.root, album1);
                return this.root;
            }
    public Node<Album> contains (Node<Album> current, Album album1) {
        if(current != null) {
            if (current.album.compareTo(album1) == 0)
                return current;
            else if(current.album.compareTo(album1)<0){
                current.rightChild = contains(current.rightChild,album1);
            }
            else if(current.album.compareTo(album1)>0){
                current.leftChild = contains(current.leftChild,album1);
            }
        }
        return current;
    }
    public boolean contains(Album album1){
        return contains(this.root, album1) != null;
    }


    public Node<Album> delete (Node<Album> current, Album album1) {

        IllegalArgumentException IAe = new IllegalArgumentException();
        if(current == null) {
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
    public Node<Album> delete(Album album1){
        this.root =  delete(this.root, album1);
        return this.root;
    }

}

