public class Node <Album>{
    Album album; //Means that the data can be of any type
    Node <Album> leftChild; //Acts as a point to the next node
    Node <Album> rightChild; //Acts as a point to the previous node

    public Node(Album album){
        this.album = album;
        this.leftChild = null;
        this.rightChild = null;


    }
}

