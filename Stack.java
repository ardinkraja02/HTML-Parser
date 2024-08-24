
public class Stack {

	Node head;
	
	
	public Stack() {
		head = null;
		
	}
	//adds to the front of the list
	public void push(String name) {
		Node n = new Node(name);
		
		if (isEmpty() == true) {
			head = n;
			return;
		}
		n.next = head;
		head = n;
		
		
	}
	//removes from the front of the list and returns the name
	public String pop() {
		if (head == null) return null;
		
		Node n = head; 
		head = head.next;
		return n.name;
		
	}
	//checks if the list is empty
	public boolean isEmpty() {
		if (head == null)return true;
		return false;
	}
	public String peek() {
		if (head == null) {
			head.name = " ";
		}
		return head.name;
	}
}
