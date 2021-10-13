import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	final void nullTree() {
		LCA tree = new LCA();
		assertEquals("Check null tree", -1, tree.findLCA(1,1));        
	}
	@Test
	final void nullNodes1() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		assertEquals("Check null node 1", -1, tree.findLCA(1,4));        
	}
	@Test
	final void nullNodes2() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		assertEquals("Check null node 2", -1, tree.findLCA(4,1));        
	}
	@Test
	final void fullLength() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		assertEquals("Only common ancestor is root", 1, tree.findLCA(7,4));        
	}
	@Test
	final void neighbours() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		assertEquals("Neighbouring nodes", 2, tree.findLCA(4,5));        
	}

}
//tree.root = new Node(1);
//tree.root.left = new Node(2);
//tree.root.right = new Node(3);
//tree.root.left.left = new Node(4);
//tree.root.left.right = new Node(5);
//tree.root.right.left = new Node(6);
//tree.root.right.right = new Node(7););