	import static org.junit.Assert.assertEquals;
	import org.junit.jupiter.api.Test;


class DAG_LCATest2 {

		@Test
		final void nullTree() {
			LCA tree = new LCA();
			assertEquals("Check null tree", -1, tree.findLCA(1,1));        
		}
		@Test
		final void twoRoots() {
			LCA tree = new LCA();
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.right.left = tree.root.left.left;
			tree.root.right.right =  new Node(5);
			tree.root.left.right = new Node(6);
			assertEquals("expect the first root", 2, tree.findLCA(4,6));        
			assertEquals("expect the second root", 3, tree.findLCA(4,5));    
		}
		
}
