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
    public void testAddAndSize() {
        bst.insert(1);
        assertFalse(bst.isEmpty());
        assertEquals(1, bst.size());

//        bst.insert(2);
//        assertEquals(2, bst.size());
    }
}
