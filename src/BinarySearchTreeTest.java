
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BinarySearchTree tree = new BinarySearchTree();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        // Test inserting into an empty tree
        tree.insert(album1);
        assertEquals(album1, tree.root.album);
        tree.insert(album2);
        assertEquals(album2, tree.root.leftChild.album);

        // Test inserting into the right child of the root
        tree.insert(album3);
        assertEquals(album3, tree.root.rightChild.album);
    }
    @Test
    public void testDeletePos() {
        BinarySearchTree tree = new BinarySearchTree();

        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        tree.insert(album1);
        tree.insert(album2);
        tree.insert(album3);
        Node<Album> deletedNode = tree.deletePos(1); //deleted node at position 2 (album2)
        assertEquals(album2, deletedNode.album);
        //assertEquals(1,tree.getIndex(album3));
        Node<Album> deletedNode2 = tree.deletePos(1);//deleted node at position 1 (album3) which is now at position 1
        assertEquals(album3, deletedNode2.album);

        try{
            Node<Album> deletedNode3 = tree.deletePos(2);
            fail("Expected error to be thrown");
        }

        catch( IllegalArgumentException e){

        }


    }

}