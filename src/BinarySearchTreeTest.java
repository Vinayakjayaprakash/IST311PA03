
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BinarySearchTree tree = new BinarySearchTree();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 12);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 21);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 6);
        // Test inserting into an empty tree
        tree.insert(album1);
        assertEquals(12,tree.root.album);
        assertEquals(album1, tree.root.album);
        tree.insert(album2);
        assertEquals(album2, tree.root.leftChild.album);


        tree.insert(album3);
        assertEquals(album3, tree.root.rightChild.album);
    }


}