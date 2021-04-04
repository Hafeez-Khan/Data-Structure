package stack_using_linkedList;

public class StackLinked {

	static Node head;
	static int size = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLinked list = new StackLinked();
		list.push(5);
		list.push(6);
		list.push(7);
		list.pop();
		list.pop();
		list.pop();
		list.pop();
		list.pop();
		list.push(5);
		list.pop();
		list.push(20);
		list.show();
		peek();
	}
	
	public static boolean isEmpty() {
		return size == 0;
	}
	
	public static int size() {
		return size;
	}
	
	public static void peek() {
		Node n = head;
		System.out.println(n.data);
	}
	
	
	public static void push(int data) {
		Node new_node = new Node();
		new_node.data = data;
		new_node.next = null;
		
		if(head == null) {
			head = new_node;
		}else {
			new_node.next = head;
			head = new_node;
		}
		size++;
		
	}
	
	public static void pop() {
		size--;
		if(size <= 0) {
			head = null;
			size = 0;
			//System.out.print(head.next);
			return;
		}
		Node n = head;
		Node n1 =n.next;
		
		head = n1;
	}
	
	public static void show() {
		
		if(head == null) {
			System.out.print("null ");
			return;
		}
		Node n = head;
		
		while(n.next != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println(n.data);
	}

}
