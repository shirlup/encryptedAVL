
/* Class AVLTree */
class AVLTree
{
	private AVLNode root;

	/* Constructor */
	public AVLTree(){
		root = null;
	}
	/* Function to check if tree is empty */
	public boolean isEmpty(){
		return root==null;
	}
	/* Make the tree logically empty */
	public void makeEmpty(){
		root = null;
	}
	/* Function to insert data */
	public void insert(Comparable data){
		root = insert(data, root);
	}
	
	/* Function to get height of node */
	private int height(AVLNode t){
		if (t == null) {
			return -1;
		}
		return t.height;
	}
		   
	/* Function to max of left/right node */
	private int max(int lhs, int rhs){
		if (lhs < rhs) { //if the height of the tree rooted in left is smaller than the right one
			return rhs;
		} else //if the height of the tree rooted in left is bigger than the right one
			return lhs;
	}
	
	/* Function to insert data recursively */
	private AVLNode insert(Comparable x, AVLNode t){
		if (t == null)
			t = new AVLNode(x);
		else if (x.compareTo(t.data) > 0) {
			t.right = insert(x, t.right);
			if (height(t.right) - height(t.left) == 2) {
				if (x.compareTo(t.right.data) > 0)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
			}
		} else if (x.compareTo(t.data) < 0) {
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2) {
				if (x.compareTo(t.left.data) < 0)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
			}
		}
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	/* Rotate binary tree node with left child */
	private AVLNode rotateWithLeftChild(AVLNode k2) {
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	/* Rotate binary tree node with right child */
	private AVLNode rotateWithRightChild(AVLNode k1) {
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child
	 */
	private AVLNode doubleWithLeftChild(AVLNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child
	 */
	private AVLNode doubleWithRightChild(AVLNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	/* Functions to count number of nodes */
	public int countNodes() {
		if (root == null) {
			return 0;
		}
		return countNodes(root);
	}

	private int countNodes(AVLNode r) {
		int leftHeight= 0;
		int rightHeight = 0;
		if (r.left != null) {
			leftHeight= countNodes(r.left);
		}
		if (r.right != null) {
			rightHeight = countNodes(r.left);
		}
		return rightHeight + leftHeight + 1;
	}

	/* Functions to search for an element */
	public boolean search(Comparable val)
	{
		return search(root, val);
	}
	private boolean search(AVLNode r, Comparable val){

		boolean found = false;
		if (r != null)
		{
			Comparable s = r.data;
			if ( val.compareTo(s) == 0 )		
				found = true; 
			else if (val.compareTo(s) < 0 )
				found = search(r.left,val);
			else
				found = search(r.right,val);	
		}		
		return found;
	}
	

	public Pair <int[],Integer> getPrivateKey(String sIndex) {
		return getPrivateKey(root,sIndex);
	}

	private Pair <int[],Integer> getPrivateKey(AVLNode r, String sIndex) {
		if(r!=null)
		{
			if ( ((DataOfMagic)(r.data)).getRiddle().compareTo(sIndex) > 0)
			{
				return getPrivateKey(r.left,sIndex);
			}
			if( ((DataOfMagic)(r.data)).getRiddle().compareTo(sIndex) < 0)	
			{
				return getPrivateKey(r.right,sIndex);
			}
			else 
			{
				Integer n = new Integer(root.height-r.height+1);
				Pair<int[], Integer> pair = new Pair<int[], Integer>(((DataOfMagic)(r.data)).getPrivateKey(),n);	
				return pair;
			}
		}
		return null;	
	}	
} 
