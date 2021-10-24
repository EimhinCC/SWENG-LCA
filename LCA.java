// Java Program for Lowest Common Ancestor in a Binary Tree
// A O(n) solution to find LCA of two given values n1 and n2
import java.util.ArrayList;
import java.util.List;

// A Binary Tree node
class Node {
	int data;
	Node [] child;
	boolean parent1;
	boolean parent2;


	Node(int value) {
		data = value;
		child = null;
		parent1 = false;
		parent2 = false;
	}
	void addNode(int value) {
		if(child != null) {
			Node [] temp = new Node [child.length + 1];
			for (int i = 0; i < child.length; i++) {
				temp[i] = child[i];
			}
			temp[child.length] = new Node(value);
			return;
		}
		//null case
		else {
			Node temp[] = {new Node(value)};
			child = temp;
		}
	}
	
	void linkNode(Node value) {
		if(child != null) {
			Node [] temp = new Node [child.length + 1];
			for (int i = 0; i < child.length; i++) {
				temp[i] = child[i];
			}
			temp[child.length] = value;
			return;
		}
		//null case
		else {
			Node temp[] = {value};
			child = temp;
		}
	}
	
}

public class LCA
{

	Node root;
	private List<List<Integer>> path1 = new ArrayList<>();
	private List<List<Integer>> path2 = new ArrayList<>();

	// Finds the path from root node to given root of the tree.
	int findLCA(int n1, int n2) {
		path1.clear();
		path2.clear();
		return findLCAInternal(root, n1, n2);
	}

	private int findLCAInternal(Node root, int n1, int n2) {

		if (findPath(root, n1, n2) != 1) {

			return -1;
		}

		Node Answer = root;
		
		while (Answer.parent1 &&  Answer.parent2) {
			for (int i = 0; i < root.child.length; i++) {
				if(Answer.child[i].parent1 &&  Answer.child[i].parent2) {
					Answer = Answer.child[i];
					break;
				}
			}
		}

		return Answer.data;
	}

	// Finds the path from root node to given root of the tree, Stores the
	// path in a vector path[], returns true if path exists otherwise false
	private int findPath(Node root, int n, int m)
	{
		Boolean found1 = false;
		Boolean found2 = false;
		if(root.data == n) {
			found1 =true;
			return 1;
		}
		if(root.data == m) {
			found2 =true;
			return 2;
		}

		for (int i = 0; i < root.child.length; i++) {
			int j = findPath(root.child[i], n , m);
			if(j == 1) {
				root.parent1 = true;
			}
			if(j == 2) {
				root.parent2 = true;
			}

		}
		if (found1 && found2) {
			return 1;
		}

		return 0;
	}

	// Driver code
	public static void main(String[] args)
	{
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.addNode(2);

	}
}