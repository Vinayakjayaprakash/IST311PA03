
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        Album album1 = new Album(1, "Test Album 1", 12);
        album1.artistNames.add("Artist1");
        album1.artistNames.add("Artist2");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(album1);
        assertEquals(12,bst.root.album.numberOfSongs);
        Album album2 = new Album(2, "Test Album 2", 21);
        album1.artistNames.add("Artist3");
        album1.artistNames.add("Artist4");
        bst.insert(album2);
        assertEquals(21,bst.root.rightChild.album.numberOfSongs);
        Album album3 = new Album(3, "Test Album 2", 6);
        album1.artistNames.add("Artist5");
        album1.artistNames.add("Artist6");
        bst.insert(album3);
        assertEquals(6,bst.root.leftChild.album.numberOfSongs);

    }
    @Test
    public void testContains() {
        Album album1 = new Album(1, "Test Album 1", 12);
        album1.artistNames.add("Artist1");
        album1.artistNames.add("Artist2");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(album1);
        assertEquals(12,bst.root.album.numberOfSongs);
        Album album2 = new Album(2, "Test Album 2", 21);
        album1.artistNames.add("Artist3");
        album1.artistNames.add("Artist4");
        bst.insert(album2);
        assertEquals(21,bst.root.rightChild.album.numberOfSongs);
        Album album3 = new Album(3, "Test Album 2", 6);
        album1.artistNames.add("Artist5");
        album1.artistNames.add("Artist6");
        bst.insert(album3);
        assertEquals(6,bst.root.leftChild.album.numberOfSongs);
        bst.contains(album1);
        bst.contains(album2);
        bst.contains(album3);

    }
}