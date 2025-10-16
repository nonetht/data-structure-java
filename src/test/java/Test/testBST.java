package Test;

import Tree.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit test for BST class
 */
public class testBST {

    private BST<Integer> bst;

    // @BeforeEach: 表示执行每一个@Test方法之前，都会先执行该方法
    // 确保了每个测试均是在全新独立的环境下进行的
    @BeforeEach
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void testNewBSTIsEmpty() {
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.size());
    }

    @Test
    public void testInsertAndSize() {
        bst.insert(1);
        assertFalse(bst.isEmpty());
        assertEquals(1, bst.size());

        bst.insert(2);
        assertEquals(2, bst.size());
        bst.insert(3);
        assertEquals(3, bst.size());
    }

    @Test
    public void testInsertAndContains() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        assertTrue(bst.contains(1));
        assertTrue(bst.contains(2));
        assertTrue(bst.contains(3));
        assertFalse(bst.contains(4));
    }

    @Test
    public void testInsertAndFindMax() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        assertEquals(3, bst.findMax());
    }

    @Test
    public void testInsertAndFindMin() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        assertEquals(1, bst.findMin());
    }
}
