import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.speculatingwook.binary_tree.BinaryTree;
import org.speculatingwook.binary_tree.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {
    private BinaryTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        tree.setRoot(root);
    }

    @Test
    void testPreorderTraversal() {
        List<Integer> result = tree.preorderTraversal();
        assertEquals(List.of(1, 2, 4, 5, 3), result);
    }

    @Test
    void testInorderTraversal() {
        List<Integer> result = tree.inorderTraversal();
        assertEquals(List.of(4, 2, 5, 1, 3), result);
    }

    @Test
    void testPostorderTraversal() {
        List<Integer> result = tree.postorderTraversal();
        assertEquals(List.of(4, 5, 2, 3, 1), result);
    }

    @Test
    void testLevelOrderTraversal() {
        List<List<Integer>> result = tree.levelOrderTraversal();
        assertEquals(List.of(
                List.of(1),
                List.of(2, 3),
                List.of(4, 5)
        ), result);
    }

    @Test
    void testHeight() {
        assertEquals(3, tree.getHeight());
    }

    @Test
    void testSize() {
        assertEquals(5, tree.getSize());
    }
}