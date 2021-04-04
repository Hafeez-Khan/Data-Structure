package doublylinkedlist;

public class DllNode {
	int value;
	DllNode next;
	DllNode prev;
	
	public DllNode(int val) {
		value = val;
		next = null;
		prev = null;
	}
	public DllNode(DllNode p,int val, DllNode n) {
		value = val;
		next = n;
		prev = p;
	}
}
