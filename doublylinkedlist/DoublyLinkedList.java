package doublylinkedlist;

public class DoublyLinkedList {
	public DllNode head;
	public int size;
	
	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		System.out.println(list.isEmpty());
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.show();
		System.out.println(list.isEmpty());
		
	}
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
	public void insertAtEnd(int data) {
		DllNode n1 = new DllNode(data);
		
		if (head == null) {
			head = n1;
			return;
		}else {
			DllNode runner = head;
			
			while(runner.next !=null) {
				runner = runner.next;
			}
			runner.next = n1;
			n1.prev = runner;
		}
	}
	public void show() {
		DllNode runner = head;
		while(runner.next != null) {
			System.out.print(runner.value + " ");
			runner = runner.next;
		}
		System.out.print(runner.value);
		System.out.println();
	}

}
