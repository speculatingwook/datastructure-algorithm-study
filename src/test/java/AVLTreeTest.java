import org.junit.jupiter.api.Test;
import org.speculatingwook.avl_tree.AVLTree;

public class AVLTreeTest {
    @Test
    void testAVLInsertion() {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Left Left Case Test
        avlTree.insert(30);
        avlTree.insert(20);
        avlTree.insert(10);

        // Right Right Case Test
        AVLTree<Integer> avlTree2 = new AVLTree<>();
        avlTree2.insert(10);
        avlTree2.insert(20);
        avlTree2.insert(30);

        // Left Right Case Test
        AVLTree<Integer> avlTree3 = new AVLTree<>();
        avlTree3.insert(30);
        avlTree3.insert(10);
        avlTree3.insert(20);
    }
}