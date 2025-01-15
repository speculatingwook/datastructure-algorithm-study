import org.junit.jupiter.api.Test;
import org.speculatingwook.red_black_tree.RedBlackTree;

public class RedBlackTreeTest {
    @Test
    void testRedBlackInsertion() {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        rbTree.insert(7);
        rbTree.insert(3);
        rbTree.insert(18);
        rbTree.insert(10);
        rbTree.insert(22);
        rbTree.insert(8);
        rbTree.insert(11);
        rbTree.insert(26);
        rbTree.insert(2);
        rbTree.insert(6);
    }
}