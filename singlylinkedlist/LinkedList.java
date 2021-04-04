package singlylinkedlist;

public class LinkedList {
	
	static Node head;
	int size = 0;

 	public static void main(String[] args) {
		//linkedlist is 0 based hence when you enter names u start from zero
		LinkedList link = new LinkedList();
		link.insertAtEnd(0);
		link.insertAtEnd(1);
		link.insertAtEnd(2);
		link.insertAtEnd(3);
		link.insertAtEnd(4);
		link.insertAtEnd(49);
		link.insertAt(3, 33);
		link.show();
		head = link.reverse();
		link.show();
		//System.out.println("head.next.value: " +head.next.value);
		
	}
	
	public Node reverse() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		
		return head;
	}
	
	// head -> 5 -> 3 -> 6 -> 8 -> null
	public void deleteAt(int pos) {
		Node runner = head;
		if(pos == 0) {
			head = head.next;
			return;
		}
		int count = 0;
		while(count <= pos-1) {
			count++;
			runner = runner.next;
		}
		runner.next = runner.next.next;
	}
	
	public void insertAtEnd(int val) {
		Node n1 = new Node(val);
		n1.next = null;
		
		Node runner = head;
		
		if(head == null){
			head = n1;
			size++;
			return;
		}
		while(runner.next != null) {
			runner = runner.next;
			
		}
		runner.next = n1;
		size++;
	}
	
	public void insertAt(int pos, int val) {
		Node n1 = new Node(val);
		n1.next = null;
		if(pos > size) {
			System.out.println("value " + val + " is out of index" );
			return;
		}
		Node runner = head;
		int count = 0;
		
		if(head == null) {
			head = n1;
			size++;
			return;
		}
		
		while(count < pos-1) {
			count++;
			runner = runner.next;
		}
		
		n1.next = runner.next;
		runner.next = n1;
		size++;
	}
	
	public int get(int pos) {
		Node runner = head;
		int count = 0;
	
		if(head == null) {
			System.out.println("list is empty");
			return -1;
		}
		
		while(count < pos) {
			count++;
			runner = runner.next;
		}
		System.out.println("The value you were looking for is " + runner.value);
		return runner.value;
		
	}
	
	public void show() {
		Node runner = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		
		while(runner.next != null) {
			System.out.print(runner.value + " ");
			runner = runner.next;
		}
		System.out.print(runner.value);		
		System.out.println();
	}
	
	public void size() {
		System.out.println("Size of linkedlist is: " + size);
	}

}
