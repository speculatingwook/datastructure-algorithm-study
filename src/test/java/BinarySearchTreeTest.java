import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.speculatingwook.binary_tree.BinarySearchTree;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
    }

    @Test
    void testInsert() {
        assertEquals(List.of(5, 3, 1, 7, 9), bst.preorderTraversal());
    }

    @Test
    void testSearch() {
        assertTrue(bst.search(5));
        assertTrue(bst.search(1));
        assertTrue(bst.search(9));
        assertFalse(bst.search(4));
        assertFalse(bst.search(6));
    }

    @Test
    void testDelete() {
        bst.delete(3);
        assertEquals(List.of(5, 1, 7, 9), bst.preorderTraversal());

        bst.delete(5);
        assertEquals(List.of(7, 1, 9), bst.preorderTraversal());
    }

    @Test
    void testEmptyTree() {
        BinarySearchTree emptyBst = new BinarySearchTree();
        assertTrue(emptyBst.isEmpty());
        assertEquals(0, emptyBst.getSize());
        assertEquals(0, emptyBst.getHeight());
    }
}