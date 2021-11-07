import static org.junit.Assert.assertEquals;

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
		tree.root.addNode(2);
		tree.root.addNode(3);
		assertEquals("Check missing node 1", -1, tree.findLCA(1,4));        
	}
	@Test
	final void nullNodes2() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.addNode(2);
		tree.root.addNode(3);
		assertEquals("Check missing node 2", -1, tree.findLCA(4,1));        
	}
	@Test
	final void fullLength() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.addNode(2);
		tree.root.addNode(3);
		tree.root.child[0].addNode(4);
		tree.root.child[0].addNode(5);
		tree.root.child[1].addNode(6);
		tree.root.child[1].addNode(7);
		assertEquals("Only common ancestor is root", 1, tree.findLCA(7,4));        
	}
	@Test
	final void neighbours() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.addNode(2);
		tree.root.addNode(3);
		tree.root.child[0].addNode(4);
		tree.root.child[0].addNode(5);
		tree.root.child[1].addNode(6);
		tree.root.child[1].addNode(7);
		assertEquals("Neighbouring nodes", 2, tree.findLCA(4,5));        
	}
	@Test
	final void parent() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.addNode(2);
		tree.root.addNode(3);
		tree.root.child[0].addNode(4);
		tree.root.child[0].addNode(5);
		tree.root.child[1].addNode(6);
		tree.root.child[1].addNode(7);
		assertEquals("Root", 1, tree.findLCA(3,6));        
	}

}
