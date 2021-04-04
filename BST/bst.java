package BST;
import java.util.*;

public class bst {

	//given the root node add a value to the BST, duplicates wont get added
	public Node insert(Node root, int val) {
		Node runner = root;
		if(runner == null) {
			Node n = new Node(val);
			runner = n;
			return runner;
		}
		if(val <= runner.value) {
			runner.left = insert(runner.left,val);
		
		}else if(val > runner.value) {
			runner.right = insert(runner.right, val);	
		}
		return runner;
	}
	
	public Node delete(Node root,int value) {
		//base case
		if(root == null) {
			return root;
		}
		//if root doesn't equal null we traverse to find the value
		if(value < root.value) {
			root.left = delete(root.left,value);
		}
		else if(value > root.value) {
			root.right = delete(root.right,value);
		}
		//we come to the else case once we have found the value to delete
		else {
			//node with one child or no children
			//node has one child on the right or no child 
			if(root.left == null) {
				return root.right;
			}
			//node has one child on the left
			else if(root.right == null) {
				return root.left;
			}
			//node has two child: get the minimum value of the right subtree
			root.value = minValue(root.right);
			//??WHAT THE FUCK DOES THIS DO??
			root.right = delete(root.right,root.value);
		}
		return root;
	}
	
	public int minValue(Node root) {
		int minv = root.value;
		
		while(root.left != null) {
			minv = root.left.value;
			root = root.left;
		}
		return minv;
	}

	public static void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);
	}
	
	//values from largest to smallest
	public static void inDescending(Node root) {
		if(root==null) {
			return;
		}
		inDescending(root.right);
		System.out.print(root.value + " ");
		inDescending(root.left);
	}
	
	public static void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.value + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void preOrderWithoutRecursion(Node root) {
		if(root==null) return;

		Stack<Node>s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()) {
			Node curr = s.pop();
			System.out.print(curr.value + " ");
			if(curr.right!=null) s.push(curr.right);
			if(curr.left!=null) s.push(curr.left);
		}
	}
	
	public static void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.value + " ");
	}
	
	public static boolean containsIterative(Node root, int val) {
		if(root == null) return false;
		
		boolean isPresent = false;
		while(root!=null) {
			if(val < root.value) {
				root = root.left;
			}else if(val > root.value) {
				root = root.right;
			}else {
				isPresent = true;
				break;
			}
		}
		System.out.println(isPresent);
		return isPresent;
	}
	
	public static int getNumberOfNodes(Node root) {
		int count = 0;
		if(root == null) {
			return 0;
		}
		count = 1 + getNumberOfNodes(root.left) + getNumberOfNodes(root.right);
		return count;
	}
	
	public static int getSum(Node root) {
		int sum;
		if(root == null) {
			return 0;
		}
		sum = root.value + getSum(root.left) + getSum(root.right);
		return  sum;
	}
	
	public static int getNumberOfLeafNodes(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return getNumberOfLeafNodes(root.left) + getNumberOfLeafNodes(root.right);
	}
	
	public static boolean contains(Node root, int val) {
		Node runner = root;
		if(runner == null) return false;
		if(runner.value == val) return true;
		if(runner.value > val) {
			contains(root.left,val);
		}else if(runner.value < val) {
			contains(root.right,val);
		}
		return false;
	}
	
	public static int getHeightOfNode(Node root) {
		if(root == null) {
			return -1;
		}
		return Math.max(getHeightOfNode(root.left),getHeightOfNode(root.right)) + 1;
	}
	
	public static void levelOrderTraversal(Node root) {
		if(root==null) return;
		Queue<Node>q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node current = q.peek();
			System.out.print(current.value + " ");
			if(current.left!=null) {
				q.add(current.left);
			}
			if(current.right!=null) {
				q.add(current.right);		
			}
			q.remove(current);  
		}
	}
	
	public static void reverseLevelOrderTraversal(Node root) {
		if(root == null) return;
		
		int height = getHeightOfNode(root);
		
		for(int i=height; i>=0; i--) {
			printAtGivenLevel(root,i+1);
			System.out.println();
		}
	}
	
	public static void printAtGivenLevel(Node root, int level) {
		if(root==null) return;
		if(level == 1) {
			System.out.print(root.value + " ");
			return;
		}
		printAtGivenLevel(root.left,level-1);
		printAtGivenLevel(root.right,level-1);
	}

	public static void main(String[] args) {
		bst tree = new bst();
		Node root = null;
		root = tree.insert(root, 2);
		root = tree.insert(root, 1);
		root = tree.insert(root, 7);
		root = tree.insert(root, 5);
		root = tree.insert(root, 9);
		root = tree.insert(root, 4);
		root = tree.insert(root, 6);
		root = tree.insert(root, 11);
		System.out.println("Sum of Binary Tree: " +getSum(root));
		//inOrder(root);
		System.out.println("Number of nodes: " + getNumberOfNodes(root));
		System.out.println("Number of leaf nodes: " + getNumberOfLeafNodes(root));
		System.out.println("Height of tree: " + getHeightOfNode(root));
		System.out.println("Level order traversal: ");
		levelOrderTraversal(root);
		System.out.println();
		System.out.print("Printing at level  ");
		printAtGivenLevel(root,4);
		System.out.println();
		reverseLevelOrderTraversal(root);
		System.out.println();
		preOrderWithoutRecursion(root);

	}
}
