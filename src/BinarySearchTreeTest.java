
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
    @Test
    public void testDeleteRightLeaf() {
        // Create test data
        Album album1 = new Album(1, "Test Album 1", 12);
        Album album2 = new Album(2, "Test Album 2", 21);
        Album album3 = new Album(3, "Test Album 3", 6);

        // Insert test data into BST
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);
        bst.delete(album2); //deletes the value of 21 which returns back null (process of deleting a right leaf node)
        try {
            int id = bst.root.rightChild.album.numberOfSongs;
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // expected exception
        }
        assertEquals(6,bst.root.leftChild.album.numberOfSongs);
    }

    @Test
    public void testDeleteRoot() {
        // Create test data
        Album album1 = new Album(1, "Test Album 1", 12);
        Album album2 = new Album(2, "Test Album 2", 21);
        Album album3 = new Album(3, "Test Album 3", 6);

        // Insert test data into BST
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);
        bst.delete(album1); //deletes the root of 12 right should be null
        try {
            int id = bst.root.rightChild.album.numberOfSongs;
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // expected exception
        }
        assertEquals(6,bst.root.leftChild.album.numberOfSongs);
    }

    @Test
    public void testPartition() {

        Album album1 = new Album(1, "Test Album 1", 12);
        Album album2 = new Album(2, "Test Album 2", 21);
        Album album3 = new Album(3, "Test Album 3", 6);
        Album album4 = new Album(4, "Test Album 4", 18);
        Album album5 = new Album(5, "Test Album 5", 9);
        Album album6 = new Album(6, "Test Album 6", 14);


        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);
        bst.insert(album4);
        bst.insert(album5);
        bst.insert(album6);

        // Test partition method
        ArrayList<Album> partitionedAlbums =  bst.partition(album2);
        // Check that the partitioned albums are correct
        assertEquals(5, partitionedAlbums.size());
        assertEquals(album3, partitionedAlbums.get(0));
        assertEquals(album4, partitionedAlbums.get(1));
    }

    @Test
    public void testRebalance() {}

}