public class BinarySearchTree {
    Node<Album> root;

    public BinarySearchTree() {

        root = null;
    }

    public Node<Album> insert(Node<Album> current, Album album1) { //finished needs test cases
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
    public Node<Album> contains (Node<Album> current, Album album1) { //finished needs test cases
        if(current != null) {
            if (current.album.compareTo(album1) == 0)  return current;
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
        //not finished yet
     return current;
    }


    public Node<Album> delete(Album album1){
        return delete(this.root, album1);

    }

}

