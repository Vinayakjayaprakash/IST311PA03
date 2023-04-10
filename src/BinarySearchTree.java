public class BinarySearchTree {
Node <Album> root ;

public BinarySearchTree(){

    root = null;
}
public void insert(Node<Album> current,Album album1){

if(current!=null){
    if(current.album.compareTo(album1)>0){

        current = current.leftChild;
    } else if (current.album.compareTo(album1)<0){
        current = current.rightChild;
        insert(current, album1);
    }



} else {

    current = new Node<>(album1);
}
}

    public Node<Album> insert (Album album1){
    Node<Album> insertNode = new Node<>(album1);
    insert(this.root,album1);
return this.root;
    }

}
