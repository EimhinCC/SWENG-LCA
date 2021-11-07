	import static org.junit.Assert.assertEquals;
	import org.junit.jupiter.api.Test;


class DAG_LCATest2 {

		@Test
		final void nullTree() {
			LCA tree = new LCA();
			assertEquals("Check null tree", -1, tree.findLCA(1,1));        
		}
		@Test
		final void twoParents() {
			LCA tree = new LCA();
			tree.root = new Node(1);
			tree.root.addNode(2);
			tree.root.addNode(3);
			tree.root.child[0].addNode(4);
			tree.root.child[0].addNode(5);
			tree.root.child[1].addNode(6);
			tree.root.child[1].linkNode(tree.root.child[0].child[0]);
			assertEquals("expect the first parent of node '4' ", 3, tree.findLCA(4,6));        
			assertEquals("expect the second parent of node '4'", 2, tree.findLCA(4,5));    
	}
		
		@Test
		final void straightLine() {
			LCA tree = new LCA();
			tree.root = new Node(1);
			tree.root.addNode(2);
			tree.root.child[0].addNode(3);
			tree.root.child[0].child[0].addNode(4);
			tree.root.child[0].child[0].child[0].addNode(5);
			tree.root.child[0].child[0].child[0].child[0].addNode(6);
			assertEquals("expect the parent of node '4' ", 3, tree.findLCA(6,4));        
			assertEquals("expect the parent of node '4'", 3, tree.findLCA(4,5));    
		}
		@Test
		final void linkesAtDiffLevels() {
			LCA tree = new LCA();
			tree.root = new Node(1);
			tree.root.addNode(2);
			tree.root.addNode(3);
			tree.root.child[0].addNode(4);
			tree.root.child[0].addNode(5);
			tree.root.child[1].addNode(6);
			tree.root.child[1].child[0].linkNode(tree.root.child[0].child[0]);
			assertEquals("expect the parent of node '4' ", 3, tree.findLCA(6,4));        
    
		}
}
